package com.test.controller;

import hbmpojos.Department;
import hbmpojos.Employee;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.interview.questions.A;
import com.test.controller.MyAnnotation.WrittenTime;

public class SpringMainClass {

	
	public static void main_current(String[] args) {

		final ApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
		SessionFactory sessionFactory = (SessionFactory)context.getBean("mySessionFactory");
	
		Session openSession = sessionFactory.openSession();
		Department object = (Department)openSession.get(Department.class, 1);
		System.out.println(object);
		List<Department> list = new ArrayList<>();
		openSession.close();
		Set<Employee> empList = object.getEmpList();
		System.out.println(empList.size());
		for (Employee employee : empList) {
			System.out.println(employee.getNAME());
		}
	}
	
	
	public static void main(String args[]){
		
		final ApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
		A a = context.getBean(A.class);
		System.out.println("....."+a.getB());
		SessionFactory sessionFactory = (SessionFactory)context.getBean("mySessionFactory");
		Session openSession = sessionFactory.openSession();
//		Transaction beginTransaction = openSession.beginTransaction();
        Department dept = new Department();
        dept.setDEPT_NAME("deptname");
        Set<Employee> linkedHashSet = new LinkedHashSet<>();
        Employee employee = new Employee();
        employee.setID(50);
        employee.setADDRESS("address");
        employee.setNAME("dept");
        linkedHashSet.add(employee);
		dept.setEmpList(linkedHashSet);
		employee.setDepartment(dept);
		openSession.save(dept);
		openSession.flush();
		/*Department object = (Department)openSession.get(Department.class, 49);
//		object.setDEPT_NAME("new department");
		System.out.println("........"+object.getDEPTID());
//		System.out.println(object.getEmpList().size());
		System.out.println(object.getEmpList().size());
		
		Department deptNew = new Department();
		deptNew.setDEPTID(49);
		deptNew.setDEPT_NAME("name"+new Date());
//		deptNew.setDEPT_NAME("new department");
		openSession.merge(deptNew); 
//		beginTransaction.commit();
		openSession.flush();*/
//		openSession.close();
/*		Session openSession1=sessionFactory.openSession();
		Transaction beginTransaction2 = openSession1.beginTransaction();
*/		
//		object.setDEPT_NAME("dfsdftest");
//		openSession1.update(object);
//		sessionFactory.close();
//		beginTransaction.commit();
	}
	
	public static void main3(String[] args) throws SQLException {
		
		String test1 = new String("RAM");
		String test2 = "RAM";
		String test3 = new String("RAM");
		String test90 = test2+"test";
//		String concat = test2.concat("test");
		System.out.println(1%3);
		
        final ApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
        System.setProperty("spring.profiles.active", "test");
        
        String property = context.getEnvironment().getProperty("spring.profiles.active");
        System.out.println("............"+property);
		AutowireModes modes = (AutowireModes)context.getBean("testAutowireModes");
		System.out.println("....find me now....."+modes.getChilldClassForScopeObject().getLastName1());
		
/*		TestService testService = (TestService)context.getBean("testService");
		Integer executeQuery = testService.executeQuery("1");
		System.out.println(executeQuery);
*//*		TestDao testDaoJpa = (TestDao)context.getBean("testDaoJpa");
		testDaoJpa.saveOrUpdate();
*/	}

	@MyAnnotation(writtenTime=WrittenTime.DEFAULT_DATE, valueTtest = "ertew")
	public static void main1(String args[]) throws ParseException{
	/*	Class<?> class1 = SpringMainClass.class;
		Method[] methods = class1.getMethods();
		for (Method method : methods) {
			boolean annotationPresent = method.isAnnotationPresent(MyAnnotation.class);
			if(annotationPresent){
				Annotation[] annotations = method.getAnnotations();
				for (Annotation annotation : annotations) {
					if(annotation instanceof MyAnnotation){
						System.out.println("dfsd............");
					}
				}
				
			}
				
			System.out.println("....."+annotationPresent);
		}*/
        final ApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
       
        ParentClassForScopeObject bean = (ParentClassForScopeObject)context.getBean(ParentClassForScopeObject.class);
        SessionFactory sessionFactory = (SessionFactory)context.getBean("mySessionFactory");
        Session openSession = sessionFactory.openSession();
        Department load = (Department)openSession.get(Department.class, 1);
//        load.setDEPT_NAME("43ddfd");
        Department department = new Department();
        department.setDEPTID(1);
        openSession.save(department);
        openSession.flush();
//        System.out.println(save);
//        System.out.println(load);
       
/*        Department object = (Department)openSession.get(Department.class, 1);
        openSession.close();
*///        Department nergeDep = new Department();
//        object.setDEPT_NAME("***.. updated...."+new Date());
        /*Session openSession2 = sessionFactory.openSession();
//        Department object4 = (Department)openSession2.get(Department.class, 1);
        Department object2 = new Department();
        object2.setDEPTID(1);
//        Department object3 = new Department();
//        object2.setDEPTID(909);
        object2.setDEPT_NAME("***.. updated...."+new Date());
		openSession2.merge(object2);
        openSession2.flush();
        openSession2.close();*/
/*        TestDao testDao = (TestDao)context.getBean("testDao");
//        testDao.saveOrUpdate();
        r
        TestDao testDaoJpa = (TestDao)context.getBean("testDaoJpa");
//        List<?> fetchDataJpa = testDaoJpa.fetchData();
        testDao.saveOrUpdate();
        System.out.println(".......");
        
        
        AutowireModes autowireModes = (AutowireModes) context.getBean("testAutowireModes");
        System.out.println(".........."+autowireModes.getChilldClassForScopeObject());
*/        
/*        Department directSessionObj = (Department)openSession.get(Department.class, 1);
        List<Department> fetchData = Arrays.asList(directSessionObj);
        System.out.println();
*/        
/*        List<?> fetchData = testDao.fetchData();
        System.out.println(fetchData.size());
*/        
/*        for (Object object : fetchData) {
        	Department dept = (Department)object;
        	Set<Employee> empList = dept.getEmpList();
        	System.out.println(empList);
			System.out.println(object);
		}
*/
        
        
//                testDao.saveOrUpdate();
 /*       openSession.beginTransaction();
        
//		fetching data
//		CRUDutil.fetchDetails(openSession);

//        Save or update

        for(int i=0;i<5;i++){
        	CRUDutil.saveOrUpdate(openSession);
        }
        
        Person person = new Person();
        person.setName("test11");
        Set<Thing> linkedHashSet = new LinkedHashSet<Thing>();
        Thing thing1 = new Thing();
        thing1.setThingName("thing1");
        Thing thing2 = new Thing();
        thing2.setThingName("thing22");
        linkedHashSet.add(thing1);
        linkedHashSet.add(thing2);
		person.setThings(linkedHashSet);

//		openSession.save(null);
//        CRUDutil.saveOrUpdate(openSession);
        Department department = (Department)openSession.get(Department.class,227);
		Set<Employee> empList = department.getEmpList();
		for (Employee employee : empList) {
			System.out.println(employee);
		}
        openSession.getTransaction().commit();*/
        /*
        TestDao newProxyInstance = (TestDao)Proxy.newProxyInstance(TestDao.class.getClassLoader(), new Class[]{TestDao.class}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				TestDao testDaoJpa = (TestDao)context.getBean("testDaoJpa");
				System.out.println("....Invoked before.....");
				method.invoke(testDaoJpa, args);
				System.out.println("....Invoked After.....");
				return null;
			}
		});
        newProxyInstance.fetchData();*/
	}

	
}

