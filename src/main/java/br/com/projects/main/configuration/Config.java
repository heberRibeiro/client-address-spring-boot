package br.com.projects.main.configuration;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.projects.main.entities.Cliente;
import br.com.projects.main.entities.Endereco;
import br.com.projects.main.repositories.ClienteRepositorio;

@Configuration
@Profile("test")
public class Config implements CommandLineRunner {

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@Override
	public void run(String... args) throws Exception {

		Cliente cliente1 = new Cliente(null, "Maria", "098.123.465-27", null, LocalDate.parse("1990-11-28"));
		Cliente cliente2 = new Cliente(null, "João", "098.765.432-21", null, LocalDate.parse("2000-06-20"));

		clienteRepositorio.saveAll(Arrays.asList(cliente1, cliente2));

		Endereco endereco1 = new Endereco(null, "Rua Algum", 100, "complemento algum", "Bairro A", "Cidade A", "PE",
				"43123-190", cliente1);
		Endereco endereco2 = new Endereco(null, "Rua Qualquer", 200, "complemento qualquer", "Bairro B", "Cidade B",
				"PE", "51987-190", cliente2);

		cliente1.setEndereco(endereco1);
		cliente2.setEndereco(endereco2);

		clienteRepositorio.saveAll(Arrays.asList(cliente1, cliente2));

	}

}
