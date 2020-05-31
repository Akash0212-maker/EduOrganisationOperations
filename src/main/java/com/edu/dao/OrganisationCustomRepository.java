package com.edu.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.repository.Query;

import com.edu.beans.Organisation;

public interface OrganisationCustomRepository {
	public boolean createNewOrg(Organisation org);
	public List<Organisation> getOrganisationList();

	/* public List<Organisation> getFilteredOrgList(Map<String,String> map); */
	@Query("{orgRegNumber:'?0'}")
	public boolean deleteOrganisation(String orgRegNumber);
	@Query("{orgRegNumber:'?0'}")
	public boolean updateOrganisation(String orgRegNumber,Map<String,String> jsonString);
}
