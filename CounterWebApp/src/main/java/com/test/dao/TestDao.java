package com.test.dao;

import hbmpojos.Department;
import hbmpojos.Employee;

import java.util.List;

public interface TestDao {

	List<?> fetchData();
	void saveOrUpdate();
}
