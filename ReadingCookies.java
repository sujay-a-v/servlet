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
 * Servlet implementation class ReadingCookies
 */
@WebServlet("/ReadingCookies")
public class ReadingCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Cookie cookie=null;
		Cookie[] cookies=null;
		
		//get the cookies
		cookies=request.getCookies();
		
		PrintWriter out=response.getWriter();
		
		response.setContentType("text/html");
		
		String title = "Reading Cookies";
	      String docType =
	         "<!doctype html public \"-//w3c//dtd html 4.0 " +
	         "transitional//en\">\n";
	         
	      out.println(docType +
	         "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor = \"#f0f0f0\">\n" );

	      if( cookies != null ) {
	         out.println("<h2> Found Cookies Name and Value</h2>");

	         for (int i = 0; i < cookies.length; i++) {
	            cookie = cookies[i];
	            out.print("Name : " + cookie.getName( ) + ",\t  ");
	            out.print("Value: " + cookie.getValue( ) + " <br/>");
	         }
	      } else {
	         out.println("<h2>No cookies founds</h2>");
	      }
	      out.println("</body>");
	      out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
