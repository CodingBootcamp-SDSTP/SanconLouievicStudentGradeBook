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
		System.out.println(userlevel);
		switch(userlevel) {
			case 4: if(AddServlet.addStudent(firstname, lastname, user, password, subject, userlevel, grade, request, response)) {
						response.sendRedirect("AdminProfile");
					}break;
			case 2: if(AddServlet.addFaculty(firstname, lastname, user, password, userlevel)) {
					response.sendRedirect("pages/adminpage.html");
			}break;
			default: {
				response.sendRedirect("index.html");
			}break;
		}
	}

	public void destroy() {
		user = null;
		password = null;
		rs = null;
	}
}
