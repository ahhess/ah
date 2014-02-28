package bwbv.rlt.client.domain;

import java.util.Date;

public class Spieler {

	private int id;
	private String passnr;
	private String bezirk;
	private int vnr;
	private String nachname;
	private String vorname;
	private Date geburtsdatum;
	private Date spielerlaubniserteilung;
	private String geschlecht;

	public int getId() {
		return id;
	}

	public Spieler(int id, String passnr, String bezirk, int vnr, String nachname, String vorname, Date geburtsdatum,
			Date spielerlaubniserteilung, String geschlecht) {
		super();
		this.id = id;
		this.passnr = passnr;
		this.bezirk = bezirk;
		this.vnr = vnr;
		this.nachname = nachname;
		this.vorname = vorname;
		this.geburtsdatum = geburtsdatum;
		this.spielerlaubniserteilung = spielerlaubniserteilung;
		this.geschlecht = geschlecht;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassnr() {
		return passnr;
	}

	public void setPassnr(String passnr) {
		this.passnr = passnr;
	}

	public String getBezirk() {
		return bezirk;
	}

	public void setBezirk(String bezirk) {
		this.bezirk = bezirk;
	}

	public int getVnr() {
		return vnr;
	}

	public void setVnr(int vnr) {
		this.vnr = vnr;
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

	public Date getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public Date getSpielerlaubniserteilung() {
		return spielerlaubniserteilung;
	}

	public void setSpielerlaubniserteilung(Date spielerlaubniserteilung) {
		this.spielerlaubniserteilung = spielerlaubniserteilung;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
}
