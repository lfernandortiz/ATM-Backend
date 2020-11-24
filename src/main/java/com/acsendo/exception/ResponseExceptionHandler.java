package com.acsendo.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NestedRuntimeException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	Logger logger = LoggerFactory.getLogger(ResponseExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> manejarTodasExcepciones(Exception ex, WebRequest request) {
		
		logger.info("Manejador global de excepcion " + ex.getClass());		
		
		ExceptionResponse exceptionResponse = null;
		
		if (ex instanceof DataIntegrityViolationException) {
			 exceptionResponse = new ExceptionResponse(new Date(), ((NestedRuntimeException) ex).getMostSpecificCause().getMessage(),
					request.getDescription(false));
		}else {
			 exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
					request.getDescription(false));
		}
		
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
			
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// ex.getBindingResult().getAllErrors();
		List<ErrorCampoValidacion> errors = new ArrayList<ErrorCampoValidacion>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(new ErrorCampoValidacion(error.getField(), error.getDefaultMessage()));
		}
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validacion Fallida", errors, request.getDescription(false));
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	
}
