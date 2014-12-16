package ah;


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
