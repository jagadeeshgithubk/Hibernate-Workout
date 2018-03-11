package com.test.controller;

import java.util.Collections;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {
	
	@Before(value="execution(public * com.test.controller.TestService.*(..))")
	public void display(JoinPoint joinPoint){
		System.out.println(".........before advice.....");
	}

	@Around(value="execution(public * com.test.controller.TestService.*(..))")
	public void displayAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("around");
		Object proceed = joinPoint.proceed();
		System.out.println("after around");
		System.out.println(proceed);
	}
	
	@AfterReturning(pointcut="execution(public * com.test.controller.TestService.*(..))",returning="test")
	public void displayAfterReturning(JoinPoint joinPoint, Integer test){
		System.out.println("after return");
		System.out.println(".........."+test);
	}
}
