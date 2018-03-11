package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AutowireModes {
	
	

//	@Autowired
//	@Resource(name="testChild3")
//	@Qualifier("testChild3")
	private ChilldClassForScopeObject testChild3;

	/*public AutowireModes() {
		// TODO Auto-generated constructor stub
	}*/
	
	/*public AutowireModes(@Qualifier("testChild4") ChilldClassForScopeObject testChild33) {
		chilldClassForScopeObject = testChild33;
	}*/
	
/*	@Resource
	public void setChilldClassForScopeObject(
			@Qualifier("testChild3") ChilldClassForScopeObject chilldClassForScopeObject) {
		this.chilldClassForScopeObject = chilldClassForScopeObject;
	}
*/

	public void setTestChild3(ChilldClassForScopeObject child){
		testChild3 = child;
		
	}
	
	public ChilldClassForScopeObject getChilldClassForScopeObject() {
		return testChild3;
	}
	 
}
