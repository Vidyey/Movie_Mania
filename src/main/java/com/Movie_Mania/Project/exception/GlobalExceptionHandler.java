package com.Movie_Mania.Project.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;





public class GlobalExceptionHandler {


	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleException(Exception exception) {
		return new ResponseEntity<Object>(new ErrorMessage(HttpStatus.BAD_REQUEST,exception.getMessage()),HttpStatus.BAD_REQUEST);
	}
}
