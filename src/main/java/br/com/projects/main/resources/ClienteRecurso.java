package br.com.projects.main.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.projects.main.dto.ClienteDto;
import br.com.projects.main.entities.Cliente;
import br.com.projects.main.services.ClienteServico;

@RestController
@RequestMapping("/prova/api/clientes")
public class ClienteRecurso {

	@Autowired
	private ClienteServico clienteServico;

	@GetMapping
	public ResponseEntity<List<ClienteDto>> findAll() {
		List<Cliente> lista = clienteServico.findAll();
		List<ClienteDto> listaDto = lista.stream().map(obj -> new ClienteDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente cliente = clienteServico.findById(id);
		return ResponseEntity.ok().body(cliente);
	}

	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody ClienteDto clienteDto) {
		Cliente cliente = new Cliente(clienteDto);
		cliente = clienteServico.insert(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId())
				.toUri();
		return ResponseEntity.created(uri).body(cliente);
		
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clienteServico.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente) {
		cliente = clienteServico.update(id, cliente);
		return ResponseEntity.ok().body(cliente);

	}
}
