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
	
/*	@Autowired
	PlatformTransactionManager transactionManager;
*/	
	@Transactional(readOnly=false,rollbackFor=SQLException.class,isolation=Isolation.READ_COMMITTED)
	@Override
	public Integer executeQuery(String name) throws SQLException {
		
		
//		DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition(DefaultTransactionDefinition.PROPAGATION_REQUIRES_NEW);
		
/*		TransactionStatus transaction = transactionManager.getTransaction(
				defaultTransactionDefinition);
*/		
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		
		jdbcTemplate.query("select * from Employee", new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while(rs.next()){
					System.out.println(".............................."+rs.getString(1));
				}
			}
		});
		
		int update = jdbcTemplate.update("insert into Employee values("+Integer.parseInt(name)+",'ap2','test90')");
		System.out.println("updated........."+update);

		
//		jdbcTemplate.update("insert into Employee values("+Integer.parseInt(name)+",'ap2','test90')");

		SQLException exception = new SQLException();
		 try {
			 if(true){
				 throw exception;
			 }
//			 transactionManager.commit(transaction);
			 
		} catch (SQLException e) {
			throw e;
		}
		return null;
	}
}
