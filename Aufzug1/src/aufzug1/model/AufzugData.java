package aufzug1.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andy
 */
public class AufzugData {

    private static final Logger LOGGER = Logger.getLogger(AufzugData.class.getName());
    
    private Etage etage[];
    private int anzahlEtagen = 0;
    private int aktuelleEtagennr = 0;
    private int vorigeEtagennr = 0;
    private int zielEtagennr = 0;
    private boolean tuereZu = true;
    private boolean aufzugInEtage = true;

    public AufzugData(int anzahlEtagen) {
        LOGGER.log(Level.FINER, "init anzahlEtagen={0}", anzahlEtagen);
        this.anzahlEtagen = anzahlEtagen;
        etage = new Etage[anzahlEtagen];
        for (int i = 0; i < anzahlEtagen; i++) {
            etage[i] = new Etage(i, String.valueOf(i));
        }
    }

    public int getAktuelleEtagennr() {
        return aktuelleEtagennr;
    }

    public void setAktuelleEtagennr(int aktuelleEtagennr) {
        this.aktuelleEtagennr = aktuelleEtagennr;
    }

    public int getAnzahlEtagen() {
        return anzahlEtagen;
    }

    public Etage getEtage(int i) {
        return etage[i];
    }

    public boolean isAufzugInEtage() {
        return aufzugInEtage;
    }

    public void setAufzugInEtage(boolean aufzugInEtage) {
        this.aufzugInEtage = aufzugInEtage;
    }

    public boolean isTuereZu() {
        return tuereZu;
    }

    public void setTuereZu(boolean tuereZu) {
        this.tuereZu = tuereZu;
    }

    public int getVorigeEtagennr() {
        return vorigeEtagennr;
    }

    public void setVorigeEtagennr(int vorigeEtagennr) {
        this.vorigeEtagennr = vorigeEtagennr;
    }

	public int getZielEtagennr() {
		return zielEtagennr;
	}

	public void setZielEtagennr(int zielEtagennr) {
		this.zielEtagennr = zielEtagennr;
	}

	public void setAnzahlEtagen(int anzahlEtagen) {
		this.anzahlEtagen = anzahlEtagen;
	}
        
}
