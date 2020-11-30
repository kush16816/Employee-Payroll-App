package com.capgemini.employeepayrollapp.service;

import com.capgemini.employeepayrollapp.dto.Dto;
import com.capgemini.employeepayrollapp.utility.Response;

public interface IEmployee {
	Response addEmployee(Dto empDto);

	Long getById(long id);
}
