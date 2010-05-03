package bwbv.rlt.model.domain;

import java.util.Date;

@SuppressWarnings("serial")
public class Rlt extends Detail {

	private String ort;
	private String halle;
	private String adresse;
	private String datumtext;
	private Date datum;
	private Date created;
	private Date meldeschluss;
	private RltStatus status;
	private RltKat kat;
	private RltDisziplin[] disziplins;
	
	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getHalle() {
		return halle;
	}

	public void setHalle(String halle) {
		this.halle = halle;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDatumtext() {
		return datumtext;
	}

	public void setDatumtext(String datumtext) {
		this.datumtext = datumtext;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date createdAt) {
		created = createdAt;
	}

	public Date getMeldeschluss() {
		return meldeschluss;
	}

	public void setMeldeschluss(Date meldeschluss) {
		this.meldeschluss = meldeschluss;
	}

	public RltStatus getStatus() {
		return status;
	}

	public void setStatus(RltStatus status) {
		this.status = status;
	}

	public RltKat getKat() {
		return kat;
	}

	public void setKat(RltKat kat) {
		this.kat = kat;
	}

	public RltDisziplin[] getDisziplins() {
		return disziplins;
	}

	public void setDisziplins(RltDisziplin[] disziplins) {
		this.disziplins = disziplins;
	}

}
