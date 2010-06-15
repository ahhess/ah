package bwbv.rlt.server;

public class RltJsonData {

	private static final String q = "\"";
	private static final String qc = q + ":";
	private static final String qcq = qc + q;
	private static final String cq = "," + q;

	public String getRlts() {

		StringBuffer b = new StringBuffer();
		b.append("[");
		b.append(getRlt("1", false));
		b.append(",");
		b.append(getRlt("2", false));
		b.append(",");
		b.append(getRlt("3", false));
		b.append(",");
		b.append(getRlt("4", false));
		b.append("]");

		return b.toString();
	}

	public String getRlt(String id, boolean full) {

		StringBuffer b = new StringBuffer();
		if (full) 
			b.append(getQuoted("{", "rlt"));
		if ("1".equals(id)) {
			b.append(getQuoted("{", "id", 1));
			b.append(getQuoted(",", "kurzbez", "1. BezRlt NW"));
			b.append(getQuoted(",", "datumtext", "17./18.04.2010"));
			b.append(getDetail(",", "kat", 1, "S", "Senioren"));
			b.append(getDetail(",", "status", 3, "S", "Meldeschluss"));
			b.append(getQuoted(",", "diszs"));
			b.append(getDetail("[", 1, "HE", "Herreneinzel"));
			b.append(getDetail(",", 2, "DE", "Dameneinzel"));
			b.append(getDetail(",", 5, "MX", "Mixed"));
			b.append("]");
			if (full) {
				b.append(getQuoted(",", "langbez", "1. BWBV Bezirksranglistenturnier NW"));
				b.append(getQuoted(",", "ort", "Fellbach"));
				b.append(getQuoted(",", "halle", "Gäuäckersporthalle 2"));
				b.append(getQuoted(",", "adresse", "Bühlstr. 153, 70736 Fellbach"));
				b.append(getQuoted(",", "datum", "2010-04-17"));
				b.append(getQuoted(",", "meldeschluss", "2010-04-07"));
			}
			b.append("}");
		} else if ("2".equals(id)) {
			b.append(getQuoted("{", "id", 2));
			b.append(getQuoted(",", "kurzbez", "2. BezRlt NW"));
			b.append(getQuoted(",", "datumtext", "17./18.05.2010"));
			b.append(getDetail(",", "kat", 1, "S", "Senioren"));
			b.append(getDetail(",", "status", 2, "M", "Meldeoffen"));
			b.append(getQuoted(",", "diszs"));
			b.append(getDetail("[", 3, "HD", "Herrendoppel"));
			b.append(getDetail(",", 4, "DD", "Damendoppel"));
			b.append(getDetail(",", 5, "MX", "Mixed"));
			b.append("]");
			if (full) {
				b.append(getQuoted(",", "langbez", "2. BWBV Bezirksranglistenturnier NW"));
				b.append(getQuoted(",", "ort", "Fellbach"));
				b.append(getQuoted(",", "halle", "Gäuäckersporthalle 2"));
				b.append(getQuoted(",", "adresse", "Bühlstr. 153, 70736 Fellbach"));
				b.append(getQuoted(",", "datum", "2010-05-17"));
				b.append(getQuoted(",", "meldeschluss", "2010-05-07"));
			}
			b.append("}");
		} else if ("3".equals(id)) {
			b.append(getQuoted("{", "id", 3));
			b.append(getQuoted(",", "kurzbez", "3. BezRlt NW"));
			b.append(getQuoted(",", "datumtext", "17./18.06.2010"));
			b.append(getDetail(",", "kat", 1, "S", "Senioren"));
			b.append(getDetail(",", "status", 1, "P", "geplant"));
			b.append(getQuoted(",", "diszs"));
			b.append(getDetail("[", 1, "HE", "Herreneinzel"));
			b.append(getDetail(",", 2, "DE", "Dameneinzel"));
			b.append(getDetail(",", 3, "HD", "Herrendoppel"));
			b.append(getDetail(",", 4, "DD", "Damendoppel"));
			b.append("]");
			if (full) {
				b.append(getQuoted(",", "langbez", "3. BWBV Bezirksranglistenturnier NW"));
				b.append(getQuoted(",", "ort", "Fellbach"));
				b.append(getQuoted(",", "halle", "Gäuäckersporthalle 2"));
				b.append(getQuoted(",", "adresse", "Bühlstr. 153, 70736 Fellbach"));
				b.append(getQuoted(",", "datum", "2010-06-17"));
				b.append(getQuoted(",", "meldeschluss", "2010-06-07"));
			}
			b.append("}");
		} else if ("4".equals(id)) {
			b.append(getQuoted("{", "id", 4));
			b.append(getQuoted(",", "kurzbez", "1. JBezRlt NW"));
			b.append(getQuoted(",", "datumtext", "17./18.07.2010"));
			b.append(getDetail(",", "kat", 2, "J", "Jugend"));
			b.append(getDetail(",", "status", 4, "E", "beendet"));
			b.append(getQuoted(",", "diszs"));
			b.append(getDetail("[", 6, "U15JE", "U15 Jungeneinzel"));
			b.append(getDetail(",", 7, "U15ME", "U15 Mädcheneinzel"));
			b.append("]");
			if (full) {
				b.append(getQuoted(",", "langbez", "1. Jugend-Bezirksranglistenturnier NW"));
				b.append(getQuoted(",", "ort", "Fellbach"));
				b.append(getQuoted(",", "halle", "Gäuäckersporthalle 2"));
				b.append(getQuoted(",", "adresse", "Bühlstr. 153, 70736 Fellbach"));
				b.append(getQuoted(",", "datum", "2010-07-17"));
				b.append(getQuoted(",", "meldeschluss", "2010-07-07"));
			}
			b.append("}");
		}
		if (full) 
			b.append("}");

		return b.toString();
	}

	private String getQuoted(String delim, String key) {
		return delim + q + key + qc;
	}

	private String getQuoted(String delim, String key, String value) {
		return delim + q + key + qcq + value + q;
	}
	
	private String getQuoted(String delim, String key, long value) {
		return delim + q + key + qc + value;
	}
	
	private String getDetail(String delim, long id, String kurzbez, String langbez) {
		//	b.append("[ {\"id\": 1, \"kurzbez\": \"HE\", \"langbez\": \"Herreneinzel\"}");
		return delim + "{" + q + "id" + qc + id 
			+ cq + "kurzbez"+ qcq + kurzbez + q 
			+ cq + "langbez"+ qcq + langbez + q + "}";
	}
	
	private String getDetail(String delim, String name, long id, String kurzbez, String langbez) {
		return getQuoted(delim, name) + getDetail("", id, kurzbez, langbez);
	}

	public static void main(String[] args) {
		RltJsonData data = new RltJsonData();
		System.out.println(data.getRlt("1", true));
		System.out.println(data.getRlts());
	}
}
