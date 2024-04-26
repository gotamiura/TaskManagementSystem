package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class TestFilter
 */
@WebFilter("/*")
public class TestFilter extends HttpFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpSession session = httpRequest.getSession();
	    
	    if(session.getAttribute("UserName") == null && !(httpRequest.getRequestURI().equals("/TaskManagementSystem/LoginServlet"))) {
	        httpRequest.getRequestDispatcher("login.jsp").forward(httpRequest, response);
	    }
	    
	    chain.doFilter(request, response);
	}
}
