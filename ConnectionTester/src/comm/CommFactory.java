package comm;

import comm.serial.SerialComm;

public class CommFactory {

	public final static String SERIAL = "SERIAL";
	public final static String SOCKET = "SOCKET";
	public final static String SERVERSOCKET = "SERVERSOCKET";
	
//	private static CommFactory commFactory = new CommFactory();
	
	private CommFactory() {
	}
	
	public static IComm getComm(String name) {
		if (SERIAL.equals(name))
			return new SerialComm();
		
		return null;
	}
}
