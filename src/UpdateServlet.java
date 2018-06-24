import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UpdateServlet extends HttpServlet
{
	static PreparedStatement ps;
	String id;
	RequestDispatcher rs;
	ConnDB cb = ConnDB.instance();
	Connection conn = cb.getConnection();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		id = request.getParameter("id");
		try {
			if(updateStudent(id)) {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE studentid="+id+";");
				while(rs.next()) {
					out.println("<style> .field {background: white; color: purple;}</style><br><br><br><br><br><center><form method='POST' action='updaterecord'>Student ID: "+rs.getString("studentid")+"<input type='hidden' class='field' name='id' value='"+rs.getString("studentid")+"' autocomplete='off' required><br>Firstname: <input type='text' class='field' name='firstname' value='"+rs.getString("firstname")+"' autocomplete='off' required><br>Lastname<input type='text' class='field' name='lastname' value='"+rs.getString("lastname")+"' autocomplete='off' required><br>Username: <input type='text' class='field' name='username' value='"+rs.getString("username")+"' autocomplete='off' required><br>Password:<input type='text' class='field' name='password' value='"+rs.getString("password")+"' autocomplete='off' required><br>Subject:<input type='text' class='field' name='subject' value='"+rs.getString("subject")+"' autocomplete='off' required><br>Grade:<input type='text' class='field' name='grade' value='"+rs.getString("grade")+"' autocomplete='off' required><br><input type='submit' value='Update Student' /></form></center>");
				}
			}
			else {
				response.sendRedirect("pages/adminpage.html");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public boolean updateStudent(String id) {
		boolean st =false;
		try {
			ps = conn.prepareStatement("SELECT * FROM students WHERE studentid=?");
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
