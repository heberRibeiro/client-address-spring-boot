package br.com.projects.main.services.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.projects.main.entities.Cliente;
import br.com.projects.main.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, Cliente> {

	@Override
	public void initialize(ClienteInsert constraintAnnotation) {
	}

	@Override
	public boolean isValid(Cliente cliente, ConstraintValidatorContext context) {

		if (BR.isValidCpf(cliente.getCpf())) {
			return true;
		} else {
			return false;
		}
	}

}
