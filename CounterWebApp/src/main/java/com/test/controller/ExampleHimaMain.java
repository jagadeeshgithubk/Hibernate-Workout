package com.test.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ExampleHimaMain {
	
	public static void main(String[] args) {
		System.out.println("main started here.. ");
     int i = 10;
     if(i == 10 ){
    	 System.out.println("if block :: ");
     }
     
     OverloadingEx ex = new OverloadingEx();
     //ex.m1(null);
     ex.m1(new String("hai "));
     ex.m1("uuuu");
     
     List<Emp> emp = new ArrayList<Emp>();
     emp.add(new Emp(1,"1Name","1Address"));
     emp.add(new Emp(123,"12Name","123Address"));
     emp.add(new Emp(12,"12Name","12Address"));
     emp.add(new Emp(1,"1Name","1Address"));
     Collections.sort(emp);
     System.out.println(" emp :: "+emp);
     
     Set<Emp> empSet = new HashSet<Emp>();
     empSet.add(new Emp(1,"1Name","1Address"));
     empSet.add(new Emp(123,"12Name","123Address"));
     empSet.add(new Emp(12,"12Name","12Address"));
     empSet.add(new Emp(1,"1Name","1Address"));
     //Collections.sort(empSet);
     System.out.println(" empSet :: "+empSet);
     Set<Emp> empTreeSet = new TreeSet<Emp>();
     empTreeSet.add(new Emp(1,"1Name","1Address"));
     empTreeSet.add(new Emp(123,"12Name","123Address"));
     empTreeSet.add(new Emp(12,"12Name","12Address"));
     empTreeSet.add(new Emp(1,"1Name","1Address"));
     System.out.println(" empTreeSet :: "+empTreeSet);
     Set<String> empSet1 = new TreeSet<String>();
     empSet1.add("hai");
     empSet1.add("bai");
     empSet1.add("hh");
     empSet1.add("hai");
    // Set<Emp> empTreeSet = new TreeSet<Emp>();
     System.out.println("empSet1 :; "+empSet1);
     
     Map<String,String> map = new HashMap<>();
     map.put("xyz", "xyzValue");
     map.put("abc", "abcValue");
     map.put("bc", "bcValue");
     map.put("pq", "pqValue");
     List<String> values = new ArrayList<String>( map.keySet());
     Collections.sort(values);
     System.out.println("map : : "+map);
    /* Map<Emp,Emp> mapEmp = new HashMap<>();\map : : {abc=abcValue, pq=pqValue, bc=bcValue, xyz=xyzValue}

     mapEmp.put( new Emp(1,"1Name","1Address"), new Emp(1,"1Name","1Address"));
     mapEmp.put( new Emp(1,"1Name","1Address"), new Emp(1,"1Name","1Address"));
     mapEmp.put( new Emp(1,"1Name","1Address"), new Emp(1,"1Name","1Address"));*/
     
	}

}

class Emp implements Comparable<Emp>{
	int eid;
	String eName;
	String address;
	public Emp(int eid, String eName, String address) {
		this.eid = eid;
		this.eName = eName;
		this.address = address;
		
	}
	
	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", eName=" + eName + ", address=" + address
				+ "]";
	}

	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int compareTo(Emp o) {
		return this.eid - o.eid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((eName == null) ? 0 : eName.hashCode());
		result = prime * result + eid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (eName == null) {
			if (other.eName != null)
				return false;
		} else if (!eName.equals(other.eName))
			return false;
		if (eid != other.eid)
			return false;
		return true;
	}
	
	
	
}

class OverloadingEx {
	
	void m1(Object o){
		System.out.println("m1 String value");
	}
	void m1(String s){
		System.out.println("m1 String value");
	}
	
	
}
