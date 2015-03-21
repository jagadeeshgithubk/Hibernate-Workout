package com.test.controller;

import hbmpojos.Person;
import hbmpojos.Thing;

import java.text.ParseException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cascade;
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

        for(int i=0;i<1;i++){
        	CRUDutil.saveOrUpdate(openSession);
        }
        
        Person person = new Person();
        person.setName("test1");
        Set<Thing> linkedHashSet = new LinkedHashSet<Thing>();
        Thing thing1 = new Thing();
        thing1.setThingName("thing1");
        Thing thing2 = new Thing();
        thing2.setThingName("thing2");
        linkedHashSet.add(thing1);
        linkedHashSet.add(thing2);
		person.setThings(linkedHashSet);

		openSession.save(person);
//        CRUDutil.saveOrUpdate(openSession);
        Department department = (Department)openSession.get(Department.class,227);
		Set<Employee> empList = department.getEmpList();
		for (Employee employee : empList) {
			System.out.println(employee);
		}
		
		
        openSession.getTransaction().commit();
        
        
	}

}

