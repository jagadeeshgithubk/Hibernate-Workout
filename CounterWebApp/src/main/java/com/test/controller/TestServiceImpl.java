package com.test.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TestServiceImpl extends JdbcDaoSupport implements TestService{
	
	@Transactional(value="jpaTransactionManager",readOnly=false,rollbackFor=SQLException.class)
	@Override
	public Integer executeQuery(String name) throws SQLException {
		
		
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		
		jdbcTemplate.query("select * from Employee", new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while(rs.next()){
					System.out.println(".............................."+rs.getString(1));
				}
			}
		});
		
		return null;
	}
}
