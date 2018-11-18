package pl.otogra.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.otogra.model.Game;
import pl.otogra.service.GameService;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		saveGamesInRequest(request);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	private void saveGamesInRequest(HttpServletRequest request) {
		GameService service = new GameService();
		List<Game> games = service.getAllGames();
		request.setAttribute("games", games);
	}
	

}
