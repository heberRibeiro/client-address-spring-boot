package br.com.projects.main.resources.exceptions.handler;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.projects.main.resources.exceptions.StandardError;
import br.com.projects.main.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException ex, HttpServletRequest req) {
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = ex.getMessage();
		String path = req.getRequestURI();
		StandardError err = new StandardError(Instant.now(), status.value(), error, message, path);
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<StandardError> constraintViolation(ConstraintViolationException ex, HttpServletRequest req) {
		String error = "Violação de restrição de campo";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		String message = ex.getMessage();
		String path = req.getRequestURI();
		StandardError err = new StandardError(Instant.now(), status.value(), error, message, path);
		return ResponseEntity.status(status).body(err); 
	}

}
