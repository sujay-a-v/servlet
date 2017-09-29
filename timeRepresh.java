package prgmservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class timeRepresh
 */
//@WebServlet("/timeRepresh")
public class timeRepresh extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set refresh, autoload time as 3 seconds
	      response.setIntHeader("Refresh", 3);
	 
	      // Sets the content type of the response
	      response.setContentType("text/html");
	 
	      // Get current time
	      Calendar calendar = new GregorianCalendar();
	      String am_pm;
	      int hour = calendar.get(Calendar.HOUR);
	      int minute = calendar.get(Calendar.MINUTE);
	      int second = calendar.get(Calendar.SECOND);
	         
	      if(calendar.get(Calendar.AM_PM) == 0)
	         am_pm = "AM";
	      else
	         am_pm = "PM";
	 
	      String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
	    
	      PrintWriter out = response.getWriter();
	      String title = "Auto Refresh Header Setting";
	      String docType =
	         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

	      out.println(docType +
	         "<html>\n" +
	         "<head><title>" + title + "</title></head>\n"+
	         "<body bgcolor = \"#f0f0f0\">\n" +
	         "<h2 align = \"center\">" + title + "</h2>\n" +
	         "<p>Current Time is: " + CT + "</p>\n"
	      );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
