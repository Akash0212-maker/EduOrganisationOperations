package com.edu.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.edu.beans.CustomeFilterBean;
import com.edu.beans.Organisation;
import com.edu.beans.User;
import com.edu.dao.OrgDao;

public class OrgDaoImpl extends  JdbcDaoSupport implements OrgDao  {



	@Override
	public boolean createNewOrg(Organisation org) {
		String sql= "insert into Organisation() values()";
		KeyHolder key = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				final PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				/*ps.setLong(3, 0);
				ps.setString(4, request.getBatchFileName());
				ps.setLong(5, request.getBatchFileSize());
				ps.setLong(6, request.getSplitCount());
				ps.setLong(7, request.getTotalDocumentCount());
				ps.setLong(8, request.getSuccessfulDocumentCount());
				ps.setLong(9, request.getExceptionDocumentCount());
				ps.setString(10, request.getStatus());
				ps.setString(11, request.getHostname());*/
				return ps;
			}
		}, key);

		if(key.getKey().intValue()>0) 
			return true;
		else
			return false;
	}

	@Override
	public List<Organisation> getFilteredOrgList(Map<String,String> paramMap) {
		// TODO Auto-generated method stub
		List<Organisation> list;
		String sql;
		sql = "select * from Organisation where";
		Object[] obj=new Object[paramMap.size()];
		if(paramMap.containsKey("city")) {
			sql=sql+"\t"+"city=?";
			obj[0]=paramMap.get("city");
		}if(paramMap.containsKey("org_name")) {
			sql=sql+"\t"+"org_name=?";
			obj[1]=paramMap.get("org_name");
		}if(paramMap.containsKey("subject")) {
			sql=sql+"\t"+"sub=?";
			obj[2]=paramMap.get("subject");
		}
		list=getJdbcTemplate().query(sql,obj, new BeanPropertyRowMapper(Organisation.class));
		return list;

	}

	@Override
	public List<Organisation> getOrganisationList() {
		List<Organisation> list;
		String sql="";
		sql = "select * from Organisation";
		list=getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Organisation.class));
		return list;
	}

	@Override
	public boolean deleteOrganisation(String orgRegNumber) {
		// TODO Auto-generated method stub
		String sql="delete * from organisation where org_reg_num=?";
		KeyHolder key = new GeneratedKeyHolder();
		getJdbcTemplate().update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				final PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, orgRegNumber);
				return ps;
			}
		} , key);

		if(key.getKey().intValue()>0) {
			return true;
		}else
			return false;

	}

	@Override
	public boolean updateOrganisation(String orgRegNumber) {
		// TODO Auto-generated method stub
		return false;
	}

}
