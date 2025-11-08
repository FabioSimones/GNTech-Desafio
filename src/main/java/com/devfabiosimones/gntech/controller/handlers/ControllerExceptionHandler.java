package com.devfabiosimones.gntech.controller.handlers;

import com.devfabiosimones.gntech.entity.dto.CustomError;
import com.devfabiosimones.gntech.service.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<CustomError> notFoundException(NotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomError> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.FORBIDDEN;
		CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<CustomError> resourceAlreadyFound(ResourceAlreadyExistsException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<CustomError> badRequest(BadRequestException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}