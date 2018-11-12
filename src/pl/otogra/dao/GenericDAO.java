package pl.otogra.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T,PK extends Serializable> {
	
	//CRUD
	void create(T object);
	T read(PK primaryKey);
	void update(T object);
	void delete(PK primaryKey);
	List<T> getAll();
}
