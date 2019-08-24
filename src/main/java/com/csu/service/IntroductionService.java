package com.csu.service;

import java.util.List;

import com.csu.model.Introduction;

public interface IntroductionService {

	public void AddIntroduction(Introduction introduction);
	
	public void UpdateIntroduction(Introduction introduction);
	
	public void DeleteIntroduction(Introduction introduction);
	
	public Introduction QueryIntroduction(int id);
	
	public List<Introduction> GetAllIntroduction();
	
}
