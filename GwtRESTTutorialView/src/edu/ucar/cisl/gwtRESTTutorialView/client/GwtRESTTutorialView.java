package edu.ucar.cisl.gwtRESTTutorialView.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Tree.Resources;
import edu.ucar.cisl.gwtRESTTutorialView.client.bean.EmployeeItemData;
import edu.ucar.cisl.gwtRESTTutorialView.client.bean.ItemData;
import edu.ucar.cisl.gwtRESTTutorialView.client.bean.OrganizationItemData;
import edu.ucar.cisl.gwtRESTTutorialView.client.callback.EmployeeRpcCallback;
import edu.ucar.cisl.gwtRESTTutorialView.client.callback.OrganizationRpcCallback;
import edu.ucar.cisl.gwtRESTTutorialView.client.callback.RestServiceRpcCallback;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtRESTTutorialView implements EntryPoint, 
	SelectionHandler<TreeItem>, OpenHandler<TreeItem> {
	final static String contentType="application/json";

	public void onModuleLoad() {
		TreeItem root = new TreeItem("Root");
		ItemData iData = new OrganizationItemData();
		iData.setId(1);
		root.setUserObject(iData);
		TreeItem dummyItem = root.addItem("");
		dummyItem.setVisible(false);
		Tree tree = new Tree((Resources) GWT.create(OrgTreeResource.class), true);
		tree.addItem(root);
		tree.addSelectionHandler(this);
		tree.addOpenHandler(this);
		RootPanel.get().add(tree);
		root.setState(true, true);
	}


	public void onSelection(SelectionEvent<TreeItem> event) {
		TreeItem item=event.getSelectedItem();
		ItemData iData = (ItemData) item.getUserObject();
		if (iData.isDataReady()) {
			int left = item.getAbsoluteLeft() + 50;
			int top = item.getAbsoluteTop() + 30;
			if (iData instanceof EmployeeItemData)
				EmployeePopup.show(left, top, (EmployeeItemData) iData);
			else
				OrganizationPopup.show(left, top, (OrganizationItemData) iData);
		} else
			invokeRESTfulWebService(item, RestServiceRpcCallback.EventType.SELECT_EVENT);		
	}

	public void onOpen(OpenEvent<TreeItem> event) {
		TreeItem item = event.getTarget();
		ItemData iData = (ItemData) item.getUserObject();
		if (!iData.isDataReady()) {
			invokeRESTfulWebService(item, RestServiceRpcCallback.EventType.STATE_CHANGE_EVENT);
		}
		
	}

	protected void invokeRESTfulWebService(TreeItem item, RestServiceRpcCallback.EventType eventType) {
		ItemData iData = (ItemData) item.getUserObject();
		RestServiceRpcCallback callback = null;
		if (iData instanceof EmployeeItemData)
			callback = new EmployeeRpcCallback();
		if (iData instanceof OrganizationItemData)
			callback = new OrganizationRpcCallback();
			
		callback.setEventType(eventType);
		callback.setTreeItem(item);
		RESTfulWebServiceProxyAsync ls = RESTfulWebServiceProxy.Util.getInstance();
		ls.invokeGetRESTfulWebService(iData.buildUri(), contentType, callback);
	}

	
}
