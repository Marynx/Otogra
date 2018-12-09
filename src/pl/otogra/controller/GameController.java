package pl.otogra.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.otogra.model.Game;
import pl.otogra.model.Review;
import pl.otogra.service.GameService;
import pl.otogra.service.ReviewService;

/**
 * Servlet implementation class GameController
 */
@WebServlet("/game")
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		saveGameInRequest(request);
		saveReviewsInRequest(request);
		request.getRequestDispatcher("WEB-INF/game.jsp").forward(request, response);
	}

	private void saveGameInRequest(HttpServletRequest request) {
		GameService service = new GameService();
		long gameId=Long.parseLong(request.getParameter("id"));
		Game game=service.readGame(gameId);
		int count=service.getReviewCount(gameId);
		request.setAttribute("reviewCount", count);
		request.setAttribute("game", game);
	}
	private void saveReviewsInRequest(HttpServletRequest request) {
		ReviewService service=new ReviewService();
		long gameId=Long.parseLong(request.getParameter("id"));
		int score=service.getScore(gameId);
		List<Review> reviews=service.getReviewsByGameId(gameId);
		request.setAttribute("score", score);
		request.setAttribute("reviews", reviews);
	}

}
