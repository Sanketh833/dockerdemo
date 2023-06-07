package com.niveus.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeeEntity {

	@Id
	private int empIdentity;
	private String eName;
	private String eSalary;

	public int getEmpIdentity() {
		return empIdentity;
	}

	public void setEmpIdentity(int empIdentity) {
		this.empIdentity = empIdentity;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteSalary() {
		return eSalary;
	}

	public void seteSalary(String eSalary) {
		this.eSalary = eSalary;
	}

	public EmployeeEntity(int emp_identity, String eName, String eSalary) {
		super();
		this.empIdentity = empIdentity;
		this.eName = eName;
		this.eSalary = eSalary;
	}

	public EmployeeEntity() {
		super();
	}

}
