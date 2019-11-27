package br.com.projects.main.resources;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projects.main.entities.Cliente;

@RestController
@RequestMapping("/prova/api/clientes")
public class ClienteRecurso {

	@GetMapping
	public ResponseEntity<Cliente> findAll() {
		Cliente c = new Cliente(1, "João", "098.765.432-21", Instant.parse("2019-06-20T19:53:07Z"));
		return ResponseEntity.ok().body(c);

	}

}
