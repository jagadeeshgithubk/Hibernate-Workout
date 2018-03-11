package com.core.design.pattern.creational.prototype;

import ch.qos.logback.core.net.SyslogOutputStream;

public class PrototypeCaller {

	public static void main(String[] args) throws CloneNotSupportedException {
		FetchDataFromDB fetchDataFromDB = new FetchDataFromDB();
		fetchDataFromDB.loadDataFromDB();
		
		System.out.println("Before clone...\n"+fetchDataFromDB.getArrayList());
		FetchDataFromDB clonedData = (FetchDataFromDB)fetchDataFromDB.clone();
		System.out.println("Removing an emloyee at location 1..."+fetchDataFromDB.getArrayList().remove(1));
		System.out.println("After removing from original list...\n"+fetchDataFromDB.getArrayList());

		System.out.println("After clone...\n"+clonedData.getArrayList());
	}
}
