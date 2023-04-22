package com.vsl700.employeemanagement.services;

import java.util.List;

import com.vsl700.employeemanagement.data.models.Employee;

public interface EmployeeService {

	int getViewPagesAmount();
	List<Employee> getAllEmployees(int page, String sort);
	void save(Employee employee);
	Employee getById(String id);
	void deleteById(String id);
	
}
