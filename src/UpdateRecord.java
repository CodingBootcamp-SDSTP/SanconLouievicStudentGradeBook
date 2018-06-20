import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UpdateRecord extends HttpServlet
{
	String id;
	String firstname;
	String lastname;
	String username;
	String password;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = request.getParameter("id");
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		username = request.getParameter("username");
		password = request.getParameter("password");
		System.out.println(id+" "+firstname+" "+lastname+" "+" "+username+" "+password);
		if(updateRecord(id, firstname, lastname, username, password)) {
			response.sendRedirect("adminpage.html");
		}
	}

	public boolean updateRecord(String i, String fn, String ln, String un, String pw) {
		PreparedStatement as = null;
		boolean c = true;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/louiedb?user=louiedb&"+"password=louiedb&serverTimezone=UTC");
			String query = "UPDATE students SET firstname=?, lastname=?, username=?, password=? WHERE studentid=?;";
			as =conn.prepareStatement(query);
			as.setString(1, fn);
			as.setString(2, ln);
			as.setString(3, un);
			as.setString(4, pw);
			as.setString(5, i);
			as.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(as != null) {
					as.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return(c);
	}
}
