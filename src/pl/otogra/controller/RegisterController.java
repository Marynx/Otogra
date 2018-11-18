package pl.otogra.controller;



import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import pl.otogra.service.UserService;


@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/register.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email=request.getParameter("inputEmail");
		String username=request.getParameter("inputUsername");
		String password=request.getParameter("inputPassword");
		UserService service= new UserService();
		service.addUser(username, email, password);
		
		
		request.login(username, password);
		response.sendRedirect(request.getContextPath()+"/login");
		//response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

}
