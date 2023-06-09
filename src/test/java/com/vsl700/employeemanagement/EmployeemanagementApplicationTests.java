package com.vsl700.employeemanagement;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-integration-test.properties")
@AutoConfigureMockMvc
class EmployeemanagementApplicationTests {

	@Test
	void customersPageNoErrors(@Autowired MockMvc mvc) throws Exception {
		//assertTrue(restTemplate.getForEntity("http://localhost:" + port + "/customers", String.class).getStatusCode().is2xxSuccessful());
		mvc.perform(get("/customers/1")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Employee Management System")))
		.andExpect(content().string(containsString("Alice")));
	}

}
