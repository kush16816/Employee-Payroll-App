package com.capgemini.employeepayrollapp.dto;

import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public class Dto {
	
	@NonNull
    @Size(min=2, message="Name should have atleast 2 characters")
	private String name;
	
	private String email;
	
	private int salary;
	
	public String getfname() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
