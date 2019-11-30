package br.com.projects.main.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ExcecaoRecursoNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ExcecaoRecursoNaoEncontrado(Long id) {
		super("Recurso não encontrado. Id: " + id);		
	}
	

}
