package com.test.dao;

import hbmpojos.Employee;

import java.util.List;

public interface TestDao {

	List<Employee> fetchData();
	void saveOrUpdate();
}
