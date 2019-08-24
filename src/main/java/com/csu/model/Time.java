package com.csu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name="tab_time")
public class Time {
	
	@Id
	@Column(name="time_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int TimeId;
	
	@Column(name="time_name")
	private String TimeName;

	public int getTimeId() {
		return TimeId;
	}

	public void setTimeId(int timeId) {
		TimeId = timeId;
	}

	public String getTimeName() {
		return TimeName;
	}

	public void setTimeName(String timeName) {
		TimeName = timeName;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("CompanyId", this.TimeId);
		jo.put("TimeName", this.TimeName);
		return jo;
	}
	
	public String toString() {
		return this.toJSON().toString(); 
	}
	
}
