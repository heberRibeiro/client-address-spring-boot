package br.com.projects.main.resources;

import java.time.LocalDate;

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
		Cliente c = new Cliente(1, "João", "098.765.432-21", LocalDate.parse("2000-06-20"));
		return ResponseEntity.ok().body(c);

	}
}
