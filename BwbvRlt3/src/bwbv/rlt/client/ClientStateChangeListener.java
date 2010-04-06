package bwbv.rlt.client;

public interface ClientStateChangeListener {
	public void onChange(ClientState clientState);
	public void onRltSelected(ClientState clientState);
}
