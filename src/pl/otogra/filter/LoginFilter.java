package pl.otogra.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import pl.otogra.model.User;
import pl.otogra.service.UserService;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq=(HttpServletRequest) request;
		if(httpReq.getUserPrincipal()!=null && httpReq.getSession().getAttribute("user")==null) {
			saveUserInHttp(httpReq);
		}
		chain.doFilter(request, response);
	}
	
	private void saveUserInHttp(HttpServletRequest request) {
		UserService service =new UserService();
		String username=request.getUserPrincipal().getName();
		User user= service.getUserByUsername(username);	
		request.getSession(true).setAttribute("user", user);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
