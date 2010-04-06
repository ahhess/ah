package bwbv.rlt.model.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Detail implements Serializable {
	private int id = 0;
	private String kurzBez = "";
	private String langBez = "";
	
	public Detail() {
	}
	
	public Detail(int id, String kurzBez) {
		this.id = id;
		this.kurzBez = kurzBez;
	}

	public Detail(int id, String kurzBez, String langBez) {
		this.id = id;
		this.kurzBez = kurzBez;
		this.langBez = langBez;
	}

	public Detail(Detail detail) {
		if (detail!=null) {
			this.id = detail.getId();
			this.kurzBez = detail.getKurzBez();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKurzBez() {
		return kurzBez;
	}

	public void setKurzBez(String kurzBez) {
		this.kurzBez = kurzBez;
	}

	public String getLangBez() {
		return langBez;
	}

	public void setLangBez(String langBez) {
		this.langBez = langBez;
	}

	@Override
	public String toString() {
		return getKurzBez()	+ " (" + getId() + ")";
	}

}
