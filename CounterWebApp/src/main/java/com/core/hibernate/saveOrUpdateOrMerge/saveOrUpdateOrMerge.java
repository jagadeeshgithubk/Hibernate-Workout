package com.core.hibernate.saveOrUpdateOrMerge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hbmpojos.Department;
import hbmpojos.Employee;

import org.aspectj.internal.lang.annotation.ajcDeclareParents;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.interview.questions.A;



public class saveOrUpdateOrMerge {
	public static void main(String[] args) {
		System.out.println("main started here :: ");
		final ApplicationContext context = new ClassPathXmlApplicationContext(
				"mvc-dispatcher-servlet.xml");
		
		
		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("mySessionFactory");
		Session openSession = sessionFactory.openSession();
		/*
		 * Department dept = (Department)openSession.get(Department.class, 1);
		 * System.out.println("Department :; "+ dept.getDEPTID() );
		 */

		Employee emp = new Employee();
		emp.setNAME("merge emp, no identifier set, dept 6 update");
		// emp.setID(25);
		Employee emp1 = new Employee();
		// emp1.setID(25);
		emp1.setNAME("merge emp1, no identifier set, dept 6 update");
		Set<Employee> lstEmp = new HashSet<>();
		lstEmp.add(emp1);
		lstEmp.add(emp);
		Department department = new Department();
		department.setDEPT_NAME("departNameOf100");
		department.setEmpList(lstEmp);
//		department.setDEPTID(6);
		
		// DOC: Gets the new identifier(doesn't matter if it is already set
		// also) and creates a new object in the db, though there is an
		// identifier is for the object
//		Serializable save = openSession.save(department);
		Object object = openSession.get(Department.class, 2);
		Department department1 = (Department)object;
		openSession.evict(department1);
		department1.setDEPT_NAME("changed"+(int)((Math.random()*10)+(Math.random()*10)));
		openSession.saveOrUpdate(department1);
		// DOC: Save or update, if you set the identfier, then it updates that
		// object or else, creates new object in the db
		// openSession.saveOrUpdate(department);

		// DOC: Persist, you cannot set any identifier to this
		// openSession.persist(department);

		// DOC: merge, works exactly as like saveOrUpdate, except it returns
		// saved object
//		 openSession.merge(department);

		// DOC: update, 
/*		Object load = openSession.load(Department.class, 68);
		System.out.println(load);
*///		openSession.update(department);

		// System.out.println(save);
		System.out.println("Second time loading");
//		openSession.get(Department.class, 1);
		System.out.println(department1.getDEPT_NAME());
		System.out.println("firing employee data");
		Hibernate.initialize(department1.getEmpList());
		openSession.close();
		System.out.println("before updating");
		Set<Employee> empList = department1.getEmpList();
		System.out.println(new ArrayList<>(empList).get(0).getNAME());
//		 openSession.flush();
		 
		A bean = context.getBean(A.class);
		System.out.println();

		
	}

}
