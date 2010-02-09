package bwbv.rlt.client.service;

import bwbv.rlt.client.domain.Rlt;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;

public class RltJsonService implements RltService {

	private static final String RLTSURL = "/json";
	private JsArray<Rlt> rlts = null;

	@Override
	public Rlt[] getRlts() {
		return null; //TODO
	}
	
	private void sendGetRltsRequest( /* observer */ ) {
		// Send request to server and catch any errors.
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(RLTSURL));

		try {
			builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {
					Window.alert("Couldn't retrieve JSON:" + exception);
				}

				public void onResponseReceived(Request request, Response response) {
					if (200 == response.getStatusCode()) {
						setRlts(asJsArray(response.getText()));
					} else {
						Window.alert("Couldn't retrieve JSON (" + response.getStatusText() + ")");
					}
				}
			});
		} catch (RequestException e) {
			Window.alert("Couldn't retrieve JSON");
		}
	}

	/**
	 * Convert the string of JSON into JavaScript object.
	 */
	private final native JsArray<Rlt> asJsArray(String json) /*-{
		return eval(json);
	}-*/;

	private void setRlts(JsArray<Rlt> rlts) {
		this.rlts = rlts;
		// fire(rlts_changed); 
	}
}
