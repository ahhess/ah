package bwbv.rlt.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RltJsonServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String b = buildResponseString();
		PrintWriter out = resp.getWriter();
		out.print(b);
		out.flush();
	}


	private String buildResponseString() {

		StringBuffer b = new StringBuffer();
		b.append("[ ");
		b.append("{ \"id\": 1"); 
		b.append(", \"kat\": {\"id\": 1, \"kurzbez\": \"Senioren\"}");
		b.append(", \"kurzbez\": \"1. BezRlt NW\"");
		b.append(", \"status\": {\"id\": 3, \"kurzbez\": \"Meldeschluss\"}");
		b.append(", \"diszs\": ");
//		b.append("[ \"HE\", \"DE\", \"MX\"");
		b.append("[ {\"id\": 1, \"kurzbez\": \"HE\"}");
		b.append(", {\"id\": 2, \"kurzbez\": \"DE\"}");
		b.append(", {\"id\": 5, \"kurzbez\": \"MX\"}");
//		b.append("[ \"disz\": {\"id\": 1, \"kurzbez\": \"HE\"}");
//		b.append(", \"disz\": {\"id\": 2, \"kurzbez\": \"DE\"}");
//		b.append(", \"disz\": {\"id\": 5, \"kurzbez\": \"MX\"}");
		b.append("]}, ");

		b.append("{ \"id\": 2"); 
		b.append(", \"kurzbez\": \"2. BezRlt NW\"");
		b.append(", \"kat\": {\"id\": 1, \"kurzbez\": \"Senioren\"}");
		b.append(", \"status\": {\"id\": 2, \"kurzbez\": \"meldeoffen\"}");
		b.append(", \"diszs\": ");
//		b.append("[ \"HD\", \"DD\", \"MX\"");
		b.append("[ {\"id\": 3, \"kurzbez\": \"HD\"}");
		b.append(", {\"id\": 4, \"kurzbez\": \"DD\"}");
		b.append(", {\"id\": 5, \"kurzbez\": \"MX\"}");
//		b.append("[ \"disz\": {\"id\": 3, \"kurzbez\": \"HD\"}");
//		b.append(", \"disz\": {\"id\": 4, \"kurzbez\": \"DD\"}");
//		b.append(", \"disz\": {\"id\": 5, \"kurzbez\": \"MX\"}");
		b.append("]}, ");
		
		b.append("{ \"id\": 3"); 
		b.append(", \"kurzbez\": \"3. BezRlt NW\"");
		b.append(", \"kat\": {\"id\": 1, \"kurzbez\": \"Senioren\"}");
		b.append(", \"status\": {\"id\": 1, \"kurzbez\": \"geplant\"}");
		b.append(", \"diszs\": ");
//		b.append("[ \"HE\", \"DE\", \"HD\", \"MX\"");
		b.append("[ {\"id\": 1, \"kurzbez\": \"HE\"}");
		b.append(", {\"id\": 2, \"kurzbez\": \"DE\"}");
		b.append(", {\"id\": 3, \"kurzbez\": \"HD\"}");
		b.append(", {\"id\": 4, \"kurzbez\": \"DD\"}");
//		b.append("[ \"disz\": {\"id\": 1, \"kurzbez\": \"HE\"}");
//		b.append(", \"disz\": {\"id\": 2, \"kurzbez\": \"DE\"}");
//		b.append(", \"disz\": {\"id\": 3, \"kurzbez\": \"HD\"}");
//		b.append(", \"disz\": {\"id\": 4, \"kurzbez\": \"DD\"}");
		b.append("]}, ");
		
		b.append("{ \"id\": 4"); 
		b.append(", \"kurzbez\": \"1. JBezRlt NW\"");
		b.append(", \"kat\": {\"id\": 2, \"kurzbez\": \"Jugend\"}");
		b.append(", \"status\": {\"id\": 4, \"kurzbez\": \"beendet\"}");
		b.append(", \"diszs\": ");
//		b.append("[ \"U13JE\", \"U13ME\"");
		b.append("[ {\"id\": 6, \"kurzbez\": \"U13JE\"}");
		b.append(", {\"id\": 7, \"kurzbez\": \"U13ME\"}");
//		b.append("[ \"disz\": {\"id\": 6, \"kurzbez\": \"U13JE\"}");
//		b.append(", \"disz\": {\"id\": 7, \"kurzbez\": \"U13ME\"}");
		b.append("]} ]");

		System.out.println("RltJsonServlet: " + b);
		return b.toString();
	}

	
	public static void main(String[] args) {
		new RltJsonServlet().buildResponseString();
	}
}

