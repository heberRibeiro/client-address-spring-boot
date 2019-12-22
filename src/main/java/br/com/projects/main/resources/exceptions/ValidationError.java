package br.com.projects.main.resources.exceptions;

import java.time.Instant;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> listErrors;// = new ArrayList<>();

	public ValidationError() {
	}

	public ValidationError(Instant timestamp, Integer status, String error, String message, String path,
			List<FieldMessage> listErrors) {
		super(timestamp, status, error, message, path);
		this.listErrors = listErrors;
	}

	public List<FieldMessage> getListErrors() {
		return listErrors;
	}
}
