import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class LoginServlet extends HttpServlet
{
	String username;
	String password;
	RequestDispatcher rs;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		username = request.getParameter("user");
		password = request.getParameter("password");
		if(ValidateServlet.checkUserLevel(username, password) > 0) {
			int userlevel = ValidateServlet.checkUserLevel(username, password);
			switch(userlevel) {
				case 1 : response.sendRedirect("pages/adminpage.html"); break;
				case 2 : response.sendRedirect("pages/facultypage.html");break;
				default : response.sendRedirect("pages/studentpage.html");break;
			}
		}
		else {
			out.write("<script>function myFunction() {alert('Unrecognized username or password');}</script><h3><center><label id='inc'></label></center></h3>");
			out.write("<script>myFunction()</script>");
			rs = request.getRequestDispatcher("index.html");
			rs.include(request, response);
		}
	}
}
