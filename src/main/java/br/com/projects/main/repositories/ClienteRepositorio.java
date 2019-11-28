package br.com.projects.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projects.main.entities.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

}
