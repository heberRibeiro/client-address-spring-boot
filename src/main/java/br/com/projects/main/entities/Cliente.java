package br.com.projects.main.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.projects.main.dto.ClienteDto;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@Column(unique = true) // O banco de dados garante a não repetição deste campo
	private String cpf;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Set<Endereco> endereco = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	public Cliente() {
	}

	public Cliente(Long id, String nome, String cpf, LocalDate dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	public Cliente(ClienteDto clienteDto) {
		setId(null);
		setNome(clienteDto.getNome());
		setCpf(clienteDto.getCpf());
		setDataNascimento(clienteDto.getDataNascimento());
		setEndereco(clienteDto.getEndereco().stream().map(endDto -> new Endereco(endDto)).collect(Collectors.toSet()));
		for (Endereco end : endereco) {
			end.setCliente(this);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Set<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(Set<Endereco> endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
