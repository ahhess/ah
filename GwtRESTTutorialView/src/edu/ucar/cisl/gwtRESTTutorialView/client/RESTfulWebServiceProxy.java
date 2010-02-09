package edu.ucar.cisl.gwtRESTTutorialView.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("RESTfulWebServiceProxy")
public interface RESTfulWebServiceProxy extends RemoteService {
	public static class Util {

		public static RESTfulWebServiceProxyAsync getInstance() {
			RESTfulWebServiceProxyAsync rs=(RESTfulWebServiceProxyAsync)GWT.create(RESTfulWebServiceProxy.class);
			return rs;
		}
	}
	
	public String invokeGetRESTfulWebService(String uri, String contentType) throws RESTfulWebServiceException;
}

