package com.test.dao;

import hbmpojos.Department;
import hbmpojos.Employee;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public class TestDaoImpl extends HibernateDaoSupport implements TestDao
{

	@Override
	public List<Employee> fetchData() {
		List<Employee> executeFind = (List<Employee>)getHibernateTemplate().executeFind(new HibernateCallback<List<Employee>>() {

			@Override
			public List<Employee> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria createCriteria = session.createCriteria(Employee.class);
				return (List<Employee>)createCriteria.list();
			}
		});
		return executeFind;
	}

	@Override
	public void saveOrUpdate() {
		Department entity = new Department();
		entity.setDEPT_NAME("hibernate ado");
		LinkedHashSet<Employee> empList = new LinkedHashSet<Employee>();
		Employee e = new Employee();
		e.setDepartment(entity);
		e.setNAME("test");
		empList.add(e);
		entity.setEmpList(empList);
		getHibernateTemplate().save(entity);
	}

}
