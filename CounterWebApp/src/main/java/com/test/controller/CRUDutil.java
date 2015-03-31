package com.test.controller;

import hbmpojos.Department;
import hbmpojos.Employee;
import hbmpojos.Person;
import hbmpojos.Thing;

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

	public static void manyToMany_Person_To_Things(Session openSession) {
		Person person = new Person();
		person.setName("name1");
		Set<Thing> linkedHashSet = new LinkedHashSet<Thing>();
		Thing thing1 = new Thing();
		thing1.setThingName("shirt");
		Thing thing2 = new Thing();
		thing2.setThingName("shirt");
		linkedHashSet.add(thing1);
		linkedHashSet.add(thing2);
		person.setThings(linkedHashSet);
		openSession.save(person);
	}

	public static void manyToMany_Things_To_Person(Session openSession) {
		Thing thing = new Thing();
		thing.setThingName("shirt");
		Set<Person> linkedHashSet = new LinkedHashSet<Person>();
		Person person1 = new Person();
		person1.setName("name1");
		Person person2 = new Person();
		person2.setName("name2");
		linkedHashSet.add(person1);
		linkedHashSet.add(person2);
		thing.setPersons(linkedHashSet);
		
		openSession.save(thing);
	}

	
	public static void saveOrUpdate(Session openSession) {
		Department department = (Department)openSession.get(Department.class,1);
//		Department department = new Department();

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
