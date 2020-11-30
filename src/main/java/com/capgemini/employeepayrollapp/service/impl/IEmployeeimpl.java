package com.capgemini.employeepayrollapp.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.employeepayrollapp.dto.Dto;
import com.capgemini.employeepayrollapp.exception.EmpException;
import com.capgemini.employeepayrollapp.model.Employee;
import com.capgemini.employeepayrollapp.repository.EmployeeRepository;
import com.capgemini.employeepayrollapp.service.IEmployee;
import com.capgemini.employeepayrollapp.utility.Response;

@Service
public class IEmployeeimpl implements IEmployee{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired 
	private ModelMapper mapper;

	@Override
	public Response addEmployee(Dto empDto) {
		Employee empExist=employeeRepository.findByEmail(empDto.getEmail());
        if(empExist !=null ){
            throw new EmpException(402,"Record Already Exist");
        }
		
		Employee employee = mapper.map(empDto, Employee.class);
		employeeRepository.save(employee);
		System.out.println("Date Added!");
		return new Response();
	}

	@Override
	public Long getById(long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmpException(400, "ID not Found"));
        return employee.getId();
	}

}
