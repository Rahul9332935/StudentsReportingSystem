package com.rahul.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException mave){
		
		
		ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(mave.getMessage()); //Validation error
		errorDetails.setDetails(mave.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> noHandlerFoundExceptionHandler(NoHandlerFoundException nhfe, WebRequest wR){
		
		
		ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(nhfe.getMessage());
		errorDetails.setDetails(wR.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
		
	}
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> universalExceptionHandler(Exception e ,WebRequest wR){
		
		ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(e.getMessage());
		errorDetails.setDetails(wR.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(StudentsExceptions.class)
	public ResponseEntity<ErrorDetails> StudentsExceptions(StudentsExceptions ce ,WebRequest wR){
		
        ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(ce.getMessage());
		errorDetails.setDetails(wR.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	
	}
	
	@ExceptionHandler(MarksExceptions.class)
	public ResponseEntity<ErrorDetails> MarksExceptionsHnadler(MarksExceptions ce ,WebRequest wR){
		
        ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(ce.getMessage());
		errorDetails.setDetails(wR.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	
	}
	
	@ExceptionHandler(SemestersExceptions.class)
	public ResponseEntity<ErrorDetails> SemestersExceptionsHnadler(SemestersExceptions ce ,WebRequest wR){
		
        ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(ce.getMessage());
		errorDetails.setDetails(wR.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	
	}
	@ExceptionHandler(SubjectsExceptions.class)
	public ResponseEntity<ErrorDetails> SubjectsExceptionsHnadler(SubjectsExceptions ce ,WebRequest wR){
		
        ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(ce.getMessage());
		errorDetails.setDetails(wR.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	
	}
	
	
	
}
