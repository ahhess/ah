package bwbv.rlt.client.domain;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;

public class Rlt extends JavaScriptObject {

	protected Rlt() {}

	public final native String getId() 			/*-{ return this.id; }-*/;
	public final native String getRltKat() 		/*-{ return this.rltkat; }-*/;
	public final native String getRltStatus() 	/*-{ return this.rltstatus; }-*/;
	public final native String getKurzbez() 	/*-{ return this.kurzbez; }-*/;
	public final native String getTurnierbez() 	/*-{ return this.turnierbez; }-*/;
	public final native String getOrt() 		/*-{ return this.ort; }-*/;
	public final native String getHalle() 		/*-{ return this.halle; }-*/;
	public final native String getAdresse() 	/*-{ return this.adresse; }-*/;
	public final native String getDatumtext() 	/*-{ return this.datumtext; }-*/;
	public final native Date getDatum() 		/*-{ return this.datum; }-*/;
	public final native Date getCreated() 		/*-{ return this.created; }-*/;
	public final native Date getMeldeschluss() 	/*-{ return this.meldeschluss; }-*/;
	public final native String[] getDisz() 		/*-{ return this.disz; }-*/;

}
