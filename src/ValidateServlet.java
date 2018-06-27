import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ValidateServlet
{
	static PreparedStatement ps;

	public static int checkUserLevel(String user, String pass) {
		try {
			ConnDB cb = ConnDB.instance();
			Connection conn = cb.getConnection();
			ps =conn.prepareStatement("SELECT userlevel FROM useradmin WHERE user=? and password=?");
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				return(1);
			}
			else if(rs.next() == false) {
				ps =conn.prepareStatement("SELECT userlevel FROM faculty WHERE username=? and password=?");
				ps.setString(1, user);
				ps.setString(2, pass);
				ResultSet st =ps.executeQuery();
				if(st.next()) {
					return(2);
				}
				else if(st.next() == false) {
					ps =conn.prepareStatement("SELECT userlevel FROM students WHERE username=? and password=?");
					ps.setString(1, user);
					ps.setString(2, pass);
					ResultSet rt =ps.executeQuery();
					if(rt.next()) {
						return(4);
					}
					else {
						return(0);
					}
				}
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
		return(0);
	}
}
