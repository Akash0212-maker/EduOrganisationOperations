package com.edu.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class OrgBatch {

	int batchID;
	String course;
	String batchDetails;
	Date batchStartDate;
	Date batchEndDate;
	int seatsAvailable;
	@Autowired
	Organisation orgID;
	public int getBatchID() {
		return batchID;
	}
	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getBatchDetails() {
		return batchDetails;
	}
	public void setBatchDetails(String batchDetails) {
		this.batchDetails = batchDetails;
	}
	public Date getBatchStartDate() {
		return batchStartDate;
	}
	public void setBatchStartDate(Date batchStartDate) {
		this.batchStartDate = batchStartDate;
	}
	public Date getBatchEndDate() {
		return batchEndDate;
	}
	public void setBatchEndDate(Date batchEndDate) {
		this.batchEndDate = batchEndDate;
	}
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	public Organisation getOrgID() {
		return orgID;
	}
	public void setOrgID(Organisation orgID) {
		this.orgID = orgID;
	}
	
	
	
	
}
