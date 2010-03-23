package bwbv.rlt.client;

import java.util.ArrayList;

import bwbv.rlt.model.domain.Rlt;

public class ClientState implements ClientStateChangeNotifier {

	private String userName;
	private ArrayList<Rlt> rlts;
	private ArrayList<ClientStateChangeListener> listeners = new ArrayList<ClientStateChangeListener>();

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getUserName() {
		return userName;
	}

	public ArrayList<Rlt> getRlts() {
		return rlts;
	}

	public void setRlts(ArrayList<Rlt> rlts) {
		this.rlts = rlts;
		for (ClientStateChangeListener listener : listeners) {
			listener.onChange(this);
		}
	}

	@Override
	public void addChangeListener(ClientStateChangeListener listener) {
		listeners.add(listener);
	}
}
