package bwbv.ersatzspielercheck;

import java.io.IOException;
import java.util.HashMap;

import bwbv.ersatzspielercheck.model.Spieler;
import bwbv.ersatzspielercheck.model.Verein;

@SuppressWarnings("serial")
public class SpielerMap extends HashMap<String, Spieler> {

	public HashMap<String, Verein> vereine = new HashMap<String, Verein>();

	public void load(String filename, String kzVrRr) throws IOException {
		System.out.println("lade Spieler ");

		CSVLoader loader;
		if ("R".equalsIgnoreCase(kzVrRr)) {
			loader = new CSVLoader() {
				@Override
				void processRow(String[] token) {

					Spieler spieler = new Spieler();
					spieler.setNachname(token[24]); 
					spieler.setVorname(token[25]); 
					spieler.setPassnr(token[22]);
					try {
						spieler.setStammMannschaftVR(Integer.parseInt(token[13]));
					} catch (NumberFormatException e) {
					}
					try {
						spieler.setStammMannschaftRR(Integer.parseInt(token[14]));
					} catch (NumberFormatException e) {
					}

					String vnr = token[2];
					Verein verein = vereine.get(vnr);
					if (verein == null) {
						verein = new Verein();
						verein.setNummer(vnr);
						verein.setName(token[3]);
						verein.setBezirk(token[1]);
						vereine.put(vnr, verein);
					}
					spieler.setVerein(verein);

					put(spieler.getPassnr(), spieler);
				}
			};
		} else {
			loader = new CSVLoader() {
				@Override
				void processRow(String[] token) {

					Spieler spieler = new Spieler();
					spieler.setNachname(token[21]);
					spieler.setVorname(token[22]);
					spieler.setPassnr(token[19]);
					try {
						spieler.setStammMannschaftVR(Integer.parseInt(token[13]));
					} catch (NumberFormatException e) {
					}

					String vnr = token[2];
					Verein verein = vereine.get(vnr);
					if (verein == null) {
						verein = new Verein();
						verein.setNummer(vnr);
						verein.setName(token[3]);
						verein.setBezirk(token[1]);
						vereine.put(vnr, verein);
					}
					spieler.setVerein(verein);

					put(spieler.getPassnr(), spieler);
				}
			};
		}
		loader.load(filename, 1);

	}

	public HashMap<String, Verein> getVereine() {
		return vereine;
	}

	public void setVereine(HashMap<String, Verein> vereine) {
		this.vereine = vereine;
	}

}
