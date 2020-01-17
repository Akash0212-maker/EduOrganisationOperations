package com.edu.config;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.mysql.cj.jdbc.Driver;


public class EduOrgDataSource {

	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Value("${spring.datasource.username}")
	private String dbUser;
	@Value("${spring.datasource.pwd}")
	private String dbPwd;
	
	
	
	@Bean("springDataSource")
	public SimpleDriverDataSource dataSource() {
		Driver driver=null;
		try {
			driver =  new com.mysql.cj.jdbc.Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			System.out.println("Connection Problem : "+e.getMessage());
			e.printStackTrace();
		}
		return new SimpleDriverDataSource(driver,dbUrl,dbUser,dbPwd);
	}
	
}
