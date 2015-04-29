package com.test.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class AutowireModes {

	@Autowired
	@Qualifier("testChild3")
	private ChilldClassForScopeObject chilldClassForScopeObject;

	public AutowireModes() {
		// TODO Auto-generated constructor stub
	}
	public AutowireModes(ChilldClassForScopeObject testChild3) {
		chilldClassForScopeObject = testChild3;
	}
	
/*	@Resource
	public void setChilldClassForScopeObject(
			@Qualifier("testChild3") ChilldClassForScopeObject chilldClassForScopeObject) {
		this.chilldClassForScopeObject = chilldClassForScopeObject;
	}
*/

	public ChilldClassForScopeObject getChilldClassForScopeObject() {
		return chilldClassForScopeObject;
	}
	 
}
