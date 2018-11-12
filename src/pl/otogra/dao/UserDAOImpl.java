package pl.otogra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import pl.otogra.model.User;
import pl.otogra.util.ConnectionProvider;

public class UserDAOImpl implements UserDAO{
	
	private static final String CREATE_USER="INSERT INTo user(username,email,password) VALUES(:username,:email,:password)";
	private static final String READ_USER="SELECT * FROM user WHERE user_id=:id";
	private static final String DELETE_USER="DELETE FROM user WHERE user_id=:id";
	private static final String UPDATE_USER="UPDATE vote set email=:email where user_id=:id";
	private static final String READ_USER_BY_USERNAME="SELECT user_id,username,email,password FROM user WHERE username=:username";
	
	private NamedParameterJdbcTemplate template;
	
	public UserDAOImpl() {
		template=new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}
	
	
	@Override
	public void create(User user) {
		SqlParameterSource source = new BeanPropertySqlParameterSource(user);
		int create=template.update(CREATE_USER, source);
		if(create>0) {
			setPrivigles(user);
		}
		
	}

	@Override
	public User read(Long primaryKey) {
		User user=null;
		SqlParameterSource paramSource=new MapSqlParameterSource("id",primaryKey);
		user=template.queryForObject(READ_USER, paramSource, new UserMapper());
		return user;
	}

	@Override
	public void update(User user) {
		SqlParameterSource source= new BeanPropertySqlParameterSource(user);
		template.update(UPDATE_USER, source);
		
	}

	@Override
	public void delete(Long primaryKey) {
		SqlParameterSource source= new MapSqlParameterSource("id",primaryKey);
		template.update(DELETE_USER, source);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void setPrivigles(User user) {
		final String userRoleQuery="INSERT INTO user_role(username) VALUES (:username)";
		SqlParameterSource param= new MapSqlParameterSource("username",user.getUsername());
		template.update(userRoleQuery, param);
	}
	

	@Override
	public User getUserByUsername(String username) {
		User user=null;
		SqlParameterSource param= new MapSqlParameterSource("username",username);
		user=template.queryForObject(READ_USER_BY_USERNAME, param, new UserMapper());
		return user;
	}
	
	private class UserMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user=new User();
			user.setId(rs.getInt("user_id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			return user;
		}
		
	}

}
