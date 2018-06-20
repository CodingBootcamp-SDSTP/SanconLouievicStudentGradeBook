import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AddServlet
{
	static PreparedStatement ps;

	public static boolean addStudent(String firstname, String lastname, String username, String password, int lv) {
		boolean c =false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/louiedb?user=louiedb&"+"password=louiedb&serverTimezone=UTC");
			String query = "INSERT INTO students(firstname, lastname, username, password, userlevel) VALUES (?, ?, ?, ?, ?);";
			ps =conn.prepareStatement(query);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.setInt(5, lv);
			ps.executeUpdate();
			c=true;
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
	return c;
	}

	public static boolean addFaculty(String firstname, String lastname, String username, String password, int lv) {
		boolean c =false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/louiedb?user=louiedb&"+"password=louiedb&serverTimezone=UTC");
			String query = "INSERT INTO faculty(firstname, lastname, username, password, userlevel) VALUES (?, ?, ?, ?, ?);";
			ps =conn.prepareStatement(query);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.setInt(5, lv);
			ps.executeUpdate();
			c=true;
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
	return c;
	}
}
