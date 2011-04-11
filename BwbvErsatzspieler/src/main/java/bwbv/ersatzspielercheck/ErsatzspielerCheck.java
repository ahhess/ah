package bwbv.ersatzspielercheck;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import bwbv.ersatzspielercheck.CSVLoader;
import bwbv.ersatzspielercheck.SpielerMap;
import bwbv.ersatzspielercheck.model.Einsatz;
import bwbv.ersatzspielercheck.model.Spieler;

public class ErsatzspielerCheck {

	private String CONF = "data/ErsatzspielerCheck.properties";

	private Properties config = new Properties();
	private Properties spieltage = new Properties();
	private SpielerMap spielerMap = new SpielerMap();
	private SpielerMap ersatzspielerMap = new SpielerMap();

	public static void main(String[] args) {
		try {
			new ErsatzspielerCheck(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ErsatzspielerCheck(String[] args) throws Exception {
		config.load(new FileReader(CONF));
		
		for (int i = 0; i < args.length; i++) {
			if (i == 0)
				config.setProperty("infile", args[i]);
			else if (i == 1)
				config.setProperty("vrlVrFile", args[i]);
			else if (i == 2)
				config.setProperty("vrlRrFile", args[i]);
			else if (i == 3)
				config.setProperty("kzVrRr", args[i]);
			else if (i == 4)
				config.setProperty("sptfile", args[i]);
			else if (i == 5)
				config.setProperty("outfile", args[i]);
		}

		//Spieltage: Zuordnung Datum zu Spieltagsnr
		//(Spieltagsnr: 0=SpT1, ..., 4=SpT4a, 5=SpT5, ..., 8=SpT8, 9=SpT8a)
		spieltage.load(new FileReader(config.getProperty("sptfile")));
		
		spielerMap.load(config.getProperty("vrlVrFile"), "V");
		if("R".equals(config.getProperty("kzVrRr")))
			spielerMap.load(config.getProperty("vrlRrFile"), "R");
		
		processEinsaetze();
		checkErsatzspieler();
	}

	private void processEinsaetze() throws IOException {
		System.out.println("lade Spielergebnisse ");
		CSVLoader ergebnisLoader = new CSVLoader() {
			@Override
			void processRow(String[] token) {
				getEinsatz(token, 30, 15); // Heim Passnr1, Mannschaft
				getEinsatz(token, 35, 15); // Heim Passnr2, Mannschaft
				getEinsatz(token, 40, 20); // Gast Passnr1, Mannschaft
				getEinsatz(token, 45, 20); // Gast Passnr2, Mannschaft
			}
		};
		ergebnisLoader.load(config.getProperty("infile"), 1);
	}

	private void getEinsatz(String[] token, int iPassnr, int iMannschaft) {
		// Spieler anhand Passnr suchen
		String passnr = token[iPassnr];
		if (passnr != null && !"".equals(passnr) && !"0".equals(passnr) && !"00000000".equals(passnr)) {
			Spieler spieler = spielerMap.get(passnr);
			if (spieler == null) {
				System.err.println("Spieler zur Passnr <" + passnr 
						+ "> nicht gefunden!? Name: " + 
						token[iPassnr + 2] + ", " +	token[iPassnr + 3]);
			} else {
				// Einsatz dem Spieler zuordnen
				Einsatz einsatz = new Einsatz();
				int mannschaft = Integer.parseInt(token[iMannschaft]);
				einsatz.setMannschaft(mannschaft);
//				einsatz.setDisz(token[28]);
				String ursprTermin = token[9];
				if (ursprTermin != null && !"".equals(ursprTermin)) {
					einsatz.setDatum(ursprTermin);
				} else {
					einsatz.setDatum(token[8]);
				}
				einsatz.setSpieltag(getSpieltagFromDatum(einsatz.getDatum()));
				spieler.addEinsatz(einsatz);

				// Spieler in hoeherer Mannschaft als Stammmannschaft eingesetzt?
				if ("VR".equals(token[6])) { 
					if (mannschaft < spieler.getStammMannschaftVR()) { 
						ersatzspielerMap.put(passnr, spieler);
					}
				} else {
					if (mannschaft < spieler.getStammMannschaftRR()) { 
						ersatzspielerMap.put(passnr, spieler);
					}
				}
			}
		}
	}

	private String getSpieltagFromDatum(String datum) {
		String spieltagDatum = datum.substring(0, 10);
		String spieltag = spieltage.getProperty(spieltagDatum);
		if (spieltag == null) {
			System.err.println("unbekannter SpT:" + spieltagDatum);
		}
		return spieltag;
	}

	/** 
	 * mehr als 4 Einsaetze in hoeheren Mannschaften sind kritisch
	 */
	private void checkErsatzspieler() throws IOException {
		FileWriter writer = new FileWriter(config.getProperty("outfile"));
		for (Spieler spieler : ersatzspielerMap.values()) {
			int mannschaftszaehler[] = new int[9];
			int maxMannschaft = spieler.getStammMannschaftVR();
			for (int spt = 0; spt < 10; spt++) {
				if(spt==5){
					if(spieler.getStammMannschaftRR() > 0){
						maxMannschaft = spieler.getStammMannschaftRR();
					}
					if(!spieler.getVereinRR().equals(spieler.getVereinVR())){
						//zaehler wieder loeschen bei vereinswechsel
						mannschaftszaehler = new int[9];
					}
				}
				int m = spieler.getMannschaftseinsatz()[spt][0];
				int m2 = spieler.getMannschaftseinsatz()[spt][1];
				if (m2 > 0) {
					if((m2 < m && m <= maxMannschaft)
					|| (m2 > m && m2 > maxMannschaft)){
						m = m2;
					}
				}
				if(m > 0){
					if(m > maxMannschaft){
						System.err.println("--> achtung FALSCHEINSATZ: " + spieler);
						writer.write("--> achtung FALSCHEINSATZ: "+spieler+"\n");
					}
					mannschaftszaehler[m]++;
					if(mannschaftszaehler[m] > 4 && m < maxMannschaft){
//						System.out.println("festgespielt: " + spieler);
						writer.write("festgespielt: "+spieler+"\n");
						maxMannschaft = m;
					}
				}
			}
		}
		writer.close();
	}
}
