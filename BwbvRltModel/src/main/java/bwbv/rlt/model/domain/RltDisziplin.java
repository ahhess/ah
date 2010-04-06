package bwbv.rlt.model.domain;

@SuppressWarnings("serial")
public class RltDisziplin extends Detail {

	public RltDisziplin() {
		super();
	}

	public RltDisziplin(Detail detail) {
		super(detail);
	}

	public RltDisziplin(int id, String kurzBez, String langBez) {
		super(id, kurzBez, langBez);
	}

	public RltDisziplin(int id, String kurzBez) {
		super(id, kurzBez);
	}

}
