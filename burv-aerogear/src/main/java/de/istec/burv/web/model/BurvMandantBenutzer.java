package de.istec.burv.web.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BURV_MANDANT_BENUTZER database table.
 * 
 */
@Entity
@Table(name="BURV_MANDANT_BENUTZER")
public class BurvMandantBenutzer implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BurvMandantBenutzerPK id;

	//bi-directional many-to-one association to BurvBenutzer
	@ManyToOne
	@JoinColumn(name="BENUTZER_NR", referencedColumnName = "BENUTZER_NR", insertable = false, updatable = false)
	private BurvBenutzer burvBenutzer;

	//bi-directional many-to-one association to BurvMandant
	@ManyToOne
	@JoinColumn(name="MANDANT_ID", referencedColumnName = "MANDANT_ID", insertable = false, updatable = false)
	private BurvMandant burvMandant;

	public BurvMandantBenutzer() {
	}

	public BurvMandantBenutzerPK getId() {
		return this.id;
	}

	public void setId(BurvMandantBenutzerPK id) {
		this.id = id;
	}
	
	public BurvBenutzer getBurvBenutzer() {
		return this.burvBenutzer;
	}

	public void setBurvBenutzer(BurvBenutzer burvBenutzer) {
		this.burvBenutzer = burvBenutzer;
	}

	public BurvMandant getBurvMandant() {
		return burvMandant;
	}

	public void setBurvMandant(BurvMandant burvMandant) {
		this.burvMandant = burvMandant;
	}
	
}