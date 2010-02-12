package edu.ucar.cisl.gwtRESTTutorialView.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RESTfulWebServiceProxyAsync {
	public void invokeGetRESTfulWebService(String uri, String contentType, AsyncCallback<String> callback);
	
}
