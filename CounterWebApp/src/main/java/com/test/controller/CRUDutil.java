package com.test.controller;

import hbmpojos.Department;
import hbmpojos.Employee;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;

public class CRUDutil {
	
	public static void fetchDetails(Session openSession) {
		Department department = (Department)openSession.get(Department.class,239);
        System.out.println(department);
        Set<Employee> empList = department.getEmpList();
        for (Employee employee : empList) {
        	employee.setADDRESS(employee.getNAME()+"..aded");
//			System.out.println(employee.getADDRESS());
		}
	}
	


	public static void saveOrUpdate(Session openSession) {
		Department department = (Department)openSession.get(Department.class,256);
//        department.setDEPTID(254);
        department.setDEPT_NAME("test manual insert");
        LinkedHashSet<Employee> empList = new LinkedHashSet<Employee>();
        
        Employee e = new Employee();
//        e.setID(256);
//        e.setDEPT_ID(256);
        e.setADDRESS("manual address");
        e.setNAME("man");
        e.setDepartment(department);
		empList.add(e);
		department.setEmpList(empList);
		openSession.save(department);
		
//		openSession.save(e);
	}

	public static void testEnumMapping(ApplicationContext context,
			ParentClassForScopeObject bean) {
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
