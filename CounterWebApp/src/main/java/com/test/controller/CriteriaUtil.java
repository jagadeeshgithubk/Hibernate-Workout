package com.test.controller;

import hbmpojos.Employee;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.spel.ast.Projection;

public class CriteriaUtil {

	public static void main(String args[]){
        ApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
        SessionFactory sessionFactory = (SessionFactory)context.getBean("mySessionFactory");
        Session openSession = sessionFactory.openSession();
	
//        positionalAndNamedParameter(openSession);
        Criteria createCriteria = openSession.createCriteria(Employee.class);
        Criteria add = createCriteria.add(Restrictions.like("ADDRESS","test"));
        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("ADDRESS"));
        projectionList.add(Projections.property("department.DEPTID"));
		Criteria setProjection = add.setProjection(projectionList);
        List list = setProjection.list();
        for (Object employee : list) {
        	Object[] arrray = (Object[])employee;
			System.out.println(arrray[0]+":"+arrray[1]);
		}
	}

	
}
