package com.masai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import java.time.LocalDateTime;
import javax.security.auth.login.LoginException;

@ControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(LoginException.class)
	 public ResponseEntity<MyErrorDetails> loginExceptionHandler(LoginException le, WebRequest req) {
		 MyErrorDetails err = new MyErrorDetails();
	  
	  err.setTimestamp(LocalDateTime.now());
	  err.setMessage(le.getMessage());
	  err.setDetails(req.getDescription(false));
	  
	  return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	 }
	 
	 
	 @ExceptionHandler(CustomerException.class)
	 public ResponseEntity<MyErrorDetails> customerExceptionHandler(CustomerException ce, WebRequest req) {
		 MyErrorDetails err = new MyErrorDetails();
	  
	  err.setTimestamp(LocalDateTime.now());
	  err.setMessage(ce.getMessage());
	  err.setDetails(req.getDescription(false));
	  
	  return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	 }
	 
	 @ExceptionHandler(AdminException.class)
	 public ResponseEntity<MyErrorDetails> adminExceptionHandler(AdminException ae, WebRequest req) {
		 MyErrorDetails err = new MyErrorDetails();
	  
	  err.setTimestamp(LocalDateTime.now());
	  err.setMessage(ae.getMessage());
	  err.setDetails(req.getDescription(false));
	  
	  return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	 }
	 
	 @ExceptionHandler(CabException.class)
	 public ResponseEntity<MyErrorDetails> cabExceptionHandler(CabException ce, WebRequest req) {
		 MyErrorDetails err = new MyErrorDetails();
	  
	  err.setTimestamp(LocalDateTime.now());
	  err.setMessage(ce.getMessage());
	  err.setDetails(req.getDescription(false));
	  
	  return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	 }
	 
	 
	 
	 @ExceptionHandler(TripBookingException.class)
	 public ResponseEntity<MyErrorDetails> tripBookingExceptionHandler(TripBookingException le, WebRequest req) {
		 MyErrorDetails err = new MyErrorDetails();
	  
	  err.setTimestamp(LocalDateTime.now());
	  err.setMessage(le.getMessage());
	  err.setDetails(req.getDescription(false));
	  
	  return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	 }
	 
	 
	 // No handler found exception
	 
	 @ExceptionHandler(NoHandlerFoundException.class)
	 public ResponseEntity<MyErrorDetails> notFoundExceptionHandler(NoHandlerFoundException nfe, WebRequest req ){ 
		 MyErrorDetails err = new MyErrorDetails();
	   
	  err.setTimestamp(LocalDateTime.now());
	  err.setMessage(nfe.getMessage());
	  err.setDetails(req.getDescription(false));
	   
	  return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	 }
	  
	 //wrong uri exception
	  
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	 public ResponseEntity<MyErrorDetails> MANVExceptionHandler(MethodArgumentNotValidException me) {
		 MyErrorDetails err = new MyErrorDetails();
	   
	  err.setTimestamp(LocalDateTime.now());
	  err.setMessage("Validation Error");
	  err.setDetails(me.getBindingResult().getFieldError().getDefaultMessage());
	   
	  return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	 }
	  
	 //for other exception
	  
	 @ExceptionHandler(Exception.class) 
	 public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception e, WebRequest req) { 
		 MyErrorDetails err = new MyErrorDetails();
	   
	  err.setTimestamp(LocalDateTime.now());
	  err.setMessage(e.getMessage());
	  err.setDetails(req.getDescription(false));
	   
	  return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	 }
}
