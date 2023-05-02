package com.vsl700.employeemanagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.TestPropertySource;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.vsl700.employeemanagement.data.EmployeeRepository;
import com.vsl700.employeemanagement.data.models.Employee;

@DataMongoTest
@TestPropertySource(locations = "classpath:application-integration-test.properties")
public class EmployeemanagementApplicationDBTests {
    @Test
	void objectSaveTest(@Autowired MongoTemplate mongoTemplate){
		DBObject objectToSave = BasicDBObjectBuilder.start().add("key", "value").get();

		mongoTemplate.save(objectToSave, "testCollection");

		assertThat(mongoTemplate.findAll(DBObject.class, "testCollection")).extracting("key").containsOnly("value");
	}

	@Test
	void objectSaveTest2(@Autowired EmployeeRepository employeeRepo){
		var employee = new Employee("Bob", "Rickman");
		employeeRepo.save(employee);

		assertTrue(employeeRepo.exists(Example.of(employee)));
	}
}
