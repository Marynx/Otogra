package pl.otogra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import pl.otogra.model.Review;
import pl.otogra.util.ConnectionProvider;

public class ReviewDAOImpl implements ReviewDAO{
	
	private static final String CREATE_REVIEW="INSERT INTO review(user_id,game_id,time,score,comment) VALUES (:userId,:gameId,:time,:score,:comment)";
	private static final String READ_ALL_REVIEWS="SELECT * FROM review where game_id=:game_id";
	private static final String READ_SCORE="SELECT SUM(score) FROM review where game_id=:game_id";
	private NamedParameterJdbcTemplate template;
	
	public ReviewDAOImpl() {
		template= new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}
	
	@Override
	public void create(Review review) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(review);
		template.update(CREATE_REVIEW, param);
	}

	@Override
	public Review read(Long primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Review object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long primaryKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Review> getAll() {
		return null;
	}
	
	@Override
	public List<Review> getAllByGameId(long id) {
		SqlParameterSource param= new MapSqlParameterSource("game_id",id);
		List<Review> reviews= template.query(READ_ALL_REVIEWS,param,new ReviewMapper());
		return reviews;
	}
	
	@Override
	public int getScore(long id) {
		SqlParameterSource param= new MapSqlParameterSource("game_id",id);
		int score=template.queryForInt(READ_SCORE, param);
		return score;
	}
	
	private class ReviewMapper implements RowMapper<Review>{

		@Override
		public Review mapRow(ResultSet rs, int row) throws SQLException {
			Review review= new Review();
			review.setId(rs.getInt("review_id"));
			review.setUserId(rs.getInt("user_id"));
			review.setGameId(rs.getInt("game_id"));
			review.setTime(rs.getTimestamp("time"));
			review.setScore(rs.getInt("score"));
			review.setComment(rs.getString("comment"));
			return review;
		}
		
	}
	
	
}
