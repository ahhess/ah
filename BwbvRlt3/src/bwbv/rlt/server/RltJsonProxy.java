package bwbv.rlt.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RltJsonProxy {

	private final static String URI = "http://localhost/bwbvrlt/json.php?q=";
	
	public String getRlts() {
		return getFromRemote(URI + "getrlts");
	}

	public String getRlt(String id, boolean full) {
		return getFromRemote(URI + "getrlt&id=" + id);
	}

	public String getFromRemote(String uri) {
		String buffer = null;
		try {
			URL u = new URL(uri);
			HttpURLConnection uc = (HttpURLConnection) u.openConnection();
			uc.setRequestProperty("Content-Type", "text/javascript");
			uc.setRequestMethod("GET");
			uc.setDoOutput(false);

			int status = uc.getResponseCode();
			if (status != 200)
				System.err.println("Invalid HTTP response status code " + status + " from web service server.");
			else {
				InputStream in = uc.getInputStream();
				BufferedReader d = new BufferedReader(new InputStreamReader(in));
				buffer = d.readLine();
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return buffer;
	}

	public static void main(String[] args) {
		RltJsonProxy proxy = new RltJsonProxy();
		System.out.println(proxy.getRlts());
		System.out.println(proxy.getRlt("1", true));
	}
}
