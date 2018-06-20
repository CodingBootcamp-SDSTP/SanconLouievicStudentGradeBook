import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UpdateServlet extends HttpServlet
{
	static PreparedStatement ps;
	String id;
	RequestDispatcher rs;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		id = request.getParameter("id");
		try {
			if(updateStudent(id)) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/louiedb?user=louiedb&"+"password=louiedb&serverTimezone=UTC");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE studentid="+id+";");
				while(rs.next()) {
					out.println("<form method='POST' action='updaterecord'>Student ID: "+rs.getString("studentid")+"<input type='hidden' name='id' value='"+rs.getString("studentid")+"' autocomplete='off' required><br><input type='text' name='firstname' value='"+rs.getString("firstname")+"' autocomplete='off' required><br><input type='text' name='lastname' value='"+rs.getString("lastname")+"' autocomplete='off' required><br><input type='text' name='username' value='"+rs.getString("username")+"' autocomplete='off' required><br><input type='text' name='password' value='"+rs.getString("password")+"' autocomplete='off' required><br><input type='submit' value='Update Student' /></form>");
				}
			}
			else {
				response.sendRedirect("adminpage.html");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean updateStudent(String id) {
		boolean st =false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/louiedb?user=louiedb&"+"password=louiedb&serverTimezone=UTC");
			ps =conn.prepareStatement("SELECT * FROM students WHERE studentid=?");
			ps.setString(1, id);
			ResultSet rs =ps.executeQuery();
			st = rs.next();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps != null) {
					ps.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return st;
	}

	public void destroy() {
		id = null;
		rs = null;
	}
}
