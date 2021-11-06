package com.mindex.challenge.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindex.challenge.dao.EmployeeRepository;

public class ReportingStructure {

	
	//Define fields
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private Employee employee;
	private int numberOfReports;
	
	//Define constructors
	public ReportingStructure() {
			
	}

	public ReportingStructure(EmployeeRepository employeeRepository, Employee employee) {
		this.employeeRepository = employeeRepository;
		this.employee = employee;
		this.numberOfReports = totalReports(employee);
	}
	
	//Calculate no. of reports for an employee
	public int totalReports(Employee employee) {
		List<Employee> employeeList = employee.getDirectReports();
		int countReports = 0;
		if(employeeList != null) {
			countReports += employeeList.size();
			
			for(Employee current : employeeList) {
				Employee currentEmployeeReports = employeeRepository.findByEmployeeId(current.getEmployeeId());
				
				countReports += totalReports(currentEmployeeReports);
			}
		}
		return countReports;
	}

	//Add Setters and Getters
	
	public Employee getEmployee() {
		return employee;
	}

	public int getNumberOfReports() {
		return numberOfReports;
	}

	/**
	 * public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setNumberOfReports(int numberOfReports) {
		this.numberOfReports = numberOfReports;
	}
	*/
	
	//Define toString() method
	@Override
	public String toString() {
		return "ReportingStructure [employee=" + employee + ", numberOfReports=" + numberOfReports + "]";
	}
	
}
