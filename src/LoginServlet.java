import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class LoginServlet extends HttpServlet
{
	String user;
	String password;
	RequestDispatcher rs;
	// HttpSession session;
	// Object userId;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		user = request.getParameter("user");
		password = request.getParameter("password");
		if(ValidateServlet.checkUserLevel(user, password) > 0) {
			int userlevel = ValidateServlet.checkUserLevel(user, password);
			switch(userlevel) {
				case 1 : response.sendRedirect("adminpage.html"); break;
				case 2 : response.sendRedirect("facultypage.html");break;
				default : response.sendRedirect("studentpage.html");break;
			}
		}
		else {
			out.write("<style> label {color:red;}</style><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><h3><center><label>Incorrect username or password</label></center></h3>");
			rs = request.getRequestDispatcher("index.html");
			rs.include(request, response);
		}
	}
}
