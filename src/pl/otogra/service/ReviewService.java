package pl.otogra.service;

import java.util.Collections;
import java.util.List;

import pl.otogra.dao.MysqlDAOFactory;
import pl.otogra.dao.ReviewDAO;
import pl.otogra.model.Review;

public class ReviewService {
	public void addReview(long userId,long gameId,int score,String comment) {
		Review review=new Review(userId,gameId,score,comment);
		MysqlDAOFactory factory= new MysqlDAOFactory();
		ReviewDAO reviewDao= factory.getReviewDAO();
		reviewDao.create(review);
	}
	public List<Review> getReviewsByGameId(long id) {
		MysqlDAOFactory factory=new MysqlDAOFactory();
		ReviewDAO reviewDao=factory.getReviewDAO();
		List<Review> reviews=reviewDao.getAllByGameId(id);
		Collections.reverse(reviews);
		return reviews;
	}
	public int getScore(long id) {
		MysqlDAOFactory factory= new MysqlDAOFactory();
		ReviewDAO reviewDao=factory.getReviewDAO();
		int score = reviewDao.getScore(id);
		return score;
	}
}
