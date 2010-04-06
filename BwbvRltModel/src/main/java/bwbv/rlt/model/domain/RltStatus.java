package bwbv.rlt.model.domain;

@SuppressWarnings("serial")
public class RltStatus extends Detail {

	public RltStatus() {
		super();
	}

	public RltStatus(Detail detail) {
		super(detail);
	}

	public RltStatus(int id, String kurzBez, String langBez) {
		super(id, kurzBez, langBez);
	}

	public RltStatus(int id, String kurzBez) {
		super(id, kurzBez);
	}

}
