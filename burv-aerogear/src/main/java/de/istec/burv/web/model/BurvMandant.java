package de.istec.burv.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the BURV_MANDANT database table.
 * 
 */
@Entity
@Table(name="BURV_MANDANT")
public class BurvMandant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MANDANT_ID", unique=true, nullable=false, length=2)
	private String mandantId;

	@Column(unique=true, nullable=false, length=40)
	private String bezeichnung;

//	//bi-directional many-to-many association to BurvBenutzer
//	@ManyToMany
//	@JoinTable(
//		name="BURV_MANDANT_BENUTZER"
//		, joinColumns={
//			@JoinColumn(name="MANDANT_ID", nullable=false)
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="BENUTZER_NR", nullable=false)
//			}
//		)
//	private List<BurvBenutzer> burvBenutzers;
//
//	//bi-directional many-to-one association to BurvRolle
//	@OneToMany(mappedBy="burvMandant")
//	private List<BurvRolle> burvRolles;

	public BurvMandant() {
	}

	public String getMandantId() {
		return this.mandantId;
	}

	public void setMandantId(String mandantId) {
		this.mandantId = mandantId;
	}

	public String getBezeichnung() {
		return this.bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

//	public List<BurvBenutzer> getBurvBenutzers() {
//		return this.burvBenutzers;
//	}
//
//	public void setBurvBenutzers(List<BurvBenutzer> burvBenutzers) {
//		this.burvBenutzers = burvBenutzers;
//	}
//
//	public List<BurvRolle> getBurvRolles() {
//		return this.burvRolles;
//	}
//
//	public void setBurvRolles(List<BurvRolle> burvRolles) {
//		this.burvRolles = burvRolles;
//	}
//
//	public BurvRolle addBurvRolle(BurvRolle burvRolle) {
//		getBurvRolles().add(burvRolle);
//		burvRolle.setBurvMandant(this);
//
//		return burvRolle;
//	}
//
//	public BurvRolle removeBurvRolle(BurvRolle burvRolle) {
//		getBurvRolles().remove(burvRolle);
//		burvRolle.setBurvMandant(null);
//
//		return burvRolle;
//	}

}