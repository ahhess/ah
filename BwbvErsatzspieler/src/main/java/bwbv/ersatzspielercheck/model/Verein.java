package bwbv.ersatzspielercheck.model;

public class Verein {

	private String nummer;
	private String name;
	private String bezirk;
	
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
	
	@Override
	public String toString() {
		return "Verein=" + name
			//+ " (" + bezirk + ")" 
			+ " (" + nummer + ")"; 
	}
}
