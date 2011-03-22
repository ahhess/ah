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
	private int stammMannschaftVR = -1;
	private int stammMannschaftRR = -1;
	private Verein vereinVR;
	private Verein vereinRR;
	private int[] spTMannschaft = {0,0,0,0,0,0,0,0,0,0};
	
//	private List<Einsatz> einsaetze = new ArrayList<Einsatz>();
	private Map<String, List<Einsatz>> spieltagsEinsaetze = new HashMap<String, List<Einsatz>>();
//	private Map<String, Integer> spieltagsErsatzEinsaetze = new HashMap<String, Integer>();
//	<private List<Einsatz> falschEinsaetze = new ArrayList<Einsatz>();

	public void addEinsatz(Einsatz einsatz) {
//		einsaetze.add(einsatz);
		String spT = einsatz.getSpieltag();
		List<Einsatz> spTEinsaetze = spieltagsEinsaetze.get(spT);
		if(spTEinsaetze==null){
			spTEinsaetze = new ArrayList<Einsatz>();
			spieltagsEinsaetze.put(spT, spTEinsaetze);
		}
		spTEinsaetze.add(einsatz);

		// je SpT den Einsatz in der höchsten Mannschaft merken
//		Integer mSpt = spieltagsErsatzEinsaetze.get(spT);
//		if (mSpt == null || mSpt > einsatz.getMannschaft()) {
//			spieltagsErsatzEinsaetze.put(einsatz.getSpieltag(), einsatz.getMannschaft());
			try {
				int spTnr = Integer.parseInt(spT);
				spTMannschaft[spTnr]=einsatz.getMannschaft();
			} catch (NumberFormatException e) {
//				e.printStackTrace();
				System.err.println(e.toString()+": "+einsatz.getMannschaft()+": "+einsatz+": "); 
			}
//		}
//		int m = einsatz.getMannschaft();
//		if(m < maxMannschaft) {
//			spTMannschaft[m]++;
//			for(int i=maxMannschaft;i>0;i--){
//				if(spTMannschaft[i]>4){
//					maxMannschaft=i;
//				}
//			}
//		}
		// geht nicht wg. reihenfolge
//		if(m > maxMannschaft) {
//			falschEinsaetze.add(einsatz);
//			System.err.println("Falscheinsatz: " + this);
//		}
	}

	
	@Override
	public String toString() {
		return "Spieler " +
			"[" + vereinVR +
			", nachname=" + nachname + 
			", vorname=" + vorname + 
			", passnr=" + passnr + 
			", stammMannschaftVR=" + stammMannschaftVR + 
			", stammMannschaftRR=" + stammMannschaftRR + 
			", spTMannschaft=" + Arrays.toString(spTMannschaft) +
//			", falschEinsaetze=" + falschEinsaetze.size() + ": " + falschEinsaetze +
//			", spieltagsErsatzEinsaetze=" + spieltagsErsatzEinsaetze.size() + ": " 
//			+ sortedSpieltagsErsatzEinsaetzeToString() +
			", " + spieltagsEinsaetze +
			"]";
	}
	
//	public String sortedSpieltagsErsatzEinsaetzeToString() {
//		List<String> keys = new ArrayList<String>();
//		keys.addAll(spieltagsErsatzEinsaetze.keySet());
//		Collections.sort(keys);
//		String ret = "[";
//		for (String key : keys) {
//			ret += key + "=" + spieltagsErsatzEinsaetze.get(key) + ", ";
//		}
//		return ret.substring(0, ret.length()-2) + "]"; // ohne letztes ","
//	}
	
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
//		this.maxMannschaft = mannschaft;
	}
	
	public int getStammMannschaftRR() {
		return stammMannschaftRR;
	}
	
	public void setStammMannschaftRR(int mannschaft) {
		this.stammMannschaftRR = mannschaft;
	}

//	public int getMaxMannschaft() {
//		return maxMannschaft;
//	}
//
//	public void setMaxMannschaft(int mannschaft) {
//		this.maxMannschaft = mannschaft;
//	}

//	public List<Einsatz> getEinsaetze() {
//		return einsaetze;
//	}
//
//	public void setEinsaetze(List<Einsatz> einsaetze) {
//		this.einsaetze = einsaetze;
//	}

//	public Map<String, Integer> getSpieltagsErsatzEinsaetze() {
//		return spieltagsErsatzEinsaetze;
//	}
//
//	public void setSpieltagsErsatzEinsaetze(Map<String, Integer> spieltagsEinsaetze) {
//		this.spieltagsErsatzEinsaetze = spieltagsEinsaetze;
//	}

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


	public int[] getSpTMannschaft() {
		return spTMannschaft;
	}
		
}
