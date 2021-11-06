package com.mindex.challenge.data;

public class Compensation {

	//Define fields
	private Employee employee;
	private int salary;
	private String effectiveDate;
	
	//Define constructors
	public Compensation() {
		
	}

	public Compensation(Employee employee, int salary, String effectiveDate) {
		this.employee = employee;
		this.salary = salary;
		this.effectiveDate = effectiveDate;
	}

	//Define Setters and Getters
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public int getSalary() {
		return salary;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	//Define toString() 
	@Override
	public String toString() {
		return "Compensation [employee=" + employee + ", salary=" + salary + ", effectiveDate=" + effectiveDate + "]";
	}
	
	
}
