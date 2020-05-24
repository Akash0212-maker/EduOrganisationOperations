package com.edu.beans;

import org.springframework.data.mongodb.core.mapping.Document;


public class FacultyDetails {

	String facultyName;
	String specSubject;
	String expInSpecSubject;
	String achievements;
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getSpecSubject() {
		return specSubject;
	}
	public void setSpecSubject(String specSubject) {
		this.specSubject = specSubject;
	}
	public String getExpInSpecSubject() {
		return expInSpecSubject;
	}
	public void setExpInSpecSubject(String expInSpecSubject) {
		this.expInSpecSubject = expInSpecSubject;
	}
	public String getAchievements() {
		return achievements;
	}
	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}
	
	
	
	
}
