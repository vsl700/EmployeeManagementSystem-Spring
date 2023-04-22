package com.vsl700.employeemanagement.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vsl700.employeemanagement.data.models.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findByFirstNameAndLastName(String firstName, String lastName);
    List<Employee> findByLastName(String lastName);
}
