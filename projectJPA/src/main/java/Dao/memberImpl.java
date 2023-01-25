package Dao;

import java.util.List;

public interface memberImpl {
	//Create
	void add(Object o);
	
	//Read
	List<Object> queryAll();
	List<Object> queryUser(String user, String pass);
	Object queryId(int id);
	
	//Update
	boolean update(String username, String password, String phone, String email, int id);
	boolean update(Object o);
	
	//Delete
	boolean delete(int id);
	
}
