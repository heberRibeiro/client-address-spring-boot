package br.com.projects.main.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.projects.main.entities.Cliente;

public class ClienteDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String cpf;
	private Set<EnderecoDto> enderecoDto = new HashSet<>();
	private LocalDate dataNascimento;

	public ClienteDto() {
	}

	public ClienteDto(Cliente cliente) {
		nome = cliente.getNome();
		cpf = cliente.getCpf();
		enderecoDto = cliente.getEndereco().stream().map(obj -> new EnderecoDto(obj)).collect(Collectors.toSet());
		dataNascimento = cliente.getDataNascimento();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Set<EnderecoDto> getEndereco() {
		return enderecoDto;
	}

	public void setEndereco(Set<EnderecoDto> enderecoDto) {
		this.enderecoDto = enderecoDto;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
