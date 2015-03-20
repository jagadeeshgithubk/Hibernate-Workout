package com.test.controller;

import hbmpojos.Department;
import hbmpojos.Employee;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cascade;
import org.hibernate.classic.Session;
import org.omg.CORBA.INV_FLAG;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMainClass {

	public static void main(String args[]) throws ParseException{
		
        ApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
        ParentClassForScopeObject bean = (ParentClassForScopeObject)context.getBean(ParentClassForScopeObject.class);
        SessionFactory sessionFactory = (SessionFactory)context.getBean("mySessionFactory");
        Session openSession = sessionFactory.openSession();
        openSession.beginTransaction();
        
//		fetching data
//		CRUDutil.fetchDetails(openSession);

//        Save or update
//        CRUDutil.saveOrUpdate(openSession);
        Department department = (Department)openSession.get(Department.class,227);
		Set<Employee> empList = department.getEmpList();
		for (Employee employee : empList) {
			System.out.println(employee);
		}
		
		
        openSession.getTransaction().commit();
        
        
	}

}

