package com.edu.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.edu.beans.Organisation;
import com.edu.beans.User;
import com.edu.dao.OrgDao;



@RestController
public class OrgOprController {

	@Autowired
	public OrgDao orgDao;

	public List list;

	@PostMapping(path="/edu/createNewOrg" , consumes = "application/json", produces = "application/json")
	public ResponseEntity createNewOrg(@RequestHeader Organisation orgObj) {

		if(orgObj!=null) {
			if(orgDao.createNewOrg(orgObj)) {
				return ResponseEntity.ok("Organisation Created");
			}else {
				return ResponseEntity.ok("Issue In creating organisation, Please try again later");
			}
		}else {
			return ResponseEntity.ok("Org Object is null");
		}


	}

	@GetMapping(path="/edu/getFilteredOrgList")
	public List<Organisation> getFilteredOrganisationList(@RequestHeader Map<String,String> map){
		list= new ArrayList();
		list=orgDao.getFilteredOrgList(map);
		return list;
	}

	@GetMapping(path="/edu/getOrgList")
	public List<Organisation> getOrganisationList(){
		list= new ArrayList();
		list=orgDao.getOrganisationList();
		return list;

	}

	@DeleteMapping(path="/edu/removeOrganisation/{orgRegNumber}")
	public boolean deleteOrg(@PathVariable String orgRegNumber) {
		if(orgRegNumber!=null&&!orgRegNumber.isEmpty()) {

			if(orgDao.deleteOrganisation(orgRegNumber)) {
				return true; // Org Deleted Successfully
			}else
				return false; // issue while deleting the Org, Please Try Again Later


		}else {
			return false;  // orgRegNumber can't be null
		}

	}


}
