package com.test.controller;

import hbmpojos.Department;
import hbmpojos.Employee;
import hbmpojos.Person;
import hbmpojos.Thing;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cascade;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.controller.MyAnnotation.WrittenTime;
import com.test.dao.TestDao;

public class SpringMainClass {


	public static void main(String[] args) throws SQLException {
        final ApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
		AutowireModes modes = (AutowireModes)context.getBean("testAutowireModes");
		TestService testService = (TestService)context.getBean("testService");
		Integer executeQuery = testService.executeQuery("1");
		TestDao testDaoJpa = (TestDao)context.getBean("testDaoJpa");
		testDaoJpa.saveOrUpdate();
	}

	@MyAnnotation(writtenTime=WrittenTime.DEFAULT_DATE, valueTtest = "ertew")
	public static void main1(String args[]) throws ParseException{
		Class<?> class1 = SpringMainClass.class;
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
		}
        final ApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
        
       
        ParentClassForScopeObject bean = (ParentClassForScopeObject)context.getBean(ParentClassForScopeObject.class);
        SessionFactory sessionFactory = (SessionFactory)context.getBean("mySessionFactory");
        Session openSession = sessionFactory.openSession();
        
        TestDao testDao = (TestDao)context.getBean("testDao");
//        testDao.saveOrUpdate();
        
        TestDao testDaoJpa = (TestDao)context.getBean("testDaoJpa");
//        List<?> fetchDataJpa = testDaoJpa.fetchData();
        testDao.saveOrUpdate();
        System.out.println(".......");
        
        
        AutowireModes autowireModes = (AutowireModes) context.getBean("testAutowireModes");
        System.out.println(".........."+autowireModes.getChilldClassForScopeObject());
        
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
        newProxyInstance.fetchData();
	}

	
}

