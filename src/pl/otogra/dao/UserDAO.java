package pl.otogra.dao;

import pl.otogra.model.User;

public interface UserDAO extends GenericDAO<User, Long>{
	User getUserByUsername(String username);
}
