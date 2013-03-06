package ie.cit.adf.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("serial")
public class TimeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("classpath:context-config.xml");
		TimeService timeSvc = (TimeService) ctx.getBean("TimeService");
		java.util.Date currentDate = timeSvc.getCurrentDate();
		writer.println("<HTML>");
		writer.println("<body>");
		writer.println("<H1>Time Servlet by Cathal Cleary</H1>");
		writer.println("Current Date is: " + currentDate.toString());
		writer.println("</body>");
		writer.println("</HTML>");
		writer.close();
		ctx.close();
		}
}
