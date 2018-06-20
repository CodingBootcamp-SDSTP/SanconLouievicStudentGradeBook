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
	int userlevel;
	RequestDispatcher rs;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { response.setContentType("text/html");
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		user = request.getParameter("user");
		password = request.getParameter("password");
		userlevel = Integer.parseInt(request.getParameter("userlevel"));
		switch(userlevel) {

			case 4: if(AddServlet.addStudent(firstname, lastname, user, password, userlevel)) {
						response.sendRedirect("adminpage.html");
					}break;

			case 2: if(AddServlet.addFaculty(firstname, lastname, user, password, userlevel)) {
						response.sendRedirect("adminpage.html");
					}break;
		}
	}

	public void destroy() {
		user = null;
		password = null;
		rs = null;
	}
}
