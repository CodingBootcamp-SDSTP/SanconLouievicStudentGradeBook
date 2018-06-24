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
	static PrintWriter out;
	RequestDispatcher rs;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		out=response.getWriter();
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		user = request.getParameter("user");
		password = request.getParameter("password");
		subject = request.getParameter("subject");
		userlevel = Integer.parseInt(request.getParameter("userlevel"));
		grade = Integer.parseInt(request.getParameter("grade"));
		if(AddServlet.addStudent(firstname, lastname, user, password, subject,userlevel, grade) > 0) {
			System.out.println("Already exist");
			response.sendRedirect("/login");
		}
		else {
			System.out.println("Successfully Added");
			response.sendRedirect("/login");
		}
	}

	public void destroy() {
		user = null;
		password = null;
		rs = null;
	}
}
