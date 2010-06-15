package bwbv.rlt.client.service;

import java.util.ArrayList;

import bwbv.rlt.client.ClientState;
import bwbv.rlt.model.domain.Detail;
import bwbv.rlt.model.domain.Rlt;
import bwbv.rlt.model.domain.RltDisziplin;
import bwbv.rlt.model.domain.RltKat;
import bwbv.rlt.model.domain.RltStatus;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

public class RltJsonService implements RltService {

	private static final String RLTSURL = "/json";

	// private JsArray<Rlt> rlts = null;
	// private ArrayList<Rlt> rlts;

	// @Override
	// public Rlt[] getRlts() {
	// return rlts.toArray(new Rlt[rlts.size()]);
	// }

	public void sendGetRltsRequest(final ClientState clientState) {
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
						parseJsonRlts(response.getText(), clientState);
					} else {
						Window.alert("Couldn't retrieve JSON (" + response.getStatusText() + ")");
					}
				}
			});
		} catch (RequestException e) {
			Window.alert("Couldn't retrieve JSON");
		}
	}

	private void parseJsonRlts(String json, ClientState clientState) {
		ArrayList<Rlt> rlts = new ArrayList<Rlt>();
		JSONValue jsonValue = JSONParser.parse(json);
		JSONArray jarr = jsonValue.isArray();
		for (int i = 0; i < jarr.size(); i++) {
			JSONObject jobj = jarr.get(i).isObject();
			Rlt rlt = new Rlt();
			rlt.setId((int) jobj.get("id").isNumber().doubleValue());
			rlt.setKurzBez(jobj.get("kurzbez").isString().stringValue());
//			rlt.setDatumtext(jobj.get("datumtext").isString().stringValue());

			rlt.setKat((RltKat) parseDetail(jobj, "kat", new RltKat()));
			rlt.setStatus((RltStatus) parseDetail(jobj, "status", new RltStatus()));

			JSONArray diszs = jobj.get("diszs").isArray();
			if (diszs != null && diszs.size() > 0) {
				RltDisziplin[] disziplins = new RltDisziplin[diszs.size()];
				for (int j = 0; j < diszs.size(); j++) {
					// String disz = diszs.get(j).isString().stringValue();
					// disziplins[j] = (RltDisziplin) parseDetail(jo2, "disz", new RltDisziplin());
					JSONObject jo2 = diszs.get(j).isObject();
					disziplins[j] = new RltDisziplin();
					disziplins[j].setId((int) jo2.get("id").isNumber().doubleValue());
					disziplins[j].setKurzBez(jo2.get("kurzbez").isString().stringValue());
				}
				rlt.setDisziplins(disziplins);
			}
			rlts.add(rlt);
		}
		clientState.setRlts(rlts);
	}

	// private RltDisziplin[] parseDisz(JSONArray jsonArray) {
	// ArrayList<RltDisziplin> diszs = new ArrayList<RltDisziplin>();
	// for (int i = 0; i < jsonArray.size(); ++i) {
	// JSONString disz = jsonArray.get(i).isString();
	// diszs.add(disz.isString().stringValue());
	// }
	// return (String[]) diszs.toArray(new String[diszs.size()]);
	// }

	private Detail parseDetail(JSONObject jsonObject, String key, Detail detail) {
		if (jsonObject != null) {
			JSONValue value = jsonObject.get(key);
			if (value != null) {
				JSONObject jo3 = value.isObject();
				if (jo3 != null) {
					detail.setId((int) jo3.get("id").isNumber().doubleValue());
					detail.setKurzBez(jo3.get("kurzbez").isString().stringValue());
					return detail;
				}
			}
		}
		return null;
	}

	public void sendGetRltRequest(final ClientState clientState, int rltId) {
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(RLTSURL));
		try {
			builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {
					Window.alert("Couldn't retrieve JSON:" + exception);
				}

				public void onResponseReceived(Request request, Response response) {
					if (200 == response.getStatusCode()) {
						parseJsonRlt(response.getText(), clientState);
					} else {
						Window.alert("Couldn't retrieve JSON (" + response.getStatusText() + ")");
					}
				}
			});
		} catch (RequestException e) {
			Window.alert("Couldn't retrieve JSON");
		}
	}

	private void parseJsonRlt(String json, ClientState clientState) {
		JSONValue jsonValue = JSONParser.parse(json);
		JSONObject jo = jsonValue.isObject();
	}

}
