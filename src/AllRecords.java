import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AllRecords extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/louiedb?user=louiedb&"+"password=louiedb&serverTimezone=UTC");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM students");
			StringBuilder sb = new StringBuilder("<students>");
			while(rs.next()) {
				sb.append("<studentId>"+rs.getString("id")+"</studentId>");
				sb.append("<firstName>"+rs.getString("firstname")+"</firstName>");
				sb.append("<lastName>"+rs.getString("lastname")+"</lastName>");
				sb.append("<username>"+rs.getString("username")+"</username>");
				sb.append("<password>"+rs.getString("password")+"</password>");
				sb.append("<userlevel>"+rs.getString("userlevel")+"</userlevel>");
				sb.append("<endOfDetails>-------------------------------</endOfDetails>");
			}
			sb.append("</students>");
			out.print(sb.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
