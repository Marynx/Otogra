package pl.otogra.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.otogra.model.Game;
import pl.otogra.model.User;
import pl.otogra.service.GameService;

/**
 * Servlet implementation class UserGamesController
 */
@WebServlet("/my")
public class UserGamesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UserGamesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		saveGamesInRequest(request);
		request.getRequestDispatcher("WEB-INF/userGames.jsp").forward(request, response);;
	}
	private void saveGamesInRequest(HttpServletRequest request) {
		User loggedUser=(User) request.getSession().getAttribute("user");
		GameService service = new GameService();
		if(loggedUser!=null) {
			long id= loggedUser.getId();
			List<Game> userGames=service.getAllUserGames(id);
			request.setAttribute("userGames", userGames);
		}else {
			System.out.println("eeror");
		}
		
	}
	

}
