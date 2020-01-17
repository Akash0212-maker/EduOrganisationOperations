package com.edu.dao;

import java.util.List;
import java.util.Map;

import com.edu.beans.CustomeFilterBean;
import com.edu.beans.Organisation;
import com.edu.beans.User;

public interface OrgDao {

	public boolean createNewOrg(Organisation org);
	public List<Organisation> getOrganisationList();
	public List<Organisation> getFilteredOrgList(Map<String,String> map);
	public boolean deleteOrganisation(String orgRegNumber);
	public boolean updateOrganisation(String orgRegNumber);
}
