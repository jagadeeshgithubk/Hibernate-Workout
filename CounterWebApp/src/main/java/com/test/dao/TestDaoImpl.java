package com.test.dao;

import hbmpojos.Department;
import hbmpojos.Employee;

import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TestDaoImpl extends HibernateDaoSupport implements TestDao
{

	@Resource(name="transactionManager")
	PlatformTransactionManager platformTransactionManager;
	
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
//				return (List<?>) createCriteria.list();

				
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Department.class);
				detachedCriteria.add(Restrictions.eq("DEPTID", 1));
				ProjectionList projectionList = Projections.projectionList();
				projectionList.add(Projections.property("DEPTID"));
				detachedCriteria.setProjection(projectionList);

				
				Department entity = new Department();
				entity.setDEPT_NAME("hibernate ado");
				LinkedHashSet<Employee> empList = new LinkedHashSet<Employee>();
				Employee e = new Employee();
				e.setDepartment(entity);
				e.setNAME("test");
				empList.add(e);
				entity.setEmpList(empList);
				session.save(entity);
				if(session!=null){
//					throw new RuntimeException();
				}
				return detachedCriteria.getExecutableCriteria(session).list();
			}
		});
		return executeFind;
	}


//Transactions: 
		
//Declarative: transactions by default uses transaction manager defined in the configuration. 
//	The only conditions is that the defined bean should have the id as 'transactionManager'
//	@Transactional
	
//Programmatic: 
	
//	@Transactional
	@Override
	public void saveOrUpdate() {
		//Sets the transaction attributes.
		TransactionDefinition definition = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
		//Gets the Transaction status which will be used later by commit and rollback methods.
		TransactionStatus transaction = platformTransactionManager.getTransaction(definition);
		try{
			Department entity = new Department();
			entity.setDEPT_NAME("hibernate ado");
			LinkedHashSet<Employee> empList = new LinkedHashSet<Employee>();
			Employee e = new Employee();
			e.setDepartment(entity);
			e.setNAME("test");
			
			empList.add(e);
			entity.setEmpList(empList);
			getHibernateTemplate().save(entity);
			if(1<1)
				throw new RuntimeException();
			else{
				platformTransactionManager.commit(transaction);
			}
				
		}
		catch(Exception e){
			System.out.println("caught it");
			platformTransactionManager.rollback(transaction);
//			throw new RuntimeException();
			
		}
	}

}
