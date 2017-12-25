package com.test.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

public class ChilldClassForScopeObject implements InitializingBean,DisposableBean,ApplicationContextAware {
	
	private String lastName1;
	private String lastName2;
	private String lastName3;
	private ApplicationContext applicationContext;
	
	public String getLastName1() {
		return lastName1;
	}
	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}
	public String getLastName2() {
		return lastName2;
	}
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}
	public String getLastName3() {
		return lastName3;
	}
	public void setLastName3(String lastName3) {
		this.lastName3 = lastName3;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(".....After properties set.....");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println(".....destroy.........");
	}

	public void springInit(){
		System.out.println("....spring init....");
	}
	
	public void springDestroy(){
		System.out.println(".....spring destroy....");
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
}


