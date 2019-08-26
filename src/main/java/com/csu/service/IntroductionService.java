package com.csu.service;

import java.util.List;

import com.csu.model.Introduction;

public interface IntroductionService {

	public void AddIntroduction(Introduction introduction);
	
	public void UpdateIntroduction(Introduction introduction);
	
	public void DeleteIntroduction(Introduction introduction);
	
	public Introduction QueryIntroduction(int id);
	
	public List<Introduction> GetAllIntroduction();
	
	public List<Introduction> GetAllIntroductionByPageSize(int row,int PageSize);
	
	public int CountIntroduction();
	
	public List<Introduction> GetIntroductionByCompany(String company_name);
	
}
