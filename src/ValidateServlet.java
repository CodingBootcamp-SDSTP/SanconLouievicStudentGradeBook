import java.sql.*;

public class ValidateServlet
{
	public static boolean checkUser(String user,String password) {
		boolean st =false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/louiedb?user=louiedb&"+"password=louiedb&serverTimezone=UTC");
			PreparedStatement ps =conn.prepareStatement("SELECT * FROM users WHERE user=? and password=?");
			ps.setString(1, user);
			ps.setString(2, password);
			ResultSet rs =ps.executeQuery();
			st = rs.next();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return st;
	}
}
