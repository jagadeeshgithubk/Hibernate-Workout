package hbmpojos;

import java.util.List;
import java.util.Set;

public class Thing {

	private Integer thingId;
	private String thingName;
	private Set<Person> persons;
	

	public Set<Person> getPersons() {
		return persons;
	}
	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
	public Integer getThingId() {
		return thingId;
	}
	public void setThingId(Integer thingId) {
		this.thingId = thingId;
	}
	public String getThingName() {
		return thingName;
	}
	public void setThingName(String thingName) {
		this.thingName = thingName;
	}
	
}
