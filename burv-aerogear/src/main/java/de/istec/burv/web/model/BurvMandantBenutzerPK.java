package de.istec.burv.web.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the BURV_MANDANT_BENUTZER database table.
 * 
 */
@Embeddable
public class BurvMandantBenutzerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MANDANT_ID", columnDefinition="char", length=2)
	private String mandantId;

	@Column(name="BENUTZER_NR")
	private long benutzerNr;

	public BurvMandantBenutzerPK() {
	}
	public String getMandantId() {
		return this.mandantId;
	}
	public void setMandantId(String mandantId) {
		this.mandantId = mandantId;
	}
	public long getBenutzerNr() {
		return this.benutzerNr;
	}
	public void setBenutzerNr(long benutzerNr) {
		this.benutzerNr = benutzerNr;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BurvMandantBenutzerPK)) {
			return false;
		}
		BurvMandantBenutzerPK castOther = (BurvMandantBenutzerPK)other;
		return 
			this.mandantId.equals(castOther.mandantId)
			&& (this.benutzerNr == castOther.benutzerNr);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.mandantId.hashCode();
		hash = hash * prime + ((int) (this.benutzerNr ^ (this.benutzerNr >>> 32)));
		
		return hash;
	}
}