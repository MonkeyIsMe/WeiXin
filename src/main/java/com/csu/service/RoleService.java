package com.csu.service;

import java.util.List;

import com.csu.model.Role;

public interface RoleService {

	public void AddRole(Role role);
	
	public void UpdateRole(Role role);
	
	public void DeleteRole(Role role);
	
	public Role QueryRole(int id);
	
	public List<Role> QueryAllRoleByPageSize(int row,int PageSize);
	
	public List<Role> QueryAllRole();
	
	public int CountRole();
}
