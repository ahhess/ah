package bwbv.rlt.client.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Rlt implements Serializable {

	private String id;
	private RltKat rltKat;
	private RltStatus rltStatus;
	private String kurzbez;
	private String turnierbez;
	private String ort;
	private String halle;
	private String adresse;
	private String datumtext;
	private Date datum;
	private Date created;
	private Date meldeschluss;
	private String[] disz;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RltKat getRltKat() {
		return rltKat;
	}

	public void setRltKat(RltKat rltkat) {
		this.rltKat = rltkat;
	}

	public RltStatus getRltstatus() {
		return rltStatus;
	}

	public void setRltstatus(RltStatus rltstatus) {
		this.rltStatus = rltstatus;
	}

	public String getKurzbez() {
		return kurzbez;
	}

	public void setKurzbez(String kurzbez) {
		this.kurzbez = kurzbez;
	}

	public String getTurnierbez() {
		return turnierbez;
	}

	public void setTurnierbez(String turnierbez) {
		this.turnierbez = turnierbez;
	}

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

	public String[] getDisz() {
		return disz;
	}

	public void setDisz(String[] disz) {
		this.disz = disz;
	}

}
