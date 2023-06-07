package com.niveus.demo.testcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.niveus.demo.controller.EmployeeController;
import com.niveus.demo.entity.EmployeeEntity;
import com.niveus.demo.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class TestController {

	@Mock
	EmployeeService employeeService;

	@InjectMocks
	EmployeeController employeeController;

	private MockMvc mockMvc;

	@Test
	void testcreateEmployeeDetails() {

		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmpIdentity(100);
		entity.seteName("Sanketh");
		entity.seteSalary("7654567");
		when(employeeService.createEmployeeDetails(entity)).thenReturn(entity);
		assertEquals(entity, employeeController.createEmployeeDetails(entity));
	}

	@Test
	void testsearchEmployeeDetails() {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmpIdentity(100);
		when(employeeService.searchEmployeeDetails(100)).thenReturn(Optional.of(entity));
		assertEquals(Optional.of(entity), employeeController.searchEmployeeDetails(100));

	}


	@Test
	void deleteEmployeeDetails() throws Exception {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmpIdentity(100);
//		
		assertEquals("Deleted Employee Details", employeeController.deleteEmployeeDetails(100));

	}

}
