package com.test.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {
	
	@Before(value="execution(public * com.test.controller.TestService.*(..))")
	public void display(JoinPoint joinPoint){
		System.out.println(".........before advice.....");
	}
	
	
}
