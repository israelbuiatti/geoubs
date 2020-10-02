package com.bionexo.geoubs.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(RegraNegocioException.class)
	public ResponseEntity<ApiError> handleNotFoundException(RegraNegocioException ex) {
		ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ApiError> handleMissingParams(MissingServletRequestParameterException ex) {
	    String name = ex.getParameterName();
	    
	    ApiError error = new ApiError(HttpStatus.BAD_REQUEST.value(), "Parâmmetro " + name + " obrigatório", new Date());
	    
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	

}
