package access;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class DatabaseAccesse
 */
@WebServlet("/DatabaseAccesse")
public class DatabaseAccesse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String JDBC_driver="com.mysql.jdbc.Driver";
		String DB_url="jdbc:mysql://localhost:3306/TEST123";
		
		String user="root";
		String pw="root";
		
		PrintWriter printwrite=response.getWriter();
		response.setContentType("text/html");
		String title="Database Access";
		
		 String docType =
		         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		      
		 printwrite.println(docType +
		         "<html>\n" +
		         "<head><title>" + title + "</title></head>\n" +
		         "<body bgcolor = \"#f0f0f0\">\n" +
		         "<h1 align = \"center\">" + title + "</h1>\n");
		 
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			 
			 Connection con = (Connection) DriverManager.getConnection(DB_url, user, pw);

	         java.sql.Statement stmt = ((java.sql.Connection) con).createStatement();
	         String sql="SELECT * FROM Employees123";
	         
	         ResultSet rs=stmt.executeQuery(sql);
	         
	         while(rs.next())
	         {
	        	 int id=rs.getInt("ID");
	        	 int age=rs.getInt("Age");
	        	 String first_name=rs.getString("Firstname");
	        	 String last_name=rs.getString("Lastname");
	        	 
	        	 System.out.println(id+" "+ age +" "+first_name+" "+last_name);
	         }
	         
	         printwrite.println("</body></html>");
	         
	         rs.close();
	         stmt.close();
	         con.close();
			 
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
