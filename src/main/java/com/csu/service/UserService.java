package com.csu.service;

import java.util.List;

import com.csu.model.User;

public interface UserService {

	public void AddUser(User user);
	
	public void UpdateUser(User user);
	
	public void DeleteUser(User user);
	
	public User QueryUser(int id);
	
	public List<User> GetAllUser();	
	
	public User QueryUserByNumber(String UserNumber);
	
	public List<User> GetAllUserByPageSize(int row,int PageSize);	
	
	public int CountUser();	
	
	public Object AddMutiplyUser(List<User> user);
	
	public User QueryUserByPhone(String Phone);
}
