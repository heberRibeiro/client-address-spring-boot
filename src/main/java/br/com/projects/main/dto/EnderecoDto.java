package br.com.projects.main.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.projects.main.entities.Endereco;

public class EnderecoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("logradouro")
	private String logradouro;

	@JsonProperty("numero")
	private Integer numero;

	@JsonProperty("complemento")
	private String complemento;

	@JsonProperty("bairro")
	private String bairro;

	@JsonProperty("cidade")
	private String cidade;

	@JsonProperty("uf")
	private String uf;

	@JsonProperty("cep")
	private String cep;

	public EnderecoDto() {
	}

	public EnderecoDto(Endereco endereco) {
		setLogradouro(endereco.getLogradouro());
		setNumero(endereco.getNumero());
		setComplemento(endereco.getComplemento());
		setBairro(endereco.getBairro());
		setCidade(endereco.getCidade());
		setUf(endereco.getUf());
		setCep(endereco.getCep());
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
