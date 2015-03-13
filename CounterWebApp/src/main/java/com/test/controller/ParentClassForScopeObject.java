package com.test.controller;

import java.util.List;
import java.util.Set;

public class ParentClassForScopeObject {
	
	private List<ChilldClassForScopeObject> childClassForScopeObject;
	private Set<String> stringValues;
	public List<ChilldClassForScopeObject> getChildClassForScopeObject() {
		return childClassForScopeObject;
	}
	public void setChildClassForScopeObject(
			List<ChilldClassForScopeObject> childClassForScopeObject) {
		this.childClassForScopeObject = childClassForScopeObject;
	}


	public Set<String> getStringValues() {
		return stringValues;
	}

	public void setStringValues(Set<String> stringValues) {
		this.stringValues = stringValues;
	}	
	
	
}
