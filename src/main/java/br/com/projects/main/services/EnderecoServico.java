package br.com.projects.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.projects.main.entities.Endereco;
import br.com.projects.main.repositories.EnderecoRepositorio;
import br.com.projects.main.services.exceptions.ResourceNotFoundException;

@Service
public class EnderecoServico {

	@Autowired
	private EnderecoRepositorio enderecoRepositorio;

	public List<Endereco> findAll() {
		return enderecoRepositorio.findAll();
	}

	public Endereco findById(Long id) {
		Optional<Endereco> endereco = enderecoRepositorio.findById(id);
		return endereco.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Endereco insert(Endereco endereco) {
		return enderecoRepositorio.save(endereco);
	}

	public void delete(Long id) {
		try {
			enderecoRepositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public Endereco update(Long id, Endereco endereco) {
		Endereco obj = enderecoRepositorio.getOne(id);
		update(obj, endereco);
		return enderecoRepositorio.save(obj);
	}

	private void update(Endereco obj, Endereco endereco) {
		obj.setLogradouro(endereco.getLogradouro());
		obj.setNumero(endereco.getNumero());
		obj.setComplemento(endereco.getComplemento());
		obj.setBairro(endereco.getBairro());
		obj.setCidade(endereco.getCidade());
		obj.setUf(endereco.getUf());
		obj.setCep(endereco.getCep());
		obj.setCliente(endereco.getCliente());
	}
}
