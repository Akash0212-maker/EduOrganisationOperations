package com.edu.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ExecutableUpdateOperation.ExecutableUpdate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.edu.beans.Organisation;
import com.edu.dao.OrganisationCustomRepository;
import com.edu.dao.OrganisationRepository;
import com.mongodb.client.result.UpdateResult;

@Repository
public class OrganisationDaoImpl implements OrganisationCustomRepository  {

	@Autowired
	MongoTemplate template;

	@Override
	public boolean createNewOrg(Organisation org) {
		Organisation returnOrg=template.insert(org);

		if(returnOrg!=null)
			return true;
		else 
			return false;
	}


	@Override
	public List<Organisation> getOrganisationList() {
		List<Organisation> list;
		list=template.findAll(Organisation.class);
		if(list!=null)
			return list;
		else
			return list;
	}

	@Override
	public boolean deleteOrganisation(String orgRegNumber) {	
		Query query = new Query();
		query.addCriteria(Criteria.where("orgRegNumber").is(orgRegNumber));
		Organisation organisation=template.findAndRemove(query, Organisation.class);
		System.out.println("Deleted Organisation"+organisation);

		if(organisation!=null)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateOrganisation(String orgRegNumber,Map<String,String> jsonString) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("orgRegNumber").is(orgRegNumber));
		Update update = new Update();
		
		if(jsonString!=null) {
			for(Entry<String, String> entry:jsonString.entrySet()) {
				update.set(entry.getKey(), entry.getValue());
	
			}
		}
		
		UpdateResult updateResult=template.updateFirst(query, update, Organisation.class);
		
		if(updateResult.wasAcknowledged()) {
			return true;
		}else
			return false;
	}


}
