package com.niveus.crud;

import com.niveus.crud.controller.EmployeeController; // Import your controller
import com.niveus.crud.service.EmployeeService; // Import your service
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CrudApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void testEmployeeControllerLoaded() {
		// Verify that the EmployeeController bean is loaded in the application context
		assertThat(applicationContext.getBean(EmployeeController.class)).isNotNull();
	}

	@Test
	void testEmployeeServiceLoaded() {
		// Verify that the EmployeeService bean is loaded in the application context
		assertThat(applicationContext.getBean(EmployeeService.class)).isNotNull();
	}
}
