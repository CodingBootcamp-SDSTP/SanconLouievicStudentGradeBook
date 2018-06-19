import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ValidateServlet
{
	static PreparedStatement ps;
	static PreparedStatement as;

	

	public static boolean checkUser(String user,String password) {
		boolean st =false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/louiedb?user=louiedb&"+"password=louiedb&serverTimezone=UTC");
			ps =conn.prepareStatement("SELECT * FROM users WHERE user=? and password=?");
			ps.setString(1, user);
			ps.setString(2, password);
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
		System.out.println(st);
		return st;
	}

	public static boolean addStudent(String firstname, String lastname, String username, String password, int lv) {
		boolean st =false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/louiedb?user=louiedb&"+"password=louiedb&serverTimezone=UTC");
			String query = "INSERT INTO students(firstname, lastname, username, password, userlevel) VALUES (?, ?, ?, ?, ?);";
			as =conn.prepareStatement(query);
			as.setString(1, firstname);
			as.setString(2, lastname);
			as.setString(3, username);
			as.setString(4, password);
			as.setInt(5, lv);
			as.executeUpdate();
			st=true;
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
	return st;
	}

	public static boolean deleteStudent(String id, String firstname) {
		boolean st =false;
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/louiedb?user=louiedb&"+"password=louiedb&serverTimezone=UTC");
				String query = "DELETE FROM students WHERE id=? && firstname=?;";
				as =conn.prepareStatement(query);
				as.setString(1, id);
				as.setString(2, firstname);
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
		return st;
	}

	public static boolean updateStudent(String id) {
		boolean st =false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/louiedb?user=louiedb&"+"password=louiedb&serverTimezone=UTC");
			ps =conn.prepareStatement("SELECT * FROM students WHERE id=?");
			ps.setString(1, id);
			ResultSet rs =ps.executeQuery();
			st = rs.next();
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
		return st;
	}

	public static boolean listAllRecords() {
		boolean st = false;
		
		return(st);
	}
}
