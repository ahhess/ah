package bwbv.rlt.client.domain;

import java.util.Date;

public class Verein {

	private int id;
	private int vnr;
	private String prefix;
	private String ort;
	private String bezirk;
	private String namelang;
	private Date created;
	
	private Spieler[] spielers;

	public Verein(int id, int vnr, String prefix, String ort, String bezirk, String namelang, Date created, Spieler[] spielers) {
		super();
		this.id = id;
		this.vnr = vnr;
		this.prefix = prefix;
		this.ort = ort;
		this.bezirk = bezirk;
		this.namelang = namelang;
		this.created = created;
		this.spielers = spielers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVnr() {
		return vnr;
	}

	public void setVnr(int vnr) {
		this.vnr = vnr;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getBezirk() {
		return bezirk;
	}

	public void setBezirk(String bezirk) {
		this.bezirk = bezirk;
	}

	public String getNamelang() {
		return namelang;
	}

	public void setNamelang(String namelang) {
		this.namelang = namelang;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Spieler[] getSpielers() {
		return spielers;
	}

	public void setSpielers(Spieler[] spielers) {
		this.spielers = spielers;
	}

}
