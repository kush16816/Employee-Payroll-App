package com.capgemini.employeepayrollapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Employees")
public class Employee {
	
	@Id
	@GeneratedValue(
	   strategy = GenerationType.SEQUENCE,
	   generator = "entity_id_seq"
	)
	@SequenceGenerator(
	   name = "entity_id_seq",
	   sequenceName = "global_id_sequence",
	   allocationSize = 1
	) 
	@Column(
	   name = "id",
	   unique = true,
	   updatable = false,
	   nullable = false
	)
	private Long id;
	private String empName;
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private Long salary;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}

}
