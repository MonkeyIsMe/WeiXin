package com.csu.dao;

import java.util.List;

import com.csu.model.Company;

public interface CompanyDAO {
	
	public void addCompany(Company company);
	
	public void updateCompany(Company company);
	
	public void deleteCompany(Company company);
	
	public Company queryCompany(int id);
	
	public List<Company> QueryAllCompany(int row,int PageSize);
	
}
