package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScopeObject1 {

	@Autowired
	private ScopeObject scopeObject;
	
	public ScopeObject1() {
		
	}
	
	public ScopeObject geScopeObject(){
		return scopeObject; 
	}
	
}
