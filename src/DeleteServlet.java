import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DeleteServlet extends HttpServlet
{
	String id;
	String firstname;
	static PreparedStatement ps;
	RequestDispatcher rs;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		id = request.getParameter("id");
		firstname = request.getParameter("firstname");
		if(deleteStudent(id, firstname)) {
			response.sendRedirect("pages/adminpage.html");
			rs.forward(request, response);
		}
		else {
			response.sendRedirect("pages/adminpage.html");
		}
	}

	public static boolean deleteStudent(String id, String firstname) {
		boolean st =false;
		try {
			ConnDB cb = ConnDB.instance();
			Connection conn = cb.getConnection();
			String query = "DELETE FROM students WHERE studentid=? && firstname=?;";
			ps =conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, firstname);
			ps.executeUpdate();
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
		firstname = null;
		rs = null;
	}
}
