package com.financialorgratingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.financialorgratingsystem.exception.NotFoundException;
import com.financialorgratingsystem.exception.OrganizationIdNotFoundException;
import com.financialorgratingsystem.exception.UserNotFoundException;

@ControllerAdvice
public class ExceptionHandlers {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> handleNotFoundException(NotFoundException notFoundException){
		return new ResponseEntity<>("Id not found, please look into it",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleNotFoundException(UserNotFoundException userNotFoundException) {
	return new ResponseEntity<>(userNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(OrganizationIdNotFoundException.class)
	public ResponseEntity<String> handleOrganizationIdNotFoundException(OrganizationIdNotFoundException organizationNotFound){
	return new ResponseEntity<>(" Organization not found!",HttpStatus.BAD_REQUEST);
	}
		}

