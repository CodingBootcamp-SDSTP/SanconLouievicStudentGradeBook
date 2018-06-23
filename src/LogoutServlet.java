import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class LogoutServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		HttpSession session=request.getSession();
		session.invalidate();
		out.write("<script>function myFunction() {alert('You have successfully log out.');}</script><h3><center><label id='inc'></label></center></h3>");
		out.write("<script>myFunction()</script>");
		out.close();
	}
}
