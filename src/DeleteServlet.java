import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DeleteServlet extends HttpServlet
{
	String id;
	String firstname;
	RequestDispatcher rs;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		id = request.getParameter("id");
		firstname = request.getParameter("firstname");
		if(ValidateServlet.deleteStudent(id, firstname)) {
			out.println("Sucessfully Deleted");
			response.sendRedirect("adminpage.html");
			rs.forward(request, response);
		}
		else {
			response.sendRedirect("adminpage.html");
		}
	}

	public void destroy() {
		id = null;
		firstname = null;
		rs = null;
	}
}
