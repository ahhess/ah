package bwbv.rlt.client.service;

import java.util.ArrayList;

import bwbv.rlt.client.domain.Rlt;
import bwbv.rlt.client.domain.RltKat;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

public class RltJsonService implements RltService {

	private static final String RLTSURL = "/json";
	// private JsArray<Rlt> rlts = null;
	private ArrayList<Rlt> rlts;

	@Override
	public Rlt[] getRlts() {
		return rlts.toArray(new Rlt[rlts.size()]);
	}

	public void sendGetRltsRequest( /* observer */) {
		// Send request to server and catch any errors.
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(RLTSURL));

		try {
			builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {
					Window.alert("Couldn't retrieve JSON:" + exception);
				}

				public void onResponseReceived(Request request, Response response) {
					if (200 == response.getStatusCode()) {
						// setRlts(asJsArray(response.getText()));
						parseJsonRlt(response.getText());
					} else {
						Window.alert("Couldn't retrieve JSON (" + response.getStatusText() + ")");
					}
				}
			});
		} catch (RequestException e) {
			Window.alert("Couldn't retrieve JSON");
		}
	}

	// /**
	// * Convert the string of JSON into JavaScript object.
	// */
	// private final native JsArray<Rlt> asJsArray(String json) /*-{
	// return eval(json);
	// }-*/;
	//
	// private void setRlts(JsArray<Rlt> rlts) {
	// this.rlts = rlts;
	// // fire(rlts_changed);
	// }

	private void parseJsonRlt(String json) {
		rlts = new ArrayList<Rlt>();
		JSONValue jsonValue = JSONParser.parse(json);
		JSONArray jarr = jsonValue.isArray();
		for (int i = 0; i < jarr.size(); i++) {
			JSONObject jobj = jarr.get(i).isObject();
			Rlt rlt = new Rlt();
			rlt.setId(jobj.get("id").isString().stringValue());
			rlt.setKurzbez(jobj.get("kurzbez").isString().stringValue());
			String kat = jobj.get("kat").isString().stringValue();
			for (RltKat rltKat : RltKat.values()) {
				if (rltKat.toString().equals(kat)) {
					rlt.setRltKat(rltKat);
					break;
				}
			}
			JSONArray diszs = jobj.get("diszs").isArray();
			if (diszs != null) {
				rlt.setDisz(parseDisz(jobj.get("diszs").isArray()));
			}
			rlts.add(rlt);
		}
		// notify ...
	}

	private String[] parseDisz(JSONArray jsonArray) {
		ArrayList<String> diszs = new ArrayList<String>();
		for (int i = 0; i < jsonArray.size(); ++i) {
			JSONString disz = jsonArray.get(i).isString();
			diszs.add(disz.isString().stringValue());
		}
		return (String[]) diszs.toArray(new String[diszs.size()]);
	}
}
