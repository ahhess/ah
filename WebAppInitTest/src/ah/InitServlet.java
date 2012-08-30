package ah;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet(loadOnStartup = 1, urlPatterns = "/init")
public class InitServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		
		AppConfig appConfig = AppConfig.getInstance();

		ServletContext context = config.getServletContext();
		String contextPath = context.getContextPath();
		System.out.println("InitServlet contextPath=" + contextPath);

		appConfig.put("contextPath", contextPath);
	}

}
