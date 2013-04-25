package de.istec.burv.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the BURV_BENUTZER database table.
 * 
 */
@Entity
@Table(name="BURV_BENUTZER")
public class BurvBenutzer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BENUTZER_NR")
	private long benutzerNr;

	@Column(name="ANZAHL_FALSCHE_ANMELDUNGEN")
	private BigDecimal anzahlFalscheAnmeldungen;

	@Column(name="BENUTZER_ID")
	private String benutzerId;

	@Column(name="DATUM_FA")
	private String datumFa;

	private String passwort;

	private String pwerstellt;

	//bi-directional many-to-one association to BurvMandantBenutzer
	@OneToMany(mappedBy="burvBenutzer")
	private List<BurvMandantBenutzer> burvMandantBenutzers;

	public BurvBenutzer() {
	}

	public long getBenutzerNr() {
		return this.benutzerNr;
	}

	public void setBenutzerNr(long benutzerNr) {
		this.benutzerNr = benutzerNr;
	}

	public BigDecimal getAnzahlFalscheAnmeldungen() {
		return this.anzahlFalscheAnmeldungen;
	}

	public void setAnzahlFalscheAnmeldungen(BigDecimal anzahlFalscheAnmeldungen) {
		this.anzahlFalscheAnmeldungen = anzahlFalscheAnmeldungen;
	}

	public String getBenutzerId() {
		return this.benutzerId;
	}

	public void setBenutzerId(String benutzerId) {
		this.benutzerId = benutzerId;
	}

	public String getDatumFa() {
		return this.datumFa;
	}

	public void setDatumFa(String datumFa) {
		this.datumFa = datumFa;
	}

	public String getPasswort() {
		return this.passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getPwerstellt() {
		return this.pwerstellt;
	}

	public void setPwerstellt(String pwerstellt) {
		this.pwerstellt = pwerstellt;
	}

	public List<BurvMandantBenutzer> getBurvMandantBenutzers() {
		return this.burvMandantBenutzers;
	}

	public void setBurvMandantBenutzers(List<BurvMandantBenutzer> burvMandantBenutzers) {
		this.burvMandantBenutzers = burvMandantBenutzers;
	}

	public BurvMandantBenutzer addBurvMandantBenutzer(BurvMandantBenutzer burvMandantBenutzer) {
		getBurvMandantBenutzers().add(burvMandantBenutzer);
		burvMandantBenutzer.setBurvBenutzer(this);

		return burvMandantBenutzer;
	}

	public BurvMandantBenutzer removeBurvMandantBenutzer(BurvMandantBenutzer burvMandantBenutzer) {
		getBurvMandantBenutzers().remove(burvMandantBenutzer);
		burvMandantBenutzer.setBurvBenutzer(null);

		return burvMandantBenutzer;
	}

}