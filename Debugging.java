package debuggg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.ServletContext;

/**
 * Servlet implementation class Debugging
 */
@WebServlet("/Debugging")
public class Debugging extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String par1=request.getParameter("name");
		String par2=request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String name="bridge";
		String password="123";
		
		if(par1=="" || par1==null)
		{
			System.out.println("Name field can't be empty");
		}
		else if(par2=="" || par2==null)
		{
			System.out.println("Password field can't be empty");
		}
		else if(par1.equals(name) && par2.equals(password))
		{
			System.out.println("You are welcome");
		}
		else
		{
			System.out.println("you entered wrong values");
		}
		
		
		/*Cookie cookie=null;
		Cookie[] cookies=null;
		
		String par1=request.getParameter("name");
   		String par2=request.getParameter("password");
		
		//get the cookies
		cookies=request.getCookies();
		if( cookies != null )
		{
			

	         for (int i = 0; i < cookies.length; i++) 
	         {
	           cookie = cookies[i];
	           String name=cookie.getName();
	           String password=cookie.getValue( );
	           
		   		response.setContentType("text/html");
		   		PrintWriter pw=response.getWriter();
		   		
		   		if(par1=="" || par1==null)
		   		{
		   			System.out.println("Name field can't be empty");
		   		}
		   		else if(par2=="" || par2==null)
		   		{
		   			System.out.println("Password field can't be empty");
		   		}
		   		else if(par1.equals(name) && par2.equals(password))
		   		{
		   			System.out.println("You are welcome");
		   			
		   			System.out.println(name);
		   	        System.out.println(password);
		   	        
		   			System.exit(0);
		   		}
	         }
	         System.out.println("you entered wrong values");     
		}*/
		
		
		
		/*String title=" debug ";
		String doc="";
		
		pw.print("<!DOCTYPE html");
		pw.print("<html>");
		pw.print("<head><title>"+title+"</title></head>");
		pw.print("<body>");
		pw.print("<h3>Debugging</h3>");
		pw.print("<p>message sent</p>");
		pw.print("</body>");
		pw.print("</html>");*/
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
