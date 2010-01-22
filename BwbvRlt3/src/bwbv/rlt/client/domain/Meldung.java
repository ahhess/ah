package bwbv.rlt.client.domain;

import java.util.Date;

public class Meldung {

	private int id;
	private int rltId;
	private int spielerId;
	private String disz;
	private int partnerId;
	private Date created;
	private Date confirmed;
	private String confirmer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Meldung(int id, int rltId, int spielerId, String disz, int partnerId, Date created, Date confirmed,
			String confirmer) {
		super();
		this.id = id;
		this.rltId = rltId;
		this.spielerId = spielerId;
		this.disz = disz;
		this.partnerId = partnerId;
		this.created = created;
		this.confirmed = confirmed;
		this.confirmer = confirmer;
	}

	public int getRltId() {
		return rltId;
	}

	public void setRltId(int rltId) {
		this.rltId = rltId;
	}

	public int getSpielerId() {
		return spielerId;
	}

	public void setSpielerId(int spielerId) {
		this.spielerId = spielerId;
	}

	public String getDisz() {
		return disz;
	}

	public void setDisz(String disz) {
		this.disz = disz;
	}

	public int getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Date confirmed) {
		this.confirmed = confirmed;
	}

	public String getConfirmer() {
		return confirmer;
	}

	public void setConfirmer(String confirmer) {
		this.confirmer = confirmer;
	}

}
