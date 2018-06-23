import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class AdminProfileServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		if(session!=null) {
			String name=(String)session.getAttribute("user");
			out.write("<style>body {margin: 0px;} #header {background: rgb(0, 0, 0); color: white; font-size: 20px; padding: 20px; } #header > #name { font-weight: bold; float: left; color: rgb(64, 255, 46); font-size: 20px;} @media only screen and (min-width: 600px) { #menu {float: right;display: block;} .menuitem {display: inline;} .menuitem + .menuitem {border-left: 1px solid white;margin-left: 10px; padding-left: 8px;} #menubutton {display: none;} } .button { background-color: rgba(8, 0, 0, 0.432); color: rgb(245, 245, 245); border: 2px solid #000000; } .button:hover { background-color: #000000; color: rgb(64, 255, 46); cursor: pointer; font-size: 18px; } .clear { clear: both; } #form2 { margin-left: 33%; margin-top: 17%; }</style><script>function addStudent() { var xhttp = new XMLHttpRequest(); xhttp.onreadystatechange = function() { if (this.readyState == 4 && this.status == 200) { document.getElementById('form2').innerHTML = this.responseText; } }; xhttp.open('GET', 'pages/addStudent.html', true); xhttp.send(); } function addFaculty() { var xhttp = new XMLHttpRequest(); xhttp.onreadystatechange = function() { if (this.readyState == 4 && this.status == 200) { document.getElementById('form2').innerHTML = this.responseText; } }; xhttp.open('GET', 'pages/addFaculty.html', true); xhttp.send(); } function delStudent() { var xhttp = new XMLHttpRequest(); xhttp.onreadystatechange = function() { if (this.readyState == 4 && this.status == 200) { document.getElementById('form2').innerHTML = this.responseText; } }; xhttp.open('GET', 'pages/delStudent.html', true); xhttp.send(); } function modStudent() { var xhttp = new XMLHttpRequest(); xhttp.onreadystatechange = function() { if (this.readyState == 4 && this.status == 200) { document.getElementById('form2').innerHTML = this.responseText; } };	xhttp.open('GET', 'pages/updateStudents.html', true); xhttp.send(); }function listStudent() { var xhttp = new XMLHttpRequest(); xhttp.onreadystatechange = function() { if (this.readyState == 4 && this.status == 200) { document.getElementById('form2').innerHTML = this.responseText; } }; xhttp.open('GET', 'AllRecords.java', true); xhttp.send(); }</script><div id='header'><div id='name'>The Admin Page</div><div class='menuitem'><input type='submit' class='button' value='Add a Student Account' onclick='addStudent()'></div><div class='menuitem'><input type='submit' class='button' value='Add a Faculty Account' onclick='addFaculty()'></div><div class='menuitem'><input type='submit' class='button' value='Delete a Student Account' onclick='delStudent()'></div><div class='menuitem'><input type='submit' class='button' value='Modify a Student Account' onclick='modStudent()'></div><form method='POST' class='menuitem' action='/login/allrecord'><input type='submit' action='/login/allrecord' class='button' value='Show Students Records' onclick='listStudent()'></form><form method class='menuitem' action='/login/logout'><input type='submit' class='button' value='Log out' onclick='logout()'></form></div><div class='clear'></div></div><div id='form2'>Nothing to show yet.</div>");
			// request.getRequestDispatcher("pages/adminpage.html").include(request, response);
			// response.sendRedirect("pages/adminpage.html");
		}
		else {
			out.write("<link rel='stylesheet' href='adminstyle.css'><script>function myFunction() {alert('Please Login first!');}</script><h3><center><label id='inc'></label></center></h3>");
			out.write("<script>myFunction()</script>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		out.close();
	}
}