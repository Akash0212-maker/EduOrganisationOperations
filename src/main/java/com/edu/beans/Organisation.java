package com.edu.beans;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class Organisation {

	String orgName;
	String orgRegNumber;
	Date estabDate;
	String orgOwnerName;
	String orgEmail;
	int orgContactNumber;
	@Autowired
	Advertisement addver;
	@Autowired 
	DocRegistration regDocument;
	@Autowired 
	Address addr;
	@Autowired	
	List<OrgBatch> batch;
	@Autowired
	List<FacultyDetails> facultyDetails;
	
	
	public long getOrgID() {
		return orgID;
	}
	public void setOrgID(long orgID) {
		this.orgID = orgID;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgRegNumber() {
		return orgRegNumber;
	}
	public void setOrgRegNumber(String orgRegNumber) {
		this.orgRegNumber = orgRegNumber;
	}
	public Date getEstabDate() {
		return estabDate;
	}
	public void setEstabDate(Date estabDate) {
		this.estabDate = estabDate;
	}
	public String getOrgOwnerName() {
		return orgOwnerName;
	}
	public void setOrgOwnerName(String orgOwnerName) {
		this.orgOwnerName = orgOwnerName;
	}
	public String getOrgEmail() {
		return orgEmail;
	}
	public void setOrgEmail(String orgEmail) {
		this.orgEmail = orgEmail;
	}
	public int getOrgContactNumber() {
		return orgContactNumber;
	}
	public void setOrgContactNumber(int orgContactNumber) {
		this.orgContactNumber = orgContactNumber;
	}
	public Advertisement getAddver() {
		return addver;
	}
	public void setAddver(Advertisement addver) {
		this.addver = addver;
	}
	public DocRegistration getRegDocument() {
		return regDocument;
	}
	public void setRegDocument(DocRegistration regDocument) {
		this.regDocument = regDocument;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public List<OrgBatch> getBatch() {
		return batch;
	}
	public void setBatch(List<OrgBatch> batch) {
		this.batch = batch;
	}
	public List<FacultyDetails> getFacultyDetails() {
		return facultyDetails;
	}
	public void setFacultyDetails(List<FacultyDetails> facultyDetails) {
		this.facultyDetails = facultyDetails;
	}


}
