package prgmservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TimeDisplay
 */
//@WebServlet("/TimeDisplay")
public class TimeDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		Date date=new Date();
		
		String title="Display the current time";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		
		pw.print(docType+"\n");
		pw.print("<html>\n");
		pw.print("<head><title>"+title+"</title></head>\n");
		pw.print("<body>\n");
		pw.print("<h3>"+title+"</h3>\n");
		pw.print(date.toString());
		pw.print("</body>\n");
		pw.print("</html>\n");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
