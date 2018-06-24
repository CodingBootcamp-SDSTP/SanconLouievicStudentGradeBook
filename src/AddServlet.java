import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AddServlet
{
	static PreparedStatement ps;
	static ConnDB cb = ConnDB.instance();
	static Connection conn = cb.getConnection();
	static int c;

	public static int addStudent(String firstname, String lastname, String username, String password, String subject, int lv, int grade) throws IOException {
		c=0;
		try {
			String query = "SELECT username from students WHERE username=?;";
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			if(ps.executeQuery().next()) {
				c = 1;
			}
			else {
				String query1 = "INSERT INTO students(firstname, lastname, username, password, subject, userlevel, grade) VALUES (?, ?, ?, ?, ?, ?, ?);";
				ps = conn.prepareStatement(query1);
				ps.setString(1, firstname);
				ps.setString(2, lastname);
				ps.setString(3, username);
				ps.setString(4, password);
				ps.setString(5, subject);
				ps.setInt(6, lv);
				ps.setInt(7, grade);
				ps.executeUpdate();
			}
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
	return(c);
	}

	public static int addFaculty(String firstname, String lastname, String username, String password, int lv) throws IOException {
		c=0;
		try {
			String query = "SELECT username from faculty WHERE username=?;";
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			if(ps.executeQuery().next()) {
				c = 1;
			}
			else {
				String query1 = "INSERT INTO faculty(firstname, lastname, username, password, userlevel) VALUES (?, ?, ?, ?, ?);";
					ps = conn.prepareStatement(query1);
					ps.setString(1, firstname);
					ps.setString(2, lastname);
					ps.setString(3, username);
					ps.setString(4, password);
					ps.setInt(5, lv);
					ps.executeUpdate();
			}
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
	return(c);
	}
}
