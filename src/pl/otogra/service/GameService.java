package pl.otogra.service;

import java.util.List;

import pl.otogra.dao.GameDAO;
import pl.otogra.dao.MysqlDAOFactory;
import pl.otogra.dao.ReviewDAO;
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
	public void updateGame(long id,String title, String description, int year, double price,String photo) {
		MysqlDAOFactory factory= new MysqlDAOFactory();
		GameDAO gameDao=factory.getGameDAO();
		Game gameToUpdate=gameDao.read(id);
		gameToUpdate.setTitle(title);
		gameToUpdate.setDescription(description);
		gameToUpdate.setYear(year);
		gameToUpdate.setPrice(price);
		gameToUpdate.setPhoto(photo);
		gameDao.update(gameToUpdate);
	}
	
	public void deleteGame(long id) {
		MysqlDAOFactory factory= new MysqlDAOFactory();
		GameDAO gameDao=factory.getGameDAO();
		gameDao.delete(id);
	}
	
	public List<Game> getAllGames(){
		MysqlDAOFactory factory = new MysqlDAOFactory();
		GameDAO gameDao=factory.getGameDAO();
		return gameDao.getAll();
	}
	public Game readGame(Long id) {
		MysqlDAOFactory factory= new MysqlDAOFactory();
		GameDAO gameDao= factory.getGameDAO();
		Game game = gameDao.read(id);
		return game;
	}
	public int getReviewCount(long id) {
		MysqlDAOFactory factory=new MysqlDAOFactory();
		GameDAO gameDao=factory.getGameDAO();
		int count=gameDao.getReviewCount(id);
		return count;
	}
	public List<Game> getAllUserGames(Long id){
		MysqlDAOFactory factory=new MysqlDAOFactory();
		GameDAO gameDao=factory.getGameDAO();
		List<Game> userGames=gameDao.userGames(id);
		return userGames;
	}
}
