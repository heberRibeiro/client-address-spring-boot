package br.com.projects.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projects.main.entities.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

	@Transactional(readOnly = true)
	Cliente findByCpf(String cpf);
}
