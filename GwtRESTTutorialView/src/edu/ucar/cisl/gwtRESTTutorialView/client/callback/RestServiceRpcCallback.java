package edu.ucar.cisl.gwtRESTTutorialView.client.callback;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.Window; 

public abstract class RestServiceRpcCallback implements AsyncCallback <String> {
	protected TreeItem treeItem;
	public enum EventType {SELECT_EVENT, STATE_CHANGE_EVENT};
	protected EventType eventType;
	
	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public TreeItem getTreeItem() {
		return treeItem;
	}

	public void setTreeItem(TreeItem treeItem) {
		this.treeItem = treeItem;
	}

	public void onSuccess(String result) {
		if (result == null)
			return;
		processResponse(result);
	}

	public void onFailure(Throwable caught) {
		String msg=caught.getMessage();
		if (msg != null)
			Window.alert(msg);
	}
	
	protected abstract void processResponse(String response);	
	
}
