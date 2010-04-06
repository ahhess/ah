package bwbv.rlt.model.domain;

@SuppressWarnings("serial")
public class RltKat extends Detail {

	public RltKat() {
		super();
	}

	public RltKat(int id, String kurzBez, String langBez) {
		super(id, kurzBez, langBez);
	}

	public RltKat(int id, String kurzBez) {
		super(id, kurzBez);
	}

	public RltKat(Detail detail) {
		super(detail);
	}
	
}
