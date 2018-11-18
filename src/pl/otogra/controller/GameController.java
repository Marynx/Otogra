package pl.otogra.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.otogra.model.Game;
import pl.otogra.service.GameService;

/**
 * Servlet implementation class GameController
 */
@WebServlet("/game")
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		saveGameInRequest(request);
		request.getRequestDispatcher("game.jsp").forward(request, response);
	}

	private void saveGameInRequest(HttpServletRequest request) {
		GameService service = new GameService();
		long gameId=Long.parseLong(request.getParameter("id"));
		Game game=service.getGameById(gameId);
		request.setAttribute("game", game);
	}

}
