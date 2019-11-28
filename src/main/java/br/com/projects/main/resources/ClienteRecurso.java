package br.com.projects.main.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projects.main.entities.Cliente;
import br.com.projects.main.services.ClienteServico;

@RestController
@RequestMapping("/prova/api/clientes")
public class ClienteRecurso {

	@Autowired
	private ClienteServico clienteServico;

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> lista = clienteServico.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
		Cliente cliente = clienteServico.findById(id);
		return ResponseEntity.ok().body(cliente);
	}
}
