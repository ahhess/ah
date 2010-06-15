package bwbv.rlt.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RltJsonServlet extends HttpServlet {

	private RltJsonData data = new RltJsonData();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String b = req.getParameter("rlt");
		if (b != null)
			b = data.getRlt(b, true);
		else
			b = data.getRlts();
		PrintWriter out = resp.getWriter();
		out.print(b);
		out.flush();
	}
}
