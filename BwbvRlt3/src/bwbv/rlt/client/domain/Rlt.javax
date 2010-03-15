package bwbv.rlt.client.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Rlt implements Serializable {

	private static final long serialVersionUID = 6693877993424551642L;
	
	public enum Kat {Senioren, Jugend, AK}
	public enum Status {geplant, meldeoffen, meldeschluss, abgeschlossen}

	private int id;
	private Kat rltkat;
	private Status rltstatus;
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
	private HashMap<String, List<Meldung>> meldungen;

	public Rlt() {
	}

	public Rlt(int id, Kat rltkat, Status rltstatus, String kurzbez, String turnierbez, String ort, String halle,
			String adresse, String datumtext, Date datum, Date created, Date meldeschluss, String[] disz,
			HashMap<String, List<Meldung>> meldungen) {
		super();
		this.id = id;
		this.rltkat = rltkat;
		this.rltstatus = rltstatus;
		this.kurzbez = kurzbez;
		this.turnierbez = turnierbez;
		this.ort = ort;
		this.halle = halle;
		this.adresse = adresse;
		this.datumtext = datumtext;
		this.datum = datum;
		this.created = created;
		this.meldeschluss = meldeschluss;
		this.disz = disz;
		this.meldungen = meldungen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Kat getRltkat() {
		return rltkat;
	}

	public void setRltkat(Kat rltkat) {
		this.rltkat = rltkat;
	}

	public Status getRltstatus() {
		return rltstatus;
	}

	public void setRltstatus(Status rltstatus) {
		this.rltstatus = rltstatus;
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

	public HashMap<String, List<Meldung>> getMeldungen() {
		return meldungen;
	}

	public void setMeldungen(HashMap<String, List<Meldung>> meldungen) {
		this.meldungen = meldungen;
	}

	public List<Meldung> getMeldungen(String disz) {
		if (this.meldungen == null)
			return null;
		else
			return meldungen.get(disz);
	}

	public void setMeldungen(String disz, List<Meldung> meldungen) {
		if (this.meldungen == null) {
			this.meldungen = new HashMap<String, List<Meldung>>();
		}
		this.meldungen.put(disz, meldungen);
	}

	public String[] getDisz() {
		return disz;
	}

	public void setDisz(String[] disz) {
		this.disz = disz;
	}

	@Override
	public String toString() {
		return "Rlt [adresse=" + adresse + ", created=" + created + ", datum=" + datum + ", datumtext=" + datumtext
				+ ", disz=" + Arrays.toString(disz) + ", halle=" + halle + ", id=" + id + ", kurzbez=" + kurzbez
				+ ", meldeschluss=" + meldeschluss + ", meldungen=" + meldungen + ", ort=" + ort + ", rltkat=" + rltkat
				+ ", rltstatus=" + rltstatus + ", turnierbez=" + turnierbez + "]";
	}

}
