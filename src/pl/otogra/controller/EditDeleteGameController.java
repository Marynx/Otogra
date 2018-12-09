package pl.otogra.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import pl.otogra.dao.GameDAO;
import pl.otogra.model.Game;
import pl.otogra.model.User;
import pl.otogra.service.GameService;

/**
 * Servlet implementation class EditGameController
 */
@WebServlet(urlPatterns = {"/edit", "/update", "/delete"})
@MultipartConfig
public class EditDeleteGameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getServletPath();
		switch(action) {
		case "/edit":
			saveGameInRequest(request);
			request.getRequestDispatcher("WEB-INF/new.jsp").forward(request, response);
			break;
		case "/update":
			updateGame(request, response);
			break;
		case "/delete":
			deleteGame(request, response);
			break;
		}
	}

	private void updateGame(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		long gameId=Long.parseLong(request.getParameter("id"));
		//System.out.println(gameId);
		String title = request.getParameter("inputTitle");
		String description = request.getParameter("inputDescription");
		int price = Integer.parseInt(request.getParameter("inputPrice"));
		int year = Integer.parseInt(request.getParameter("inputYear"));
		Part file = request.getPart("inputPhoto");
		String photoName = Paths.get(file.getSubmittedFileName()).getFileName().toString();
		//User authorizedUser = (User) request.getSession().getAttribute("user");
		if (request.getUserPrincipal() != null) {
			String filePath = "D:\\workspaceEE\\Otogra\\WebContent\\images";
			String path = filePath + File.separator + photoName;
			GameService service = new GameService();
			//service.addGame(title, description, year, price, photoName, authorizedUser);
			service.updateGame(gameId, title, description, year, price, photoName);
			file.write(path);
			response.sendRedirect(request.getContextPath() + "/my");
		} else {
			response.sendError(403);
		}
	}
	
	private void deleteGame(HttpServletRequest request,HttpServletResponse response) throws IOException {
		long id=Long.parseLong(request.getParameter("id"));
		System.out.println(id);
		GameService service= new GameService();
		service.deleteGame(id);
		response.sendRedirect(request.getContextPath() + "/my");
	}
	
	private void saveGameInRequest(HttpServletRequest request) {
		GameService service= new GameService();
		long id=Long.parseLong(request.getParameter("id"));
		Game game= service.readGame(id);
		request.setAttribute("game",game);
	}
	
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
}
