package com.csu.dao;

import java.util.List;

import com.csu.model.Introduction;

public interface IntroductionDAO {
	
	public void addIntroduction(Introduction introduction);
	
	public void updateIntroduction(Introduction introduction);
	
	public void deleteIntroduction(Introduction introduction);
	
	public Introduction queryIntroduction(int id);
	
	public List<Introduction> GetAllIntroduction();
	
	public List<Introduction> GetAllIntroductionByPageSize(int row,int PageSize);
	
	public int CountIntroduction();
}
