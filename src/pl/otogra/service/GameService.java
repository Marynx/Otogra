package pl.otogra.service;

import java.util.List;

import pl.otogra.dao.GameDAO;
import pl.otogra.dao.MysqlDAOFactory;
import pl.otogra.model.Game;
import pl.otogra.model.User;

public class GameService {
	public void addGame(String title, String description, int year, double price,String photo,User user ) {
		Game game=new Game();
		game.setTitle(title);
		game.setDescription(description);
		game.setYear(year);
		game.setPrice(price);
		game.setPhoto(photo);
		game.setUser(user);
		MysqlDAOFactory factory= new MysqlDAOFactory();
		GameDAO gameDao=factory.getGameDAO();
		gameDao.create(game);
	}
	public List<Game> getAllGames(){
		MysqlDAOFactory factory = new MysqlDAOFactory();
		GameDAO gameDao=factory.getGameDAO();
		return gameDao.getAll();
	}
	public Game getGameById(Long id) {
		MysqlDAOFactory factory= new MysqlDAOFactory();
		GameDAO gameDao= factory.getGameDAO();
		Game game = gameDao.getGameById(id);
		return game;
	}
}
