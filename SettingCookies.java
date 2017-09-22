package cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SettingCookies
 */
@WebServlet("/SettingCookies")
public class SettingCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Cookie firstname=new Cookie("fname",request.getParameter("First_name"));
		Cookie lastname=new Cookie("lname",request.getParameter("Last_name"));
		
		//set the age for cookies
		firstname.setMaxAge(60*60*24);
		lastname.setMaxAge(60*60*24);
		
		//add the cooies to the http response header
		response.addCookie(firstname);
		response.addCookie(lastname);
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String title="COOKIES prgm";
		String docType=
		"<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

		pw.println(docType +
		         "<html>\n" +
		            "<head>"
		            + "<title>" + title + "</title>"
		            + "</head>\n" +
		            
		            "<body bgcolor = \"#f0f0f0\">\n" +
		               "<h2 align = \"center\">" + title + "</h2>\n" +
		               "<ul>\n" +
		                  "  <li><b>First Name</b>: "
		                  + firstname.getValue() + "\n" +
		                  "  <li><b>Last Name</b>: "
		                  + request.getParameter("Last_name") + "\n" +
		               "</ul>\n" +
		            "</body>"
		            + "</html>"
		      );
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
