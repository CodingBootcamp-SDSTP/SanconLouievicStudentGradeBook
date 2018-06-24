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
	String subject;
	int grade;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = request.getParameter("id");
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		username = request.getParameter("username");
		password = request.getParameter("password");
		subject = request.getParameter("subject");
		grade = Integer.parseInt(request.getParameter("grade"));
		if(updateRecord(id, firstname, lastname, username, password, subject, grade)) {
			AdminProfileServlet.isUpdated();
			response.sendRedirect("AdminProfile");
		}
	}

	public boolean updateRecord(String i, String fn, String ln, String un, String pw, String subject, int grade) {
		PreparedStatement as = null;
		boolean c = true;
		try {
			ConnDB cb = ConnDB.instance();
			Connection conn = cb.getConnection();
			String query = "UPDATE students SET firstname=?, lastname=?, username=?, password=?, subject=?, grade=? WHERE studentid=?;";
			as =conn.prepareStatement(query);
			as.setString(1, fn);
			as.setString(2, ln);
			as.setString(3, un);
			as.setString(4, pw);
			as.setString(5, subject);
			as.setInt(6, grade);
			as.setString(7, i);
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
