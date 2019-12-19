package br.com.projects.main.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.projects.main.entities.Cliente;

public class ClienteDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("cpf")
	private String cpf;

	@JsonProperty("endereco")
	private Set<EnderecoDto> endereco = new HashSet<>();

	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("dataNascimento")
	private LocalDate dataNascimento;

	public ClienteDto() {
	}

	public ClienteDto(Cliente cliente) {
		setNome(cliente.getNome());
		setCpf(cliente.getCpf());
		setEndereco(cliente.getEndereco().stream().map(end -> new EnderecoDto(end)).collect(Collectors.toSet()));
		setDataNascimento(cliente.getDataNascimento());
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
		return endereco;
	}

	public void setEndereco(Set<EnderecoDto> endereco) {
		this.endereco = endereco;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
