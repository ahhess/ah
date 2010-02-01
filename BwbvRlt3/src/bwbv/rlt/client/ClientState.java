package bwbv.rlt.client;


/**
 * 
 * Like the session in traditional webapps.  
 * In GWT apps client state is managed on the client
 * 
 */
public class ClientState {
	
	private static ClientState instance = new ClientState();
	private String userName;

	private ClientState() {
	}
	
	public static ClientState get() {
		return instance;
	}
	
	public void setUserName(String username) {
		this.userName=username;
	}

	public String getUserName() {
		return userName;
	}

}
