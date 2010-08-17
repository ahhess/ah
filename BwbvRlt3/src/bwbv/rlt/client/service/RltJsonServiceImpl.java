package bwbv.rlt.client.service;

import java.util.ArrayList;

import bwbv.rlt.client.ClientState;
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

public class RltJsonServiceImpl implements RltService {

	private static final String RLTSURL = "/json?q=";

	private abstract class RltRequestCallback implements RequestCallback {

		@Override
		public void onError(Request request, Throwable exception) {
			throw new RuntimeException(exception);
		}

		@Override
		public void onResponseReceived(Request request, Response response) {
			if (200 == response.getStatusCode()) {
				GWT.log("RltRequestCallback.onResponseReceived:" + response.getText(), null);
				processResponseText(response);
			} else {
				throw new RuntimeException(response.getStatusText());
			}
		}
		
		public abstract void processResponseText(Response response);
	}

	@Override
	public void sendGetRltsRequest(final ClientState clientState) {
		final String uri = URL.encode(RLTSURL + "getrlts");
		GWT.log(uri, null);
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, uri);
		try {
			builder.sendRequest(null, new RltRequestCallback() {
				@Override
				public void processResponseText(Response response) {
					parseJsonRlts(response.getText(), clientState);
				}
			});
		} catch (RequestException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void sendGetRltRequest(final ClientState clientState, int rltId) {
		final String uri = URL.encode(RLTSURL + "getrlt&id=" + rltId);
		GWT.log(uri, null);
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, uri);
		try {
			builder.sendRequest(null, new RltRequestCallback() {
				@Override
				public void processResponseText(Response response) {
					parseJsonRlt(response.getText(), clientState);
				}
			});
		} catch (RequestException e) {
			throw new RuntimeException(e);
		}
	}

//	@Override
//	public void isLoggedIn(final ClientState clientState) {
//		final String uri = URL.encode(RLTSURL + "isloggedin");
//		GWT.log(uri, null);
//		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, uri);
//		try {
//			builder.sendRequest(null, new RltRequestCallback() {
//				@Override
//				public void processResponseText(Response response) {
//					if ("true".equals(response.getText())) {
//						// do nothing
//					} else {
//						clientState.setUserName(null);
//					}
//				}
//			});
//		} catch (RequestException e) {
//			throw new RuntimeException(e);
//		}
//	}
	
	@Override
	public void login(final ClientState clientState, final String userName, String pwd) {
		final String uri = URL.encode(RLTSURL + "login&u=" + userName + "&p=" + pwd);
		GWT.log(uri, null);
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, uri);
		try {
			builder.sendRequest(null, new RltRequestCallback() {
				@Override
				public void processResponseText(Response response) {
					if (!"-1".equals(response.getText())){
						clientState.setUserName(userName);
					}
				}
			});
		} catch (RequestException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void logout(final ClientState clientState) {
		final String uri = URL.encode(RLTSURL + "logout");
		GWT.log(uri, null);
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, uri);
		try {
			builder.sendRequest(null, new RltRequestCallback() {
				@Override
				public void processResponseText(Response response) {
					clientState.setUserName(null);
				}
			});
		} catch (RequestException e) {
			throw new RuntimeException(e);
		}
	}

	private void parseJsonRlts(String json, ClientState clientState) {
		ArrayList<Rlt> rlts = new ArrayList<Rlt>();
		JSONValue jsonValue = JSONParser.parse(json);
		JSONArray jarr = jsonValue.isArray();
		for (int i = 0; i < jarr.size(); i++) {
			JSONObject jobj = jarr.get(i).isObject();
			rlts.add(parseRlt(jobj));
		}
		clientState.setRlts(rlts);
	}

	private void parseJsonRlt(String json, ClientState clientState) {
		JSONValue jsonValue = JSONParser.parse(json);
		JSONObject jobj = jsonValue.isObject();
		clientState.setCurrentRlt(parseRlt(jobj));
	}

	private Rlt parseRlt(JSONObject jobj) {
		Rlt rlt = parseRltData(jobj);
		rlt.setKat(parseRltKatData(jobj));			
		rlt.setStatus(parseRltStatusData(jobj));
		return rlt;
	}

	private Rlt parseRltData(JSONObject jobj) {
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

	private RltStatus parseRltStatusData(JSONObject jobj) {
		RltStatus status = new RltStatus();
		// rltstatus_id, rltstatus.status, rltstatus.statusbez 
		status.setId((int) jobj.get("rltstatus_id").isNumber().doubleValue());
		status.setKurzBez(jobj.get("status").isString().stringValue());
		status.setLangBez(jobj.get("statusbez").isString().stringValue());
		return status;
	}

	private RltKat parseRltKatData(JSONObject jobj) {
		RltKat kat = new RltKat();
		// rltkat_id, rltkat.kat, rltkat.katbez,  
		kat.setId((int) jobj.get("rltkat_id").isNumber().doubleValue());
		kat.setKurzBez(jobj.get("kat").isString().stringValue());
		kat.setLangBez(jobj.get("katbez").isString().stringValue());
		return kat;
	}

}
