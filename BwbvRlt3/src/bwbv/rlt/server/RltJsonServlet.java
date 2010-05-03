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

		String b = req.getParameter("rlt");
		if (b != null)
			b = getRlt(b, true);
		else
			b = getRlts();
		PrintWriter out = resp.getWriter();
		out.print(b);
		out.flush();
	}

	private String getRlts() {

		StringBuffer b = new StringBuffer();
		b.append("[ ");
		/*
		b.append("{ \"id\": 1");
		b.append(", \"kat\": {\"id\": 1, \"kurzbez\": \"Senioren\"}");
		b.append(", \"kurzbez\": \"1. BezRlt NW\"");
		b.append(", \"status\": {\"id\": 3, \"kurzbez\": \"S\"}");
		b.append(", \"diszs\": ");
		// b.append("[ \"HE\", \"DE\", \"MX\"");
		b.append("[ {\"id\": 1, \"kurzbez\": \"HE\"}");
		b.append(", {\"id\": 2, \"kurzbez\": \"DE\"}");
		b.append(", {\"id\": 5, \"kurzbez\": \"MX\"}");
		// b.append("[ \"disz\": {\"id\": 1, \"kurzbez\": \"HE\"}");
		// b.append(", \"disz\": {\"id\": 2, \"kurzbez\": \"DE\"}");
		// b.append(", \"disz\": {\"id\": 5, \"kurzbez\": \"MX\"}");
		b.append("]}, ");
		*/
		b.append(getRlt("1", false));
		b.append(", ");
		
		b.append("{ \"id\": 2");
		b.append(", \"kurzbez\": \"2. BezRlt NW\"");
		b.append(", \"kat\": {\"id\": 1, \"kurzbez\": \"Senioren\"}");
		b.append(", \"status\": {\"id\": 2, \"kurzbez\": \"M\"}");
		b.append(", \"diszs\": ");
		// b.append("[ \"HD\", \"DD\", \"MX\"");
		b.append("[ {\"id\": 3, \"kurzbez\": \"HD\"}");
		b.append(", {\"id\": 4, \"kurzbez\": \"DD\"}");
		b.append(", {\"id\": 5, \"kurzbez\": \"MX\"}");
		// b.append("[ \"disz\": {\"id\": 3, \"kurzbez\": \"HD\"}");
		// b.append(", \"disz\": {\"id\": 4, \"kurzbez\": \"DD\"}");
		// b.append(", \"disz\": {\"id\": 5, \"kurzbez\": \"MX\"}");
		b.append("]}, ");

		b.append("{ \"id\": 3");
		b.append(", \"kurzbez\": \"3. BezRlt NW\"");
		b.append(", \"kat\": {\"id\": 1, \"kurzbez\": \"Senioren\"}");
		b.append(", \"status\": {\"id\": 1, \"kurzbez\": \"P\"}");
		b.append(", \"diszs\": ");
		// b.append("[ \"HE\", \"DE\", \"HD\", \"MX\"");
		b.append("[ {\"id\": 1, \"kurzbez\": \"HE\"}");
		b.append(", {\"id\": 2, \"kurzbez\": \"DE\"}");
		b.append(", {\"id\": 3, \"kurzbez\": \"HD\"}");
		b.append(", {\"id\": 4, \"kurzbez\": \"DD\"}");
		// b.append("[ \"disz\": {\"id\": 1, \"kurzbez\": \"HE\"}");
		// b.append(", \"disz\": {\"id\": 2, \"kurzbez\": \"DE\"}");
		// b.append(", \"disz\": {\"id\": 3, \"kurzbez\": \"HD\"}");
		// b.append(", \"disz\": {\"id\": 4, \"kurzbez\": \"DD\"}");
		b.append("]}, ");

		b.append("{ \"id\": 4");
		b.append(", \"kurzbez\": \"1. JBezRlt NW\"");
		b.append(", \"kat\": {\"id\": 2, \"kurzbez\": \"Jugend\"}");
		b.append(", \"status\": {\"id\": 4, \"kurzbez\": \"E\"}");
		b.append(", \"diszs\": ");
		// b.append("[ \"U13JE\", \"U13ME\"");
		b.append("[ {\"id\": 6, \"kurzbez\": \"U13JE\"}");
		b.append(", {\"id\": 7, \"kurzbez\": \"U13ME\"}");
		// b.append("[ \"disz\": {\"id\": 6, \"kurzbez\": \"U13JE\"}");
		// b.append(", \"disz\": {\"id\": 7, \"kurzbez\": \"U13ME\"}");
		b.append("]} ]");

		System.out.println("RltJsonServlet: " + b);
		return b.toString();
	}

	private String getRlt(String id, boolean full) {

		StringBuffer b = new StringBuffer();
		if ("1".equals(id)) {
			if (full) 
				b.append("{ \"rlt\": ");
			b.append("{ \"id\": 1");
			b.append(", \"kat\": {\"id\": 1, \"kurzbez\": \"Senioren\"}");
			b.append(", \"kurzbez\": \"1. BezRlt NW\"");
			b.append(", \"status\": {\"id\": 3, \"kurzbez\": \"S\"");
			if (full)
				b.append(", \"langbez\": \"Meldeschluss\"");
			b.append("}");
			b.append(", \"diszs\": ");
			b.append("[ {\"id\": 1, \"kurzbez\": \"HE\"");
			if (full)
				b.append(", \"langbez\": \"Herreneinzel\"");
			b.append("}");
			b.append(", {\"id\": 2, \"kurzbez\": \"DE\"");
			if (full)
				b.append(", \"langbez\": \"Dameneinzel\"");
			b.append("}");
			b.append(", {\"id\": 5, \"kurzbez\": \"MX\"");
			if (full)
				b.append(", \"langbez\": \"Mixed\"");
			b.append("}]");
			if (full) {
				b.append(", \"langbez\": \"1. BWBV Bezirksranglistenturnier NW\"");
				b.append(", \"ort\": \"Fellbach\"");
				b.append(", \"halle\": \"Gäuäckersporthalle 2\"");
				b.append(", \"adresse\": \"Bühlstr. 153, 70736 Fellbach\"");
				b.append(", \"datumtext\": \"17./18.04.2010\"");
				b.append(", \"datum\": \"2010-04-17\"");
				b.append(", \"meldeschluss\": \"2010-04-07\"");
				b.append("}");
			}
			b.append("}");
		/***
		} else if ("2".equals(id)) {
			b.append("{ \"id\": 2");
			b.append(", \"kurzbez\": \"2. BezRlt NW\"");
			b.append(", \"kat\": {\"id\": 1, \"kurzbez\": \"Senioren\"}");
			b.append(", \"status\": {\"id\": 2, \"kurzbez\": \"M\", \"langbez\": \"meldeoffen\"}");
			b.append(", \"diszs\": ");
			// b.append("[ \"HD\", \"DD\", \"MX\"");
			b.append("[ {\"id\": 3, \"kurzbez\": \"HD\"}");
			b.append(", {\"id\": 4, \"kurzbez\": \"DD\"}");
			b.append(", {\"id\": 5, \"kurzbez\": \"MX\"}");
			// b.append("[ \"disz\": {\"id\": 3, \"kurzbez\": \"HD\"}");
			// b.append(", \"disz\": {\"id\": 4, \"kurzbez\": \"DD\"}");
			// b.append(", \"disz\": {\"id\": 5, \"kurzbez\": \"MX\"}");
			b.append("]}, ");
		} else if ("3".equals(id)) {
			b.append("{ \"id\": 3");
			b.append(", \"kurzbez\": \"3. BezRlt NW\"");
			b.append(", \"kat\": {\"id\": 1, \"kurzbez\": \"Senioren\"}");
			b.append(", \"status\": {\"id\": 1, \"kurzbez\": \"P\", \"langbez\": \"geplant\"}");
			b.append(", \"diszs\": ");
			// b.append("[ \"HE\", \"DE\", \"HD\", \"MX\"");
			b.append("[ {\"id\": 1, \"kurzbez\": \"HE\"}");
			b.append(", {\"id\": 2, \"kurzbez\": \"DE\"}");
			b.append(", {\"id\": 3, \"kurzbez\": \"HD\"}");
			b.append(", {\"id\": 4, \"kurzbez\": \"DD\"}");
			// b.append("[ \"disz\": {\"id\": 1, \"kurzbez\": \"HE\"}");
			// b.append(", \"disz\": {\"id\": 2, \"kurzbez\": \"DE\"}");
			// b.append(", \"disz\": {\"id\": 3, \"kurzbez\": \"HD\"}");
			// b.append(", \"disz\": {\"id\": 4, \"kurzbez\": \"DD\"}");
			b.append("]}, ");
		} else if ("4".equals(id)) {
			b.append("{ \"id\": 4");
			b.append(", \"kurzbez\": \"1. JBezRlt NW\"");
			b.append(", \"kat\": {\"id\": 2, \"kurzbez\": \"Jugend\"}");
			b.append(", \"status\": {\"id\": 4, \"kurzbez\": \"E\", \"langbez\": \"beendet\"}");
			b.append(", \"diszs\": ");
			// b.append("[ \"U13JE\", \"U13ME\"");
			b.append("[ {\"id\": 6, \"kurzbez\": \"U13JE\"}");
			b.append(", {\"id\": 7, \"kurzbez\": \"U13ME\"}");
			// b.append("[ \"disz\": {\"id\": 6, \"kurzbez\": \"U13JE\"}");
			// b.append(", \"disz\": {\"id\": 7, \"kurzbez\": \"U13ME\"}");
			b.append("]} ]");
		***/
		}
		System.out.println("RltJsonServlet: " + b);
		return b.toString();
	}

	public static void main(String[] args) {
		RltJsonServlet rltJsonServlet = new RltJsonServlet();
		rltJsonServlet.getRlts();
		rltJsonServlet.getRlt("1", true);
	}
}
