package br.com.projects.main.resources.exceptions.handler;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.projects.main.resources.exceptions.ErroPadrao;
import br.com.projects.main.services.exceptions.ExcecaoRecursoNaoEncontrado;

@ControllerAdvice
@RestController
public class ManipuladorExcecoesRecurso extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ExcecaoRecursoNaoEncontrado.class)
	public ResponseEntity<ErroPadrao> recuroNaoEncontrado(ExcecaoRecursoNaoEncontrado ex, HttpServletRequest req) {
		String error = "Recurso não encontrado"; 
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = ex.getMessage();
		String path = req.getRequestURI();
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), error, message, path);
		return ResponseEntity.status(status).body(err);
	}

}
