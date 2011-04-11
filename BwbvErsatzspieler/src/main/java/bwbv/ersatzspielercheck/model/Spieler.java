package bwbv.ersatzspielercheck.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Spieler {

	private String passnr;
	private String nachname;
	private String vorname;
	private int stammMannschaftVR = 0;
	private int stammMannschaftRR = 0;
	private Verein vereinVR;
	private Verein vereinRR;
	private int[][] mannschaftseinsatz = new int[10][2];
	private Map<String, List<Einsatz>> spieltagsEinsaetze = new HashMap<String, List<Einsatz>>();

	public Spieler(String passnr, String nachname, String vorname) {
		super();
		this.passnr = passnr;
		this.nachname = nachname;
		this.vorname = vorname;
	}

	public void addEinsatz(Einsatz einsatz) {
		// einsaetze je datum-uhrzeit sammeln --> doppel + einzel nur 1 mannschaftseinsatz
		List<Einsatz> spTEinsaetze = spieltagsEinsaetze.get(einsatz.getDatum());
		if (spTEinsaetze == null) {
			spTEinsaetze = new ArrayList<Einsatz>();
			spieltagsEinsaetze.put(einsatz.getDatum(), spTEinsaetze);
			try {
				int spTnr = Integer.parseInt(einsatz.getSpieltag());
				if (mannschaftseinsatz[spTnr][0] == 0) {
					mannschaftseinsatz[spTnr][0] = einsatz.getMannschaft();
				} else {
					if (mannschaftseinsatz[spTnr][1] == 0) {
						mannschaftseinsatz[spTnr][1] = einsatz.getMannschaft();
					}
				}
			} catch (NumberFormatException e) {
				System.err.println(e.toString() + ": " + this + " : " + einsatz);
			}
		}
		spTEinsaetze.add(einsatz);
	}

	@Override
	public String toString() {
		return "Spieler " + "[passnr=" + passnr + ", nachname=" + nachname + ", vorname=" + vorname
				+ ", mannschaftseinsatz=" + mannschaftseinsatzToSting() + ", " + vereinVR
				+ ", stammMannschaftVR=" + stammMannschaftVR + ", " + vereinRR + ", stammMannschaftRR="
				+ stammMannschaftRR + ", " + spieltagsEinsaetze + "]";
	}

	private String mannschaftseinsatzToSting() {
		String s="[";
		for(int i = 0;i<10;i++){
			s += "[" + mannschaftseinsatz[i][0] + "," + mannschaftseinsatz[i][1] + "],"; 	
		}
		return s+"]";
	}
	
	public String getPassnr() {
		return passnr;
	}

	public void setPassnr(String passnr) {
		this.passnr = passnr;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public int getStammMannschaftVR() {
		return stammMannschaftVR;
	}

	public void setStammMannschaftVR(int mannschaft) {
		this.stammMannschaftVR = mannschaft;
		// this.maxMannschaft = mannschaft;
	}

	public int getStammMannschaftRR() {
		return stammMannschaftRR;
	}

	public void setStammMannschaftRR(int mannschaft) {
		this.stammMannschaftRR = mannschaft;
	}

	public Verein getVereinVR() {
		return vereinVR;
	}

	public void setVereinVR(Verein verein) {
		this.vereinVR = verein;
	}

	public Verein getVereinRR() {
		return vereinRR;
	}

	public void setVereinRR(Verein verein) {
		this.vereinRR = verein;
	}

	public Map<String, List<Einsatz>> getSpieltagsEinsaetze() {
		return spieltagsEinsaetze;
	}

	public int[][] getMannschaftseinsatz() {
		return mannschaftseinsatz;
	}

}
