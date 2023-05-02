package com.vsl700.employeemanagement;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import com.vsl700.employeemanagement.data.EmployeeRepository;
import com.vsl700.employeemanagement.data.models.Employee;

@DataMongoTest
@TestPropertySource(locations = "classpath:application-integration-test.properties")
public class EmployeemanagementApplicationDBTestsMock {
    
    @MockBean
    private EmployeeRepository employeeRepo;

    @BeforeEach
    void setUp(){
        var employee = new Employee("Jason", "Born");

        Mockito.when(employeeRepo.findByFirstNameAndLastName("Jason", "Born")).thenReturn(employee);
    }

    @Test
    void objectSaveMockTest(){
        var employee = employeeRepo.findByFirstNameAndLastName("Jason", "Born");

        assertNotNull(employee);
    }

}
