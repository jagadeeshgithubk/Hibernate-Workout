package com.test.dao;

import hbmpojos.Department;
import hbmpojos.Employee;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanConstructorResultTransformer;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public class TestDaoImpl extends HibernateDaoSupport implements TestDao
{

	@Override
	public List<?> fetchData() {
		List<?> executeFind = (List<?>)getHibernateTemplate().executeFind(new HibernateCallback<List<?>>() {

			@Override
			public List<?> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria createCriteria = session.createCriteria(Department.class,"dept");
//				Criteria createCriteria = session.createCriteria(Department.class,"dept").createAlias("dept.empList", "empList");
/*				ProjectionList projectionList = Projections.projectionList();
				projectionList.add(Projections.property("dept.DEPTID"));
				projectionList.add(Projections.property("empList.ID"));
				projectionList.add(Projections.property("empList.NAME"));
				createCriteria.setProjection(projectionList);
*/				
//				createCriteria.add(Restrictions.eq("DEPTID", 1));
				return (List<?>) createCriteria.list();
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
