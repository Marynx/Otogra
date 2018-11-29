package pl.otogra.dao;

import java.util.List;

import pl.otogra.model.Game;

public interface GameDAO extends GenericDAO<Game, Long> {

	int getReviewCount(Long id);
	List<Game> userGames(Long id);

}
