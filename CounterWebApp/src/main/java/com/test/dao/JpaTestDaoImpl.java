package com.test.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.jpa.entities.Dept;

public class JpaTestDaoImpl implements TestDao
{

	@PersistenceContext
	private EntityManager manager;
	
	@Resource(name="jpaTransactionManager")
	PlatformTransactionManager platformTransactionManager;

	@Override
	public List<?> fetchData() {
		Dept find = manager.find(Dept.class, 1);
		List<Dept> arrayList = new ArrayList<Dept>();
		arrayList.add(find);
		return arrayList;
	}

	@Override
//	@Transactional
	public void saveOrUpdate() {
		TransactionDefinition definition = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
		//Gets the Transaction status which will be used later by commit and rollback methods.
		TransactionStatus transaction = platformTransactionManager.getTransaction(definition);

		Dept find = manager.find(Dept.class, 1);
		find.setName("1");
		manager.merge(find);
		platformTransactionManager.commit(transaction);

	}

}
