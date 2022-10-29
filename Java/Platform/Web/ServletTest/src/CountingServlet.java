package basic.web.app;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/count")
public class CountingServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String person = request.getParameter("person");
		String period = request.getParameter("period");
		if(person.length() == 0){
			response.sendRedirect("welcome");
			return;
		}
		var session = request.getSession(true);
		Integer count = (Integer)session.getAttribute(person);
		if(count == null)
			count = 1;
		response.setContentType("text/html");
		var out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>BasicWebApp</title></head>");
		out.println("<body>");
		out.printf("<h1>Good %s %s</h1>%n", period, person);
		out.printf("<b>Number of Greetings = </b>%d%n", count);
		out.println("</body>");
		out.println("</html>");
		out.close();
		session.setAttribute(person, count + 1);
		if(count == 5)
			session.invalidate();
	}
}

