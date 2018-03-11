package com.core.design.pattern.creational.prototype;
 class EmployeeFromDB {
	private String name;
	private Integer id;
	private Long salary;

	public EmployeeFromDB(String name, Integer id, Long salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public Long getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "EmployeeFromDB [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}

}
