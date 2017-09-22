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
 * Servlet implementation class deleteCookies
 */
//@WebServlet("/DELETECOOKIE")
public class DELETECOOKIE extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie cookie=null;
		Cookie[] cookies=null;
		
		cookies=request.getCookies();
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		String title="Delete cookie";	
		
		String docType =
		         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        
	      pw.println(docType +
	         "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor = \"#f0f0f0\">\n" );
	         
	      if( cookies != null ) {
	         pw.println("<h2> Cookies Name and Value</h2>");

	         for (int i = 0; i < cookies.length; i++) {
	            cookie = cookies[i];

	            if((cookie.getName()).compareTo("fname") == 0 ) {
	               cookie.setMaxAge(0);
	               response.addCookie(cookie);
	              pw.print("Deleted cookie : " + cookie.getName( ) + "<br/>");
	            }
	            pw.print("Name : " + cookie.getName( ) + ",  ");
	            pw.print("Value: " + cookie.getValue( )+" <br/>");
	         }
	      } else {
	         pw.println("<h2>No cookies founds</h2>");
	      }
	      pw.println("</body>");
	      pw.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}