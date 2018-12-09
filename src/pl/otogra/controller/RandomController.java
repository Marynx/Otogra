package pl.otogra.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.otogra.model.Game;
import pl.otogra.service.GameService;


@WebServlet("/random")
public class RandomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GameService service=new GameService();
		List<Game> allGames=service.getAllGames();
		Random random=new Random();
		int randomNumber=random.nextInt(allGames.size());
		long randomGameId=allGames.get(randomNumber).getId();
		response.sendRedirect(request.getContextPath()+"/game?id="+randomGameId);
	}
}
