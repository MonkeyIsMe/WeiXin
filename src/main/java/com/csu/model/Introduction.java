package com.csu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name="tab_introduction")
public class Introduction {
	
	@Id
	@Column(name="introduction_info")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IntroductionId;
	
	@Column(name="introduction_id")
	private String IntroductionInfo;
	
	@Column(name="introducetion_time")
	private String IntroductionTime;
	
	@Column(name="introduction_tittle")
	private String IntroductionTittle;
	
	@Column(name="company_name")
	private String CompanyName;

	public int getIntroductionId() {
		return IntroductionId;
	}

	public void setIntroductionId(int introductionId) {
		IntroductionId = introductionId;
	}

	public String getIntroductionInfo() {
		return IntroductionInfo;
	}

	public void setIntroductionInfo(String introductionInfo) {
		IntroductionInfo = introductionInfo;
	}

	public String getIntroductionTime() {
		return IntroductionTime;
	}

	public void setIntroductionTime(String introductionTime) {
		IntroductionTime = introductionTime;
	}

	public String getIntroductionTittle() {
		return IntroductionTittle;
	}

	public void setIntroductionTittle(String introductionTittle) {
		IntroductionTittle = introductionTittle;
	}
	
	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("IntroductionId", this.IntroductionId);
		jo.put("IntroductionInfo", this.IntroductionInfo);
		jo.put("IntroductionTime", this.IntroductionTime);
		jo.put("IntroductionTittle", this.IntroductionTittle);
		jo.put("CompanyName", this.CompanyName);
		return jo;
	}
	
	public String toString() {
		return this.toJSON().toString(); 
	} 
	
}
