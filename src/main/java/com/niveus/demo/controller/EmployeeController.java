package com.niveus.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niveus.demo.entity.EmployeeEntity;
import com.niveus.demo.service.EmployeeService;

@RestController
@RequestMapping("/emplstatus")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/createemp")
	public EmployeeEntity createEmployeeDetails(@RequestBody EmployeeEntity employeeEntity) {

		return employeeService.createEmployeeDetails(employeeEntity);
	}

	@GetMapping("/findemp/{empIdentity}")
	public Optional<EmployeeEntity> searchEmployeeDetails(@PathVariable("empIdentity") Integer empIdentity) {

		Optional<EmployeeEntity> employeeEntity = employeeService.searchEmployeeDetails(empIdentity);
		return employeeEntity;
	}

	@PutMapping("/updateemp/{empIdentity}")
	public ResponseEntity<EmployeeEntity> updateEmployeeDetails(@PathVariable("empIdentity") Integer empIdentity,
			@RequestBody EmployeeEntity employeeEntity) {

		return new ResponseEntity<EmployeeEntity>(employeeService.updateEmployeeDetails(employeeEntity, empIdentity),
				HttpStatus.OK);
	}

	@DeleteMapping("/deleteemp/{empIdentity}")
	public String deleteEmployeeDetails(@PathVariable("empIdentity") Integer empIdentity) {

		employeeService.deleteEmployeeDetails(empIdentity);
		return "Deleted Employee Details" ;
	}

}
