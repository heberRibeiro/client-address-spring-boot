package br.com.projects.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projects.main.entities.Cliente;
import br.com.projects.main.repositories.ClienteRepositorio;
import br.com.projects.main.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteServico {

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	public List<Cliente> findAll() {
		return clienteRepositorio.findAll();
	}

	public Cliente findById(Long id) {
		Optional<Cliente> cliente = clienteRepositorio.findById(id);
		return cliente.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Cliente insert(Cliente cliente) {
		return clienteRepositorio.save(cliente);
	}
	
	public void delete(Long id) {
		clienteRepositorio.deleteById(id);
	}
	
	public Cliente update(Long id, Cliente cliente) {
		Cliente obj = clienteRepositorio.getOne(id);
		update(obj, cliente);
		return clienteRepositorio.save(obj);
	}

	private void update(Cliente obj, Cliente cliente) {
		obj.setNome(cliente.getNome());
		obj.setCpf(cliente.getCpf());
		obj.setDataNascimento(cliente.getDataNascimento());
		obj.setEndereco(cliente.getEndereco());
		
	}
}
