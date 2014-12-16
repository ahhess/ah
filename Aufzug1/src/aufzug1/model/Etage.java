package aufzug1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andy
 */
public class Etage {

	private static final Logger LOGGER = Logger
			.getLogger(Etage.class.getName());

	private int nr = 0;
	private String label = null;
	private boolean angefordert = false;

	public Etage(int nr, String label) {
		setNr(nr);
		setLabel(label);
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setAngefordert(boolean angefordert) {
		this.angefordert = angefordert;
		LOGGER.log(Level.FINER, "Etage {0}={1}", new Object[] { label,
				angefordert });
		benachrichtige();
	}

	public boolean isAngefordert() {
		return angefordert;
	}

	private List<Beobachter> beobachter = new ArrayList<Beobachter>();

	public void registriere(Beobachter b) {
		beobachter.add(b);
	}

	private void benachrichtige() {
		for (Beobachter b : beobachter)
			b.aktualisiere();
	}

}
