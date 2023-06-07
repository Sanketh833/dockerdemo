package com.niveus.demo.testservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.niveus.demo.entity.EmployeeEntity;
import com.niveus.demo.repository.EmployeeRepository;
import com.niveus.demo.service.EmployeeService;

@ExtendWith(MockitoExtension.class) 
public class TestService {

	@Mock
	EmployeeRepository repository;

	@InjectMocks
	EmployeeService service;

	private MockMvc mockMvc;

	@Test
	void testcreateEmployeeDetails() {
		EmployeeEntity entity = new EmployeeEntity();

		when(repository.save(entity)).thenReturn(entity);
		assertEquals(entity, service.createEmployeeDetails(entity));

	}

	@Test
	void testsearchEmployeeDetails() {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmpIdentity(100);
		when(repository.findById(100)).thenReturn(Optional.of(entity));
		assertEquals(Optional.of(entity), service.searchEmployeeDetails(100));

	}

	 
}
