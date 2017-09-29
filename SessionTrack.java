package prgmservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTrack
 */
@WebServlet("/SessionTrack")
public class SessionTrack extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession(true);
		
		Date create=new Date(session.getCreationTime());
		
		Date lastAccess=new Date(session.getLastAccessedTime());
		String title="Welcome back";
		Integer count=new Integer(0);
		String visitCountKey="visitCount";
		String userIDKey="userID";
		String userID="ABCD";
		
		if(session.isNew())
		{
			title="Welcome new";
			session.setAttribute(userIDKey, userID);
		}
		else
		{
			count=(Integer)session.getAttribute(visitCountKey);
			count=count+1;
			userID=(String)session.getAttribute(userIDKey);
		}
		session.setAttribute(visitCountKey, count);
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String docType =
		         "<!doctype html public \"-//w3c//dtd html 4.0 " +
		         "transitional//en\">\n";

		      out.println(docType +
		         "<html>\n" +
		            "<head><title>" + title + "</title></head>\n" +
		            
		            "<body bgcolor = \"#f0f0f0\">\n" +
		               "<h1 align = \"center\">" + title + "</h1>\n" +
		               "<h2 align = \"center\">Session Infomation</h2>\n" +
		               "<table border = \"1\" align = \"center\">\n" +
		                  
		                  "<tr bgcolor = \"#949494\">\n" +
		                     "  <th>Session info</th><th>value</th>"
		                     + "</tr>\n" +
		                     
		                  "<tr>\n" +
		                     "  <td>id</td>\n" +
		                     "  <td>" + session.getId() + "</td>"
		                     		+ " </tr>\n" +
		                  
		                  "<tr>\n" +
		                     "  <td>Creation Time</td>\n" +
		                     "  <td>" + create + "  </td>"
		                     		+ "</tr>\n" +
		                  
		                  "<tr>\n" +
		                     "  <td>Time of Last Access</td>\n" +
		                     "  <td>" + lastAccess + "  </td>"
		                     		+ "</tr>\n" +
		                  
		                  "<tr>\n" +
		                     "  <td>User ID</td>\n" +
		                     "  <td>" + userID + "  </td>"
		                     		+ "</tr>\n" +
		                  
		                  "<tr>\n" +
		                     "  <td>Number of visits</td>\n" +
		                     "  <td>" + count + "</td>"
		                     		+ "</tr>\n" +
		               "</table>\n" +
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
