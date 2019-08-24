package com.csu.dao;

import java.util.List;

import com.csu.model.Role;

public interface RoleDAO {

	public void addRole(Role role);
	
	public void updateRole(Role role);
	
	public void deleteRole(Role role);
	
	public Role queryRole(int id);
	
	public List<Role> QueryAllRole(int row,int PageSize);
	
}
