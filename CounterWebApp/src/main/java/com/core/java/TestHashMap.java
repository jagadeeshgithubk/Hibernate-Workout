package com.core.java;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestHashMap {

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		Map<Student, Integer> hashMap = new HashMap<>();
		hashMap.put(new Student(1,"ram"), 1);
		hashMap.put(new Student(1,"ram"), 2);
		System.out.println(3493712%16+":"+hashMap.size());
		Set<Student> keySet = hashMap.keySet();
		Set<Entry<Student, Integer>> entrySet = hashMap.entrySet();
		
	}
}

class Student {
	private Integer number;
	private String name;

	public Student(Integer number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
	
}
