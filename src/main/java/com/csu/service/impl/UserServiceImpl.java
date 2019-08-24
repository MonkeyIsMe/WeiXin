package com.csu.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.csu.dao.UserDAO;
import com.csu.model.User;
import com.csu.service.UserService;

@Transactional
public class UserServiceImpl implements UserService{

	private UserDAO ud;

	public UserDAO getUd() {
		return ud;
	}

	public void setUd(UserDAO ud) {
		this.ud = ud;
	}

	public void AddUser(User user) {
		// TODO Auto-generated method stub
		ud.addUser(user);
	}

	public void UpdateUser(User user) {
		// TODO Auto-generated method stub
		ud.updateUser(user);
	}

	public void DeleteUser(User user) {
		// TODO Auto-generated method stub
		ud.deleteUser(user);
	}

	public User QueryUser(int id) {
		// TODO Auto-generated method stub
		return ud.queryUser(id);
	}

	public List<User> GetAllUser() {
		// TODO Auto-generated method stub
		return ud.GetAllUser();
	}

	public User QueryUserByNumber(String UserNumber) {
		// TODO Auto-generated method stub
		
		User user = null;
		List<User> UserList = ud.QueryUserByNumber(UserNumber);
		user = UserList.get(0);
		return user;
	}
	
	
	
}
