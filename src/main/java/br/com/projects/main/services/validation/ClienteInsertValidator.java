package br.com.projects.main.services.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.projects.main.dto.ClienteDto;
import br.com.projects.main.services.ClienteServico;
import br.com.projects.main.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteDto> {

	@Autowired
	private ClienteServico clienteServico;

	@Override
	public void initialize(ClienteInsert constraintAnnotation) {
	}

	@Override
	public boolean isValid(ClienteDto clienteDto, ConstraintValidatorContext context) {

		/*
		 * Validação do cpf em termos da legitimidade dos números:
		 * BR.isValidCpf(cliente.getCpf()) Validação em relação a não duplicidade de
		 * cpf's no banco: clienteServico.findByCpf(cliente.getCpf()) == null
		 */
		if (BR.isValidCpf(clienteDto.getCpf()) && clienteServico.findByCpf(clienteDto.getCpf()) == null) {
			return true;
		} else {
			return false;
		}

	}

}
