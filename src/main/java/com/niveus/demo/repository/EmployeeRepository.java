package com.niveus.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.niveus.demo.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

	@Query(value = "SELECT * FROM employeedb.employee_entity WHERE emp_identity =?1", nativeQuery = true)
	public EmployeeEntity getEmployeeDetailsById(Integer empIdentity);
}
