package com.csu.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.csu.dao.IntroductionDAO;
import com.csu.model.Introduction;
import com.csu.service.IntroductionService;

@Transactional
public class IntroductionServiceImpl implements IntroductionService{

	private IntroductionDAO Id;

	public IntroductionDAO getId() {
		return Id;
	}

	public void setId(IntroductionDAO id) {
		this.Id = id;
	}

	public void AddIntroduction(Introduction introduction) {
		// TODO Auto-generated method stub
		Id.addIntroduction(introduction);
	}

	public void UpdateIntroduction(Introduction introduction) {
		// TODO Auto-generated method stub
		Id.updateIntroduction(introduction);
	}

	public void DeleteIntroduction(Introduction introduction) {
		// TODO Auto-generated method stub
		Id.deleteIntroduction(introduction);
	}

	public Introduction QueryIntroduction(int id) {
		// TODO Auto-generated method stub
		return Id.queryIntroduction(id);
	}

	public List<Introduction> GetAllIntroduction() {
		// TODO Auto-generated method stub
		return Id.GetAllIntroduction();
	}

	public List<Introduction> GetAllIntroductionByPageSize(int row, int PageSize) {
		// TODO Auto-generated method stub
		return Id.GetAllIntroductionByPageSize(row, PageSize);
	}

	public int CountIntroduction() {
		// TODO Auto-generated method stub
		return Id.CountIntroduction();
	}
	
	
	
}
