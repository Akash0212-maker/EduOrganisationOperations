package com.edu.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.edu.beans.Organisation;


public interface OrganisationRepository extends MongoRepository<Organisation, Long> , OrganisationCustomRepository  {

	
}
