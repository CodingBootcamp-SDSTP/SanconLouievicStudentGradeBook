import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RegisterServlet extends HttpServlet
{
	String firstname;
	String lastname;
	String user;
	String password;
	RequestDispatcher rs;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { response.setContentType("text/html");
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		user = request.getParameter("user");
		password = request.getParameter("password");
		if(ValidateServlet.addStudent(firstname, lastname, user, password, 4)) {
			response.sendRedirect("adminpage.html");
		}
	}

	public void destroy() {
		user = null;
		password = null;
		rs = null;
	}
}
