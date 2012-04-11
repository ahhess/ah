package bwbv.ersatzspielercheck.model;

import bwbv.ersatzspielercheck.SpielerMap;

public class Verein {

	private String nummer;
	private String name;
	private String bezirk;
	/** Map mit Spielern dieses Vereins */
	private SpielerMap spielerMap = new SpielerMap(); 

	public Verein() {
	}
	
	public Verein(String nummer, String name, String bezirk) {
		this.nummer = nummer;
		this.name = name;
		this.bezirk = bezirk;
	}
	
	public String getNummer() {
		return nummer;
	}
	public void setNummer(String nummer) {
		this.nummer = nummer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBezirk() {
		return bezirk;
	}
	public void setBezirk(String bezirk) {
		this.bezirk = bezirk;
	}

	public SpielerMap getSpielerMap() {
		return spielerMap;
	}

	public void setSpielerMap(SpielerMap spielerMap) {
		this.spielerMap = spielerMap;
	}
	
	@Override
	public String toString() {
		return "<Verein name=\"" + name
			//+ " (" + bezirk + ")" 
			+ "\" nr=\"" + nummer + "\"/>"; 
	}
}
