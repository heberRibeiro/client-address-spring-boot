package br.com.projects.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projects.main.entities.Cliente;
import br.com.projects.main.repositories.ClienteRepositorio;

@Service
public class ClienteServico {

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	public List<Cliente> findAll() {
		return clienteRepositorio.findAll();
	}

	public Cliente findById(Integer id) {
		Optional<Cliente> cliente = clienteRepositorio.findById(id);
		return cliente.get();
	}

}
