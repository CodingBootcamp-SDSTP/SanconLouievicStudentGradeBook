import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UpdateServlet extends HttpServlet
{
	String id;
	RequestDispatcher rs;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		id = request.getParameter("id");
		try {
			if(ValidateServlet.updateStudent(id)) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/louiedb?user=louiedb&"+"password=louiedb&serverTimezone=UTC");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE id="+id+";");
				while(rs.next()) {
					out.println("<form method='POST' action='updaterecord'><input type='hidden' name='id' value='"+rs.getString("id")+"' autocomplete='off' required><br><input type='text' name='firstname' value='"+rs.getString("firstname")+"' autocomplete='off' required><br><input type='text' name='lastname' value='"+rs.getString("lastname")+"' autocomplete='off' required><br><input type='text' name='username' value='"+rs.getString("username")+"' autocomplete='off' required><br><input type='text' name='password' value='"+rs.getString("password")+"' autocomplete='off' required><br><input type='submit' value='Update Student' /></form>");
				}
			}
			// else {
			// 	response.sendRedirect("adminpage.html");
			// }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		id = null;
		rs = null;
	}
}
