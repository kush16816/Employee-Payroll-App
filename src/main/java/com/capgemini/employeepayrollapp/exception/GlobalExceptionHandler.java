package com.capgemini.employeepayrollapp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.employeepayrollapp.utility.Response;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    
	@ExceptionHandler(EmpException.class)
    public final ResponseEntity<Response> empException(EmpException e) {

        Response status=new Response(400,e.getMessage());
        return new ResponseEntity<Response>(status,HttpStatus.OK);
    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }
}
