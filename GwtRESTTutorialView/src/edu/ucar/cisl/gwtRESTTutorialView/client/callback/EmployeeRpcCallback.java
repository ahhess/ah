package edu.ucar.cisl.gwtRESTTutorialView.client.callback;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

import edu.ucar.cisl.gwtRESTTutorialView.client.EmployeePopup;
import edu.ucar.cisl.gwtRESTTutorialView.client.bean.EmployeeItemData;
import edu.ucar.cisl.gwtRESTTutorialView.client.bean.ItemData;

public class EmployeeRpcCallback extends RestServiceRpcCallback {

	protected void processResponse(String response) {
		JSONValue jsonValue = JSONParser.parse(response);
		ItemData iData = (ItemData) treeItem.getUserObject();
		JSONObject jobj = jsonValue.isObject();
		EmployeeItemData eItemData = (EmployeeItemData) iData;
		eItemData.setId((int) jobj.get("id").isNumber().doubleValue());
		eItemData.setFirstName(jobj.get("firstName").isString().stringValue());
		eItemData.setNickName(jobj.get("nickName").isString().stringValue());
		eItemData.setLastName(jobj.get("lastName").isString().stringValue());
		eItemData.setPhone(jobj.get("phone").isString().stringValue());
		eItemData.setEmail(jobj.get("email").isString().stringValue());
		eItemData.setTitle(jobj.get("title").isString().stringValue());
		iData.setDataReady(true);
		int left = treeItem.getAbsoluteLeft() + 50;
		int top = treeItem.getAbsoluteTop() + 30;
		EmployeePopup.show(left, top, (EmployeeItemData) eItemData);
	}
}
