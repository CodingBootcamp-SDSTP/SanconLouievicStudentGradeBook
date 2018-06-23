import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class GuestRegistration extends HttpServlet
{
	String firstname;
	String lastname;
	String user;
	String password;
	String subject;
	int userlevel;
	int grade;
	RequestDispatcher rs;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { response.setContentType("text/html");
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		user = request.getParameter("user");
		password = request.getParameter("password");
		subject = request.getParameter("subject");
		userlevel = Integer.parseInt(request.getParameter("userlevel"));
		grade = Integer.parseInt(request.getParameter("grade"));
		if(AddServlet.addStudent(firstname, lastname, user, password, subject,userlevel, grade, request, response)) {
			response.sendRedirect("index.html");
		}
	}

	public void destroy() {
		user = null;
		password = null;
		rs = null;
	}
}
