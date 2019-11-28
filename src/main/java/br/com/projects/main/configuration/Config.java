package br.com.projects.main.configuration;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.projects.main.entities.Cliente;
import br.com.projects.main.repositories.ClienteRepositorio;

@Configuration
@Profile("test")
public class Config implements CommandLineRunner {

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@Override
	public void run(String... args) throws Exception {

		Cliente cliente1 = new Cliente(null, "Maria", "098.123.465-27", LocalDate.parse("1990-11-28"));
		Cliente cliente2 = new Cliente(null, "João", "098.765.432-21", LocalDate.parse("2000-06-20"));

		clienteRepositorio.saveAll(Arrays.asList(cliente1, cliente2));

	}

}
