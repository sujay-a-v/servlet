package prgmservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

import com.sun.org.apache.xalan.internal.xsltc.dom.Filter;

/**
 * Servlet implementation class FilterExp
 */
//@WebServlet("/FilterExp")
public abstract class FilterExp implements Filter {
	private static final long serialVersionUID = 1L;
	
	public void init(FilterConfig fil_conf) throws ServletException
	{
		// get the init parameter
		String parameter=fil_conf.getInitParameter("init-param");
		//display the init parameter
		System.out.println(parameter);
	}
	
	public void doFilter(ServletResponse response,ServletRequest request,FilterChain chain)
	throws IOException,ServletException
	{
		String ipAdd=request.getRemoteAddr();
		Date date=new Date();
		System.out.println("IP Address=" +ipAdd+ "Time" +date.toString() );
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
