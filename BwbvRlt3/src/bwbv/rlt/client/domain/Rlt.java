package bwbv.rlt.client.domain;

import java.util.Date;

public interface Rlt {

	String getId() 			;
	String getRltKat() 		;
	String getRltStatus() 	;
	String getKurzbez() 	;
	String[] getDiszs() 	;
	
	String getTurnierbez() 	;
	String getOrt() 		;
	String getHalle() 		;
	String getAdresse() 	;
	String getDatumtext() 	;
	Date getDatum() 		;
	Date getCreated() 		;
	Date getMeldeschluss() 	;
}
