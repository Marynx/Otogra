package pl.otogra.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


import pl.otogra.dao.MysqlDAOFactory;
import pl.otogra.dao.UserDAO;

import pl.otogra.model.User;

public class UserService {

	
	public void addUser(String username,String email,String password) {
		User user=new User();
		user.setUsername(username);
		user.setEmail(email);
		String pass=encryptedPassword(password);
		user.setPassword(pass);
		MysqlDAOFactory factory= new MysqlDAOFactory();
		UserDAO userDao= factory.getUserDAO();
		userDao.create(user);
		
	}
	
	private String encryptedPassword(String password) {
		MessageDigest md = null;
		try {
			md= MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(password.getBytes());
		String md5Password= new BigInteger(1,md.digest()).toString(16);
		
		return md5Password;
	}
	
	public User read(Long id) {
		MysqlDAOFactory factory= new MysqlDAOFactory();
		UserDAO dao= factory.getUserDAO();
		User user=dao.read(id);
		return user;
	}
	
	public User getUserByUsername(String username) {
		MysqlDAOFactory factory= new MysqlDAOFactory();
		UserDAO dao= factory.getUserDAO();
		User user= dao.getUserByUsername(username);
		System.out.println(user);
		return user;
	}
	
	
	public void updateUser(User user) {
		MysqlDAOFactory factory=new MysqlDAOFactory();
		UserDAO dao=factory.getUserDAO();
		dao.update(user);
	}
	
	public void deleteUser(Long userId) {
		MysqlDAOFactory factory=new MysqlDAOFactory();
		UserDAO dao=factory.getUserDAO();
		dao.delete(userId);
	}	
}
