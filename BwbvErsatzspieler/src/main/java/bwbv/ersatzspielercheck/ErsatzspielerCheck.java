package bwbv.ersatzspielercheck;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import bwbv.ersatzspielercheck.model.Einsatz;
import bwbv.ersatzspielercheck.model.Spieler;

public class ErsatzspielerCheck {
	
	private static Logger logger = Logger.getLogger(ErsatzspielerCheck.class.getName());

	private String CONF = "data/ErsatzspielerCheck.properties";

	private Properties config = new Properties();
	private Properties spieltage = new Properties();
	private SpielerMap spielerMap = new SpielerMap();
	private SpielerMap ersatzspielerMap = new SpielerMap();
	private List<Spieler> festgespielt = new ArrayList<Spieler>();
	private List<Spieler> falschspieler = new ArrayList<Spieler>();

	public static void main(String[] args) {
		try {
			ErsatzspielerCheck e = new ErsatzspielerCheck(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ErsatzspielerCheck(String[] args) throws Exception {
		logger.info("start");

		init(args);
		processEinsaetze();
		checkErsatzspieler();
		
		logger.info("ende.");
	}

	public void init(String[] args) throws IOException, FileNotFoundException {
		logger.info("lade config aus " + CONF);
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
		String filename = config.getProperty("sptfile");
		logger.info("lade Spieltage aus "+filename);
		spieltage.load(new FileReader(filename));
		
		filename = config.getProperty("vrlVrFile");
		logger.info("lade Vorrunden-RL aus "+filename);
		spielerMap.load(filename, "V");
		if("R".equals(config.getProperty("kzVrRr"))) {
			filename = config.getProperty("vrlRrFile");
			logger.info("lade Rückrunden-RL aus "+filename);
			spielerMap.load(filename, "R");
		}
	}

	private void processEinsaetze() throws IOException {
		logger.info("start");
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
				logger.warning("Unbekannte Passnr <" + passnr + 
						"> Name: " + token[iPassnr + 2] + ", " + token[iPassnr + 3]);
				if (passnr != null && passnr.length() > 1){
					//Sonderbehandlung: "A" vor der Passnr entfernen und nochmal probieren
					passnr = passnr.substring(1);
					spieler = spielerMap.get(passnr);
					if (spieler != null) {
						logger.info("Spieler gefunden zu Passnr <" + passnr + 
								">  Name: " + token[iPassnr + 2] + ", " + token[iPassnr + 3]);
					}
				}
			}
			if (spieler != null) {
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
			logger.warning("unbekannter SpT:" + spieltagDatum);
		}
		return spieltag;
	}

	/** 
	 * mehr als 4 Einsaetze in hoeheren Mannschaften sind kritisch
	 */
	private void checkErsatzspieler() throws IOException {
		FileWriter writer = new FileWriter(config.getProperty("outfile"));
		writer.write("<?xml version=\"1.0\" encoding=\""
				+ writer.getEncoding() + "\"?>\n");
		writer.write("<ErsatzspielerCheck>\n");
		for (Spieler spieler : ersatzspielerMap.values()) {
			int mannschaftszaehler[] = new int[9];
			int maxMannschaft = spieler.getStammMannschaftVR();
			for (int spt = 0; spt < 10; spt++) {
				if(spt==5){
					if(spieler.getStammMannschaftRR() < maxMannschaft){
						maxMannschaft = spieler.getStammMannschaftRR();
					}
					if(!spieler.getVereinRR().equals(spieler.getVereinVR())){
						//zaehler wieder loeschen bei vereinswechsel
						mannschaftszaehler = new int[9];
						maxMannschaft = spieler.getStammMannschaftRR();
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
						logger.warning("--> achtung FALSCHEINSATZ: " + spieler);
						writer.write("<FALSCHEINSATZ m=\"" + m + "\" max=\"" + maxMannschaft +   
								"\"> "+spieler+"</FALSCHEINSATZ>\n");
						falschspieler.add(spieler);
					}
					mannschaftszaehler[m]++;
					if(mannschaftszaehler[m] >= 4 && m < maxMannschaft){
//						logger.info("festgespielt: " + spieler);
						writer.write("<festgespielt m=\"" + m + "\" max=\"" + maxMannschaft +   
								"\"> "+spieler+"</festgespielt>\n");
						maxMannschaft = m;
						festgespielt.add(spieler);
					}
				}
			}
		}
		writer.write("</ErsatzspielerCheck>\n");
		writer.close();
	}

	public SpielerMap getSpielerMap() {
		return spielerMap;
	}

	public void setSpielerMap(SpielerMap spielerMap) {
		this.spielerMap = spielerMap;
	}

	public SpielerMap getErsatzspielerMap() {
		return ersatzspielerMap;
	}

	public void setErsatzspielerMap(SpielerMap ersatzspielerMap) {
		this.ersatzspielerMap = ersatzspielerMap;
	}

	public List<Spieler> getFestgespielt() {
		return festgespielt;
	}

	public void setFestgespielt(List<Spieler> festgespielt) {
		this.festgespielt = festgespielt;
	}

	public List<Spieler> getFalschspieler() {
		return falschspieler;
	}

	public void setFalschspieler(List<Spieler> falschspieler) {
		this.falschspieler = falschspieler;
	}
}
