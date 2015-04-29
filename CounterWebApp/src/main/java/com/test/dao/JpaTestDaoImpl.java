package com.test.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jpa.entities.Dept;

public class JpaTestDaoImpl implements TestDao
{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<?> fetchData() {
		Dept find = manager.find(Dept.class, 1);
		List<Dept> arrayList = new ArrayList<Dept>();
		arrayList.add(find);
		return arrayList;
	}

	@Override
	public void saveOrUpdate() {
		
	}

}
