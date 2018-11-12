package pl.otogra.dao;

public class MysqlDAOFactory {

	
	
	
	public UserDAO getUserDAO() {
		
		return new UserDAOImpl();
	}

	
	public GameDAO getGameDAO() {
		
		return new GameDAOImpl();
	}

	
	public ReviewDAO getReviewDAO() {
		
		return new ReviewDAOImpl();
	}

}
