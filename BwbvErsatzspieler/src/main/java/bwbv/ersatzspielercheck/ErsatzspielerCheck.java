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

	private String infile = "data/Spielergebnisse__Filter_Meisterschaft__20110208224726.csv";
//	private String rlfile = "data/Vereinsrangliste_NW+NB_Meldung_Vorrunde__20101209.csv";
	private String rlfile = "data/Vereinsrangliste_NW+NB_Meldung_Rueckrunde__20110220200418.csv";
	private String kzVrRr = "R";
	private String sptfile = "data/Spieltage.properties";
	private String outfile = "data/ErsatzspielerCheck.txt";

	private Properties spieltage = new Properties();
	private SpielerMap spielerMap = new SpielerMap();
	private SpielerMap ersatzspielerMap = new SpielerMap();

	// private SpielerMap kritischeErsatzspielerMap = new SpielerMap();

	public static void main(String[] args) {
		try {
			new ErsatzspielerCheck(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ErsatzspielerCheck(String[] args) throws Exception {
		for (int i = 0; i < args.length; i++) {
			if (i == 0)
				infile = args[i];
			else if (i == 1)
				rlfile = args[i];
			else if (i == 2)
				kzVrRr = args[i];
			else if (i == 3)
				sptfile = args[i];
			else if (i == 4)
				outfile = args[i];
		}

		spieltage.load(new FileReader(sptfile));
		spielerMap.load(rlfile, kzVrRr);
		processEinsaetze();
		printErsatzspieler();
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
		ergebnisLoader.load(infile, 1);
	}

	private void getEinsatz(String[] token, int iPassnr, int iMannschaft) {
		// Spieler anhand Passnr suchen
		String passnr = token[iPassnr];
		if (passnr != null && !"".equals(passnr) && !"00000000".equals(passnr)) {
			Spieler spieler = spielerMap.get(passnr);
			if (spieler == null) {
				System.err.println("Passnr <" + passnr + "> nicht gefunden!? Name: " + token[iPassnr + 2] + ", "
						+ token[iPassnr + 3]);
			} else {
				// Einsatz dem Spieler zuordnen
				Einsatz einsatz = new Einsatz();
				int mannschaft = Integer.parseInt(token[iMannschaft]);
				einsatz.setMannschaft(mannschaft);
				einsatz.setDisz(token[28]);
				String ursprTermin = token[9];
				if (ursprTermin != null && !"".equals(ursprTermin)) {
					einsatz.setDatum(ursprTermin);
				} else {
					einsatz.setDatum(token[8]);
				}
				einsatz.setSpieltag(getSpieltagFromDatum(einsatz.getDatum()));
				spieler.addEinsatz(einsatz);

				// Spieler in h�herer Mannschaft als Stammmannschaft eingesetzt?
				if (mannschaft < spieler.getStammMannschaftVR()) {
					ersatzspielerMap.put(spieler.getPassnr(), spieler);
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

	private void printErsatzspieler() {
		System.out.println("Kritische Ersatzspielereinsaetze:");
		FileWriter writer;
		try {
			writer = new FileWriter(outfile);
			for (Spieler spieler : ersatzspielerMap.values()) {
				// mehr als 4 Eins�tze in h�heren Mannschaften sind kritisch
				// if (spieler.getSpieltagsErsatzEinsaetze().size() > 4) {
				int c = 0;
				int sm[] = spieler.getSpTMannschaft();
				for (int i = 0; i < sm.length; i++) {
					if (sm[i] < spieler.getStammMannschaftVR()) {
						c++;
					}
					if (c < 5) {
	
					}
//					System.out.println(spieler);
					writer.write(spieler.toString()+"\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
