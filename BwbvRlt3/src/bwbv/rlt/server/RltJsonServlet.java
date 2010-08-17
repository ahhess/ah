package bwbv.rlt.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RltJsonServlet extends HttpServlet {

	private RltJsonProxy data = new RltJsonProxy();
//	private RltJsonData data = new RltJsonData();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String b = req.getParameter("q");
		System.out.println("RltJsonServlet: "+b);
		if ("getrlts".equals(b))
			b = data.getRlts();
		else if ("login".equals(b))
			b = data.login(req.getParameter("u"), req.getParameter("p"));
		
		PrintWriter out = resp.getWriter();
		out.print(b);
		out.flush();
	}
}
