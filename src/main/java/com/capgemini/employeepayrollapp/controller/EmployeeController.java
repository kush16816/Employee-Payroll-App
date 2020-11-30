package com.capgemini.employeepayrollapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.employeepayrollapp.dto.Dto;
import com.capgemini.employeepayrollapp.service.IEmployee;
import com.capgemini.employeepayrollapp.utility.Response;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {
	
	@Autowired
	private IEmployee iEmployee;
	
	@PostMapping()
	public Response addEmployee(@RequestBody Dto employee) {
		iEmployee.addEmployee(employee);
		Response response = new Response(200, "Employee added succesfully");
		return response;
	}
	
	@RequestMapping(value = {"", "/", "/get"})
	public ResponseEntity<String> getEmployeePayrollData(){
		return new ResponseEntity<String>("Get Call Succes of id: ", HttpStatus.OK);
	}
	
	@PutMapping(value = "/{name}")
    public String update(@PathVariable(value = "name") String name,@RequestParam(value = "lname") String lname){
        System.out.println("UserName"+name+"LastName"+lname);
        return name+" =="+lname;
    }

    @GetMapping(value = "/getData/{id}")
    public Long getByID(@PathVariable(value = "id") long id){
        return iEmployee.getById(id);
    }
	

}
