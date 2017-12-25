package com.test.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLException;

public class SerializationTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
	
		String fileLocation = "f:\\test.txt";
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileLocation));
		Child child = new Child("test");
		child.setAddress("test");
		child.setPhone("123");
		child.setName("parent");
		objectOutputStream.writeObject(child);
		objectOutputStream.close();
		try(ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(fileLocation))){
			Child readObject = (Child)objInput.readObject();
			System.out.println(readObject.getAddress()+":"+readObject.getPhone()+":"+readObject.getName());
		}
		catch(Exception e ){
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("I am Okay");
		
	}
	
}


class Parent{
	String name;
	public Parent() {
		// TODO Auto-generated constructor stub
	}
	protected Parent(String anotherParentName){
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class Child extends Parent implements Serializable{
	String address;
	String phone;
	public Child(String anotherProperty){
		super("test");
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}