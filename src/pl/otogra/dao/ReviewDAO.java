package pl.otogra.dao;

import java.util.List;

import pl.otogra.model.Review;

public interface ReviewDAO extends GenericDAO<Review, Long>{
	public List<Review> getAllByGameId(long id);
	public int getScore(long id);
}
