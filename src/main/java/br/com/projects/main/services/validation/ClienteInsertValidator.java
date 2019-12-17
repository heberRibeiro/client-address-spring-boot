package br.com.projects.main.services.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.projects.main.entities.Cliente;
import br.com.projects.main.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, Cliente> {

	@Autowired
	//private ClienteRepositorio clienteRepositorio;

	@Override
	public void initialize(ClienteInsert constraintAnnotation) {
	}

	@Override
	public boolean isValid(Cliente cliente, ConstraintValidatorContext context) {

		// Retorna nulo, caso o cliente a ser inserido não esteja no banco. (cpf não conste no banco)
		//Cliente cli = clienteRepositorio.findByCpf(cliente.getCpf());  

		/*
		 * Validação do cpf em termos da legitimidade dos números "BR.isValidCpf(cliente.getCpf())"
		 * e em relação a não duplicidade "cli == null"
		 */
		if (BR.isValidCpf(cliente.getCpf())) {
			return true;
		} else {
			return false;
		}
	}

}
