package bwbv.rlt.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RltJsonProxy extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuffer uri = new StringBuffer("http://localhost/bwbvrlt/json.php");
		String sep = "?";
		Enumeration<String> enumeration = req.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String parameter = enumeration.nextElement();
			uri.append(sep).append(parameter).append("=").append(req.getParameter(parameter));
			sep = "&";
		}
		
		PrintWriter out = resp.getWriter();
		out.print(getFromRemote(uri.toString()));
		out.flush();
	}
	
	public String getFromRemote(String uri) {
		System.out.println("getFromRemote: "+uri);
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
		System.out.println(buffer);
		return buffer;
	}

}
