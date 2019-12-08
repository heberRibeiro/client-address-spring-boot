package br.com.projects.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projects.main.entities.Endereco;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {

}
