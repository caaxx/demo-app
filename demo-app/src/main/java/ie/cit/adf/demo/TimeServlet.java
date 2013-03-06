package ie.cit.adf.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
public class TimeServlet extends HttpServlet {

	private TimeService timeSvc;

	@Override
	public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.
				getWebApplicationContext(servletContext);
		timeSvc = (TimeService) ctx.getBean(TimeService.class);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		java.util.Date currentDate = timeSvc.getCurrentDate();
		writer.println("<HTML>");
		writer.println("<body>");
		writer.println("<H1>Time Servlet by Cathal Cleary</H1>");
		writer.println("Current Date is: " + currentDate.toString());
		writer.println("</body>");
		writer.println("</HTML>");
		writer.close();

		}
}
