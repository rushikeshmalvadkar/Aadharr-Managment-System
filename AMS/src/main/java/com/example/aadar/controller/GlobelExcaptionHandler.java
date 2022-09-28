package com.example.aadar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.aadar.dto.ErrorDto;
import com.example.aadar.excaption.AadharCardNotFoundExcaption;

@ControllerAdvice
public class GlobelExcaptionHandler {
    
	@ExceptionHandler(value= MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDto> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		List<ObjectError> allErrors = ex.getAllErrors();
		List<String> errors = allErrors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
		ErrorDto errorDto = new ErrorDto(errors, HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorDto, HttpStatus.OK);
	}
    
	@ExceptionHandler(AadharCardNotFoundExcaption.class)
	public ResponseEntity<ErrorDto> handleAadharCardNotFountExcaption(AadharCardNotFoundExcaption e){
		String message = e.getMessage();
		List<String> listOfMessage = new ArrayList<>();
		listOfMessage.add(message);
		ErrorDto errorDto = new ErrorDto(listOfMessage,HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorDto, HttpStatus.OK);
	 
		
	}
	
}
