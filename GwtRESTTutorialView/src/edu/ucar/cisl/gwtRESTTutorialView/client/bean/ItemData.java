package edu.ucar.cisl.gwtRESTTutorialView.client.bean;

public abstract class ItemData {
	protected int id = -1;
	protected String displayName;
	protected boolean dataReady = false;

	public ItemData() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public boolean isDataReady() {
		return dataReady;
	}

	public void setDataReady(boolean dataReady) {
		this.dataReady = dataReady;
	}

	abstract public String buildUri();
		

}
