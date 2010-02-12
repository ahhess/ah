package edu.ucar.cisl.gwtRESTTutorialView.client.callback;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.TreeItem;

import edu.ucar.cisl.gwtRESTTutorialView.client.bean.EmployeeItemData;
import edu.ucar.cisl.gwtRESTTutorialView.client.bean.OrganizationItemData;
import edu.ucar.cisl.gwtRESTTutorialView.client.OrganizationPopup;

public class OrganizationRpcCallback extends RestServiceRpcCallback {
	
	protected void processResponse(String response) {
		JSONValue jsonValue = JSONParser.parse(response);
		OrganizationItemData oItemData = (OrganizationItemData) treeItem
				.getUserObject();
		JSONObject jobj = jsonValue.isObject();

		oItemData.setId((int) jobj.get("id").isNumber().doubleValue());
		oItemData.setDataReady(true);
		oItemData.setDisplayName(jobj.get("acronym").isString().stringValue());
		oItemData.setName(jobj.get("name").isString().stringValue());
		oItemData.setLeadName(jobj.get("leadName").isString().stringValue());
		oItemData.setLeadTitle(jobj.get("leadTitle").isString().stringValue());
		oItemData.setTotalEmployees((int) jobj.get("totalEmployees").isNumber().doubleValue());	
		treeItem.setText(oItemData.getDisplayName());
		processEmployees(jobj.get("employees").isArray());
		processSubOrgs(jobj.get("subOrgs").isArray());
		if (getEventType() == EventType.SELECT_EVENT) {
			int left = treeItem.getAbsoluteLeft() + 50;
			int top = treeItem.getAbsoluteTop() + 30;
			OrganizationPopup.show(left, top, (OrganizationItemData) oItemData);
		}

	}

	protected void processSubOrgs(JSONArray jsonArray) {
		for (int i = 0; i < jsonArray.size(); ++i) {
			JSONObject jo = jsonArray.get(i).isObject();
			OrganizationItemData iData = new OrganizationItemData();
			iData.setId((int) jo.get("id").isNumber().doubleValue());
			iData.setDisplayName(jo.get("displayName").isString().stringValue());
			TreeItem child = treeItem.addItem(iData.getDisplayName());
			TreeItem dummy = child.addItem("");
			dummy.setVisible(false);
			child.setUserObject(iData);
		}
	}

	protected void processEmployees(JSONArray jsonArray) {
		for (int i = 0; i < jsonArray.size(); ++i) {
			JSONObject jo = jsonArray.get(i).isObject();
			EmployeeItemData eData = new EmployeeItemData();
			eData.setId((int) jo.get("id").isNumber().doubleValue());
			eData.setDisplayName(jo.get("displayName").isString().stringValue());
			eData.setDataReady(false);
			TreeItem child = treeItem.addItem(eData.getDisplayName());
			child.setUserObject(eData);
		}
	}
}
