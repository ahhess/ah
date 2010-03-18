package bwbv.rlt.client;

import java.util.ArrayList;

import bwbv.rlt.model.domain.Rlt;


/**
 * 
 * Like the session in traditional webapps.  
 * In GWT apps client state is managed on the client
 * 
 */
public class ClientState {
	
	private static ClientState instance = new ClientState();
	private String userName;
	private ArrayList<Rlt> rlts;

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

	public ArrayList<Rlt> getRlts() {
		return rlts;
	}

	public void setRlts(ArrayList<Rlt> rlts) {
		this.rlts = rlts;
	}

}
