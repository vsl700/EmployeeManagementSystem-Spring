package com.vsl700.employeemanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vsl700.employeemanagement.data.EmployeeRepository;
import com.vsl700.employeemanagement.data.models.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	private static final int recordsPerPage = 5;
	
	@Override
	public int getViewPagesAmount() {
		int pages = (int) Math.ceil(employeeRepo.count() / (double) recordsPerPage);
		if(pages == 0)
			return 1;

		return pages;
	}

	@Override
	public List<Employee> getAllEmployees(int page, String sort) {
		List<Employee> employees;
		if(sort.equals("name"))
			employees = employeeRepo.findAll(Sort.by("firstName", "lastName"));
		else employees = employeeRepo.findAll();
		
		return employees.subList((page - 1) * recordsPerPage, Math.min(page * recordsPerPage, employees.size()));
	}

	@Override
	public void save(Employee employee) {
		employeeRepo.save(employee);
	}

	@Override
	public Employee getById(String id){
		return employeeRepo.findById(id).orElseThrow();
	}

	@Override
	public void deleteById(String id) {
		employeeRepo.deleteById(id);
	}

}
