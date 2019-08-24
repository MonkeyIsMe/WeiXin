package com.csu.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.csu.dao.CompanyDAO;
import com.csu.model.Company;
import com.csu.service.CompanyService;

@Transactional
public class CompanyServiceImpl implements CompanyService{

	private CompanyDAO cd;
	
	public CompanyDAO getCd() {
		return cd;
	}

	public void setCd(CompanyDAO cd) {
		this.cd = cd;
	}

	public void AddCompany(Company company) {
		// TODO Auto-generated method stub
		cd.addCompany(company);
	}

	public void UpdateCompany(Company company) {
		// TODO Auto-generated method stub
		cd.updateCompany(company);
	}

	public void DeleteCompany(Company company) {
		// TODO Auto-generated method stub
		cd.deleteCompany(company);
	}

	public Company QueryCompany(int id) {
		// TODO Auto-generated method stub
		return cd.queryCompany(id);
	}

	public List<Company> QueryAllCompany(int row, int PageSize) {
		// TODO Auto-generated method stub
		return cd.QueryAllCompany(row, PageSize);
	}

}
