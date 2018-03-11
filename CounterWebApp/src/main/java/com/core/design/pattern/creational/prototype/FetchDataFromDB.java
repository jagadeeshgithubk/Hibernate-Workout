package com.core.design.pattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class FetchDataFromDB implements Cloneable{

	List<EmployeeFromDB> arrayList = new ArrayList<>();
	
	public List<EmployeeFromDB> getArrayList() {
		return arrayList;
	}

	public FetchDataFromDB() {

	}
	
	public void loadDataFromDB(){
		System.out.println("loading from DB..........");
		arrayList.add(new EmployeeFromDB("ram", 123,50000l));
		arrayList.add(new EmployeeFromDB("rahim", 456,40000l));
		arrayList.add(new EmployeeFromDB("ranga", 789,30000l));
		arrayList.add(new EmployeeFromDB("rama", 910,20000l));
		arrayList.add(new EmployeeFromDB("laxmana", 122,10000l));
	}

	@Override
	public String toString() {
		return "FetchDataFromDB [arrayList=" + arrayList + "]";
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		FetchDataFromDB fetchDataFromDB = new FetchDataFromDB();
		fetchDataFromDB.getArrayList().addAll(this.arrayList);
		return fetchDataFromDB;
	}
}
