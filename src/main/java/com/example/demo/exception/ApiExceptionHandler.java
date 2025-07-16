package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(InvalidException.class)
	public ResponseEntity<?> handlePaginationError(InvalidException ex, HttpServletRequest request) {
		Map<String, Object> error = new LinkedHashMap<>();
		error.put("timestamp", LocalDateTime.now());
		error.put("status", HttpStatus.BAD_REQUEST.value());
		error.put("error", "Bad Request");
		error.put("message", ex.getMessage());
		error.put("path", request.getRequestURI());
		
		return ResponseEntity.badRequest().body(error);

	}

}
