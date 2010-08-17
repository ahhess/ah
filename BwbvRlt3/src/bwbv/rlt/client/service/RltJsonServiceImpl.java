package bwbv.rlt.client.service;

import java.util.ArrayList;

import bwbv.rlt.client.ClientState;
import bwbv.rlt.client.domain.AuthenticationException;
import bwbv.rlt.model.domain.Rlt;
import bwbv.rlt.model.domain.RltKat;
import bwbv.rlt.model.domain.RltStatus;

import com.google.gwt.core.client.GWT;
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

public class RltJsonServiceImpl implements RltService {

	private static final String RLTSURL = "/json?q=";

	public void sendGetRltsRequest(final ClientState clientState) {
		// Send request to server and catch any errors.
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(RLTSURL + "getrlts"));

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
			Rlt rlt = parseRlt(jobj);
			rlt.setKat(parseRltKat(jobj));			
			rlt.setStatus(parseRltStatus(jobj));
			rlts.add(rlt);
		}
		clientState.setRlts(rlts);
	}

	private Rlt parseRlt(JSONObject jobj) {
		Rlt rlt = new Rlt();
		// rlt.id, rlt.kurzbez, rlt.turnierbez, rlt.datumtext,
		// rlt.ort, rlt.halle, rlt.adresse, rlt.meldeschluss,
		rlt.setId((int) jobj.get("id").isNumber().doubleValue());
		rlt.setKurzBez(getString(jobj,"kurzbez"));
		rlt.setLangBez(getString(jobj,"turnierbez"));
		rlt.setDatumtext(getString(jobj,"datumtext"));
		rlt.setOrt(getString(jobj,"ort"));
		rlt.setHalle(getString(jobj, "halle"));
		rlt.setAdresse(getString(jobj, "adresse"));
//		rlt.setMeldeschluss(jobj.get("meldeschluss").is...);
		return rlt;
	}

	private String getString(JSONObject jobj, String key) {
		JSONValue value = jobj.get(key);
		if (value != null && value.isString() != null)
			return value.isString().stringValue();
		return null;
	}

	private RltStatus parseRltStatus(JSONObject jobj) {
		RltStatus status = new RltStatus();
		// rltstatus_id, rltstatus.status, rltstatus.statusbez 
		status.setId((int) jobj.get("rltstatus_id").isNumber().doubleValue());
		status.setKurzBez(jobj.get("status").isString().stringValue());
		status.setLangBez(jobj.get("statusbez").isString().stringValue());
		return status;
	}

	private RltKat parseRltKat(JSONObject jobj) {
		RltKat kat = new RltKat();
		// rltkat_id, rltkat.kat, rltkat.katbez,  
		kat.setId((int) jobj.get("rltkat_id").isNumber().doubleValue());
		kat.setKurzBez(jobj.get("kat").isString().stringValue());
		kat.setLangBez(jobj.get("katbez").isString().stringValue());
		return kat;
	}

	// private RltDisziplin[] parseDisz(JSONArray jsonArray) {
	// ArrayList<RltDisziplin> diszs = new ArrayList<RltDisziplin>();
	// for (int i = 0; i < jsonArray.size(); ++i) {
	// JSONString disz = jsonArray.get(i).isString();
	// diszs.add(disz.isString().stringValue());
	// }
	// return (String[]) diszs.toArray(new String[diszs.size()]);
	// }

//	private Detail parseDetail(JSONObject jsonObject, String key, Detail detail) {
//		if (jsonObject != null) {
//			JSONValue value = jsonObject.get(key);
//			if (value != null) {
//				JSONObject jo3 = value.isObject();
//				if (jo3 != null) {
//					detail.setId((int) jo3.get("id").isNumber().doubleValue());
//					detail.setKurzBez(jo3.get("kurzbez").isString().stringValue());
//					JSONValue langbez = jo3.get("langbez");
//					if (langbez != null)
//						detail.setLangBez(langbez.isString().stringValue());
//					return detail;
//				}
//			}
//		}
//		return null;
//	}

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
		JSONObject jobj = jsonValue.isObject();
	}

	@Override
	public Boolean isLoggedIn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void login(final ClientState clientState, final String userName, String pwd) throws AuthenticationException {
		try {
			GWT.log("login: req="+RLTSURL + "login&u=" + userName + "&p=" + pwd, null);
			RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(RLTSURL + "login&u=" + userName + "&p=" + pwd));
			builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {
					Window.alert("Couldn't retrieve JSON:" + exception);
				}

				public void onResponseReceived(Request request, Response response) {
					if (200 == response.getStatusCode()) {
						GWT.log("login: response="+response.getText(), null);
						if (!"-1".equals(response.getText())){
							clientState.setUserName(userName);
						}
					} else {
						Window.alert("Couldn't retrieve JSON (" + response.getStatusText() + ")");
					}
				}
			});
		} catch (RequestException e) {
			GWT.log("login: exc:", e);
		}
	}
	
	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

}
