package pl.otogra.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import pl.otogra.model.Game;
import pl.otogra.model.User;
import pl.otogra.util.ConnectionProvider;

public class GameDAOImpl implements GameDAO{

	private static final String CREATE_GAME="INSERT INTO game(title,description,year,price,user_id,score,photo)"
			+ "VALUES(:title,:description,:year,:price,:user_id,:score,:photo)";
	//private static final String READ_GAME_BY_ID="SELECT game_id,title,description,year,price,user_id,score,photo FROM game where game_id=:game_id";
	private static final String READ_GAME_BY_ID="SELECT user.user_id,username,email,password,game_id,title,description,year,price,score,photo FROM game left join user on user.user_id=game.user_id where game_id=:game_id;";
	private static final String READ_ALL_GAMES="SELECT * FROM game LEFT JOIN user ON game.user_id=user.user_id;";
	private static final String READ_ALL_GAMES_BYUSERID="SELECT * FROM game LEFT JOIN user ON game.user_id=user.user_id WHERE game.user_id=:user_id;";
	private static final String COUNT_REVIEWS="SELECT COUNT(*) FROM review WHERE game_id=:game_id";
	private static final String UPDATE_GAME="UPDATE game SET title=:title,description=:description,year=:year,price=:price,photo=:photo WHERE game_id=:game_id";
	private static final String DELETE_GAME="DELETE FROM game WHERE game_id=:game_id;";
	
	
	private NamedParameterJdbcTemplate template;

	public GameDAOImpl() {
		template=new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}
	
	@Override
	public void create(Game game) {
		Map<String,Object> paramMap= new HashMap<String,Object>();	
		paramMap.put("title", game.getTitle());
		paramMap.put("description", game.getDescription());
		paramMap.put("year", game.getYear());
		paramMap.put("price", game.getPrice());
		paramMap.put("user_id", game.getUser().getId());
		paramMap.put("score",game.getScore());
		paramMap.put("photo", game.getPhoto());
		SqlParameterSource source=new MapSqlParameterSource(paramMap);
		//tutaj sprobowac z paramMap??????????????s
		template.update(CREATE_GAME, source);
	}

	@Override
	public Game read(Long id) {
		Game resultGame= null;
		SqlParameterSource param= new MapSqlParameterSource("game_id",id);
		resultGame=template.queryForObject(READ_GAME_BY_ID, param,new GameMapper());
		return resultGame;
	}

	@Override
	public void update(Game game) {
		Map<String,Object> paramMap= new HashMap<String,Object>();	
		paramMap.put("game_id", game.getId());
		paramMap.put("title", game.getTitle());
		paramMap.put("description", game.getDescription());
		paramMap.put("year", game.getYear());
		paramMap.put("price", game.getPrice());
		paramMap.put("user_id", game.getUser().getId());
		paramMap.put("score",game.getScore());
		paramMap.put("photo", game.getPhoto());
		SqlParameterSource source=new MapSqlParameterSource(paramMap);
		template.update(UPDATE_GAME, source);
	}

	@Override
	public void delete(Long id) {
		SqlParameterSource param= new MapSqlParameterSource("game_id",id);
		int c=template.update(DELETE_GAME, param);
		System.out.println(c);
	}
	@Override
	public List<Game> getAll() {
		List<Game> games=template.query(READ_ALL_GAMES, new GameMapper());
		return games;
	}
	@Override
	public int getReviewCount(Long id) {
		SqlParameterSource param= new MapSqlParameterSource("game_id",id);
		int reviewNumber=template.queryForInt(COUNT_REVIEWS, param);
		return reviewNumber;
	}
	
	@Override
	public List<Game> userGames(Long id) {
		SqlParameterSource param= new MapSqlParameterSource("user_id",id);
		List<Game> userGames=template.query(READ_ALL_GAMES_BYUSERID, param, new GameMapper());
		return userGames;
	}
	
	private class GameMapper implements RowMapper<Game>{

		@Override
		public Game mapRow(ResultSet rs, int row) throws SQLException {
			Game game = new Game();
			game.setId(rs.getInt("game_id"));
			game.setTitle(rs.getString("title"));
			game.setDescription(rs.getString("description"));
			game.setPrice(rs.getDouble("price"));
			game.setYear(rs.getInt("year"));
			game.setScore(rs.getInt("score"));
			game.setPhoto(rs.getString("photo"));
			User user = new User();
			user.setId(rs.getInt("user_id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			game.setUser(user);
			return game;
		}
		
	}

	

	

	


}
