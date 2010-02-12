package edu.ucar.cisl.gwtRESTTutorialView.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ucar.cisl.gwtRESTTutorialView.client.RESTfulWebServiceProxy;
import edu.ucar.cisl.gwtRESTTutorialView.client.RESTfulWebServiceException;

public class RESTfulWebServiceProxyImpl extends RemoteServiceServlet implements
		RESTfulWebServiceProxy {
	private static final long serialVersionUID = 1L;

	public RESTfulWebServiceProxyImpl() { // must have
	}

	public String invokeGetRESTfulWebService(String uri, String contentType)
			throws RESTfulWebServiceException {
		try {
			URL u = new URL(uri);
			HttpURLConnection uc = (HttpURLConnection) u.openConnection();
			uc.setRequestProperty("Content-Type", contentType);
			uc.setRequestMethod("GET");
			uc.setDoOutput(false);

			int status = uc.getResponseCode();
			if (status != 200)
				throw (new RESTfulWebServiceException(
						"Invalid HTTP response status code " + status + " from web service server."));

			InputStream in = uc.getInputStream();
			BufferedReader d = new BufferedReader(new InputStreamReader(in));
			String buffer = d.readLine();
			return buffer;
		} catch (MalformedURLException e) {
			throw new RESTfulWebServiceException(e.getMessage(), e);
		}catch (IOException e) {
			throw new RESTfulWebServiceException(e.getMessage(), e);
		}

	}

}
