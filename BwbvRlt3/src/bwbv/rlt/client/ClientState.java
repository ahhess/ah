package bwbv.rlt.client;

import java.util.ArrayList;
import java.util.HashMap;

import bwbv.rlt.model.domain.Rlt;
import bwbv.rlt.model.domain.RltDisziplin;

public class ClientState {

	public interface ChangeListener {
		public static final String RLTSELECTED_EVENT = "rltSelected";
		public static final String RLTLISTCHANGED_EVENT = "rltListChanged";
		public static final String RLTDISZSCHANGED_EVENT = "rltDiszsChanged";
		public static final String USERCHANGED_EVENT = "userChanged";
		
		public void onChange(String eventName, ClientState clientState);
	}

	private String userName;
	private ArrayList<Rlt> rlts;
	private Rlt currentRlt;
//	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();
	private HashMap<String, ArrayList<ChangeListener>> listenerMap = new HashMap<String, ArrayList<ChangeListener>>();

	public void setUserName(String username) {
		this.userName = username;
		notifyListeners(ChangeListener.USERCHANGED_EVENT);
	}

	public String getUserName() {
		return userName;
	}

	public ArrayList<Rlt> getRlts() {
		return rlts;
	}

	public void setRlts(ArrayList<Rlt> rlts) {
		this.rlts = rlts;
		notifyListeners(ChangeListener.RLTLISTCHANGED_EVENT);
	}

	public Rlt getCurrentRlt() {
		return currentRlt;
	}

	public void setCurrentRlt(Rlt currentRlt) {
		this.currentRlt = currentRlt;
		notifyListeners(ChangeListener.RLTSELECTED_EVENT);
	}
	
	public void setCurrentRltDiszs(RltDisziplin[] diszs) {
		this.currentRlt.setDisziplins(diszs);
		notifyListeners(ChangeListener.RLTDISZSCHANGED_EVENT);
	}
	
//	public void addChangeListener(ChangeListener listener) {
////		listeners.add(listener);
//		addChangeListener("default", listener);
//	}
	
	public void addChangeListener(String eventName, ChangeListener listener) {
		ArrayList<ChangeListener> listeners = listenerMap.get(eventName); 
		if(listeners == null){
			listeners = new ArrayList<ChangeListener>();
			listenerMap.put(eventName, listeners);
		}
		listeners.add(listener);
	}
	
	private void notifyListeners(String eventName) {
		ArrayList<ChangeListener> list = listenerMap.get(eventName);
		if (list != null) {
			for (ChangeListener listener : list) {
				listener.onChange(eventName, this);
			}
		}
	}
}
