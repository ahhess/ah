package bwbv.rlt.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RltJsonServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);

		StringBuffer b = new StringBuffer();
		b.append("[ ");
		b.append("{ \"id\": \"1\""); 
		b.append(", \"rltkat\": \"Senioren\"");
		b.append(", \"kurzbez\": \"1. BezRlt NW\"");
//		b.append(", \"disz\": [ \"HE\", \"DE\", \"MX\" ]");
		b.append("}, ");

		b.append("{ \"id\": \"2\", "); 
		b.append("\"rltkat\": \"Senioren\", ");
		b.append("\"kurzbez\": \"2. BezRlt NW\" ");
//		b.append("\"disz\": { \"HD\", \"DD\", \"MX\" } ");
		b.append("}, ");
		
		b.append("{ \"id\": \"3\", "); 
		b.append("\"rltkat\": \"Senioren\", ");
		b.append("\"kurzbez\": \"3. BezRlt NW\" ");
//		b.append("\"disz\": { \"HE\", \"DE\", \"HD\", \"DD\" } ");
		b.append("}, ");
		
		b.append("{ \"id\": \"4\", "); 
		b.append("\"rltkat\": \"Jugend\", ");
		b.append("\"kurzbez\": \"1. JBezRlt NW\" ");
//		b.append("\"disz\": { \"U13JE\", \"U13ME\" } ");
		b.append("} ]");
		
		System.out.println("RltJsonServlet: " + b.toString());
		
		PrintWriter out = resp.getWriter();
		out.print(b.toString());
		out.flush();
	}
}
