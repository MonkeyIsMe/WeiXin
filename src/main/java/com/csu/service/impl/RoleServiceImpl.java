package com.csu.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.csu.dao.RoleDAO;
import com.csu.model.Role;
import com.csu.service.RoleService;

@Transactional
public class RoleServiceImpl implements RoleService{

	private RoleDAO rd;
	
	public RoleDAO getRd() {
		return rd;
	}

	public void setRd(RoleDAO rd) {
		this.rd = rd;
	}

	public void AddRole(Role role) {
		// TODO Auto-generated method stub
		rd.addRole(role);
	}

	public void UpdateRole(Role role) {
		// TODO Auto-generated method stub
		rd.updateRole(role);
	}

	public void DeleteRole(Role role) {
		// TODO Auto-generated method stub
		rd.deleteRole(role);
	}

	public Role QueryRole(int id) {
		// TODO Auto-generated method stub
		return rd.queryRole(id);
	}

	public List<Role> QueryAllRoleByPageSize(int row, int PageSize) {
		// TODO Auto-generated method stub
		return rd.QueryAllRoleByPageSize(row, PageSize);
	}

	public List<Role> QueryAllRole() {
		// TODO Auto-generated method stub
		return rd.QueryAllRole();
	}

	public int CountRole() {
		// TODO Auto-generated method stub
		return rd.CountRole();
	}

}
