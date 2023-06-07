package com.niveus.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niveus.demo.entity.EmployeeEntity;
import com.niveus.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

//	post all employee details to DB

	public EmployeeEntity createEmployeeDetails(EmployeeEntity employeeEntity) {

		return employeeRepository.save(employeeEntity);
	}

//	Get the employee details by ID
	public Optional<EmployeeEntity> searchEmployeeDetails(Integer empIdentity) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(empIdentity);
	}

	public EmployeeEntity updateEmployeeDetails(EmployeeEntity employeeEntity, Integer empIdentity) {
		EmployeeEntity empEn = employeeRepository.getEmployeeDetailsById(empIdentity);
		empEn.seteName(employeeEntity.geteName());
		empEn.seteSalary(employeeEntity.geteSalary());
		employeeRepository.save(empEn);

		return empEn;
	}

	public void deleteEmployeeDetails(Integer empIdentity) {
		employeeRepository.deleteById(empIdentity);

	}

}
