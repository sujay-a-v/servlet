package dataandtime;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NumberOfHits
 */
@WebServlet("/NumberOfHits")
public class NumberOfHits extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int count;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		count=0;
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setIntHeader("Refresh", 5);
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		count++;
		String title="Nomber of hits ";
		String doct="";
		
		pw.print("<!doctype html\n");
		pw.print("<html>\n");
		pw.print("<head><title>"+title+"</title></head>\n");
		pw.print("<body>\n");
		pw.print("<h3>"+title+"</h3>\n");
		pw.print(count);
		pw.print("</body>\n");
		pw.print("</html>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
