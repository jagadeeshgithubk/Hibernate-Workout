package com.test.controller;

import hbmpojos.Employee;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HQLUtil {

	public static void main(String args[]){
        ApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
        SessionFactory sessionFactory = (SessionFactory)context.getBean("mySessionFactory");
        Session openSession = sessionFactory.openSession();
	
//        positionalAndNamedParameter(openSession);
        Query createQuery = openSession.createQuery("update Employee e set e.ADDRESS=\'test\'");
        int executeUpdate = createQuery.executeUpdate();
        System.out.println(executeUpdate);
	}

	private static void positionalAndNamedParameter(Session openSession) {
		Query createQuery = openSession.createQuery("from Employee e where e.ADDRESS=?");
        createQuery.setParameter(0, "manual address");
//        createQuery.setParameter("test1", 6);
        List<Employee> list = createQuery.list();
        for (Employee employee : list) {
			System.out.println(employee.getADDRESS());
		}
	}
	
	
}
