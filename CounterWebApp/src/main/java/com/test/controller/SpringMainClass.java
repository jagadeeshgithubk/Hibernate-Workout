package com.test.controller;

import hbmpojos.Person;
import hbmpojos.Thing;

import java.text.ParseException;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
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

//        CRUDutil.manyToMany_Things_To_Person(openSession);
        CRUDutil.manyToMany_Person_To_Things(openSession);
        
               openSession.getTransaction().commit();
        
        
	}
	

}

