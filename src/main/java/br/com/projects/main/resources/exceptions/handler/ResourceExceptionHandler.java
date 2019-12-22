package br.com.projects.main.resources.exceptions.handler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import br.com.projects.main.resources.exceptions.FieldMessage;
import br.com.projects.main.resources.exceptions.StandardError;
import br.com.projects.main.resources.exceptions.ValidationError;
import br.com.projects.main.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException ex, HttpServletRequest req) {
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = ex.getMessage();
		String path = req.getRequestURI();
		StandardError err = new StandardError(Instant.now(), status.value(), error, message, path);
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> argumentNotValid(MethodArgumentNotValidException ex, HttpServletRequest req) {
		String error = "Violação de restrição de campo";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String message = "Erro de validação de campo na inserção de cliente."; //ex.getMessage();
		String path = req.getRequestURI();
		
		List<FieldMessage> listErrors = new ArrayList<>();
		for (FieldError erro : ex.getBindingResult().getFieldErrors()) {
			FieldMessage fieldMessage = new FieldMessage(erro.getField(),erro.getDefaultMessage());
			listErrors.add(fieldMessage);					
		}
		ValidationError err = new ValidationError(Instant.now(), status.value(), error, message, path, listErrors);
		return ResponseEntity.status(status).body(err);
	}

}
