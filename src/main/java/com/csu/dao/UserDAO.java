package com.csu.dao;

import java.util.List;

import com.csu.model.User;

public interface UserDAO {
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
	
	public User queryUser(int id);
	
	public List<User> GetAllUser();	
	
	public List<User> QueryUserByNumber(String UserNumber);
}
