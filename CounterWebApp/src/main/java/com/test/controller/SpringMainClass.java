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
        
        
/*        Department department = (Department)openSession.get(Department.class,239);
        System.out.println(department);
        Set<Employee> empList = department.getEmpList();
        for (Employee employee : empList) {
        	employee.setADDRESS(employee.getNAME()+"..aded");
//			System.out.println(employee.getADDRESS());
		}
        
        openSession.save(department);
*/        
        
        Department department = new Department();
//        department.setDEPTID(301);
        department.setDEPT_NAME("test manual insert");
        LinkedHashSet<Employee> empList = new LinkedHashSet<Employee>();
        
        Employee e = new Employee();
//        e.setID(123);
        e.setADDRESS("manual address");
        e.setNAME("man");
		empList.add(e);
		department.setEmpList(empList);
		
		openSession.save(department);
//		openSession.save(e);
        openSession.getTransaction().commit();
        
        TestEnumInjector bean2 = (TestEnumInjector)context.getBean("testInjection");
        
//        System.out.println(bean2);
        Map<TestEnum, String> testEnum = bean2.getTestEnum();
        for (TestEnum string : testEnum.keySet()) {
//        	System.out.println("name:........"+string.getClass());
		}
//        System.out.println("....."+testEnum.getClass());
        
/*        for (String string : bean.getStringValues()) {
			System.out.println(string);
		}
*/        
        List<ChilldClassForScopeObject> childClassForScopeObject = bean.getChildClassForScopeObject();
        for (ChilldClassForScopeObject chilldClassForScopeObject : childClassForScopeObject) {
//			System.out.println(chilldClassForScopeObject.getLastName1());
		}
//        System.out.println(context);
        
	}
	
}

