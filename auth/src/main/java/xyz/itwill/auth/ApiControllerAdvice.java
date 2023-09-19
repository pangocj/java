package xyz.itwill.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {
	@ExceptionHandler(BindException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(BindException ex){
		Map<String, String> errorMap = new HashMap<>();
		for(FieldError error : ex.getBindingResult().getFieldErrors()) {
			errorMap.put(error.getField(), error.getDefaultMessage());
		}
		System.out.println(errorMap);
	    return ResponseEntity.ok(errorMap);
	       
	}
}
