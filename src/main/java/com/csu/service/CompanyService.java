package com.csu.service;

import java.util.List;

import com.csu.model.Company;

public interface CompanyService {
	
	public void AddCompany(Company company);
	
	public void UpdateCompany(Company company);
	
	public void DeleteCompany(Company company);
	
	public Company QueryCompany(int id);
	
	public List<Company> QueryAllCompanyByPageSize(int row,int PageSize);
	
	public int CountCompany();
	
	public List<Company> QueryAllCompany();
}
