import java.sql.*;

class ConnDB 
{
	private static ConnDB _instance = null;
	Connection conn;

	private ConnDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/louiedb?user=louiedb&"+"password=louiedb&serverTimezone=UTC");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static ConnDB instance() {
		if(_instance == null) {
			_instance = new ConnDB();
		}
		return(_instance);
	}

	public Connection getConnection() {
		return(conn);
	}
}
