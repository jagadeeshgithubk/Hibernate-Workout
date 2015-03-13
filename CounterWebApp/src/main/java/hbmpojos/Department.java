package hbmpojos;

import java.util.List;
import java.util.Set;

public class Department {
	
	Integer DEPTID;
	Integer DEPT_ID;
	String DEPT_NAME;
	Set<Employee> empList;
	
	public Set<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(Set<Employee> empList) {
		this.empList = empList;
	}
	public Integer getDEPTID() {
		return DEPTID;
	}
	public void setDEPTID(Integer dEPTID) {
		DEPTID = dEPTID;
	}
	public Integer getDEPT_ID() {
		return DEPT_ID;
	}
	public void setDEPT_ID(Integer dEPT_ID) {
		DEPT_ID = dEPT_ID;
	}
	public String getDEPT_NAME() {
		return DEPT_NAME;
	}
	public void setDEPT_NAME(String dEPT_NAME) {
		DEPT_NAME = dEPT_NAME;
	}

}
