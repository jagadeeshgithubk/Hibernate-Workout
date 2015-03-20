package hbmpojos;

import java.util.List;
import java.util.Set;

public class Person {
	
	private Integer personId;
	private String name;
	private Set<Thing> things;
	
	
	public Set<Thing> getThings() {
		return things;
	}
	public void setThings(Set<Thing> things) {
		this.things = things;
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
