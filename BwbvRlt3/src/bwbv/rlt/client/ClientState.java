package bwbv.rlt.client;

import bwbv.rlt.client.domain.Options;

/**
 * 
 * Like the session in traditional webapps.  
 * In GWT apps client state is managed on the client
 * 
 */
public class ClientState {
	private String userName;
	private Options userOptions;
	
	public void setUserName(String username) {
		this.userName=username;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserOptions(Options userOptions) {
		this.userOptions = userOptions;
	}

	public Options getUserOptions() {
		return userOptions;
	}
	
}
