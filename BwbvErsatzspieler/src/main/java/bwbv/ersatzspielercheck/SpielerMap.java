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
					Spieler spieler = getSpieler(token[22], token[24], token[25]);
					Verein verein = getVerein(token[2], token[3], token[1]);					
					try {
						spieler.setStammMannschaftVR(Integer.parseInt(token[13]));
						spieler.setVereinVR(verein);
					} catch (NumberFormatException e) {
						// ok, spieler kann nur rr-verein haben
					}
					try {
						spieler.setStammMannschaftRR(Integer.parseInt(token[14]));
						spieler.setVereinRR(verein);
					} catch (NumberFormatException e) {
						// ok, spieler kann nur vr-verein haben
					}
					put(spieler.getPassnr(), spieler);
				}
			};
		} else {
			loader = new CSVLoader() {
				@Override
				void processRow(String[] token) {
					Spieler spieler = getSpieler(token[19], token[21], token[22]);
					Verein verein = getVerein(token[2], token[3], token[1]);
					try {
						spieler.setStammMannschaftVR(Integer.parseInt(token[13]));
						spieler.setVereinVR(verein);
					} catch (NumberFormatException e) {
						System.err.println("ungueltige StammMannschaftVR: " +
								spieler.getNachname() + ", "  +
								spieler.getVorname() + ": " + e);
					}
					put(spieler.getPassnr(), spieler);
				}
			};
		}
		loader.load(filename, 1);

	}

	private Spieler getSpieler(String passnr, String nachname, String vorname) {
		Spieler spieler = get(passnr);
		if(spieler == null){
			spieler = new Spieler(passnr, nachname, vorname);
		}
		return spieler;
	}

	private Verein getVerein(String vnr, String name, String bezirk) {
		Verein verein = vereine.get(vnr);
		if (verein == null) {
			verein = new Verein(vnr, name, bezirk);
			vereine.put(vnr, verein);
		}
		return verein;
	}

	public HashMap<String, Verein> getVereine() {
		return vereine;
	}

	public void setVereine(HashMap<String, Verein> vereine) {
		this.vereine = vereine;
	}

}
