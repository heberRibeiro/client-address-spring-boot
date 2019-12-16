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

import br.com.projects.main.dto.EnderecoDto;
import br.com.projects.main.entities.Endereco;
import br.com.projects.main.services.EnderecoServico;

@RestController
@RequestMapping("/prova/api/enderecos")
public class EnderecoRecurso {

	@Autowired
	private EnderecoServico enderecoServico;

	@GetMapping
	public ResponseEntity<List<EnderecoDto>> findAll() {
		List<Endereco> lista = enderecoServico.findAll();
		List<EnderecoDto> listaDto = lista.stream().map(obj -> new EnderecoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Long id) {
		Endereco endereco = enderecoServico.findById(id);
		return ResponseEntity.ok().body(endereco);
	}

	@PostMapping
	public ResponseEntity<Endereco> insert(Endereco endereco) {
		endereco = enderecoServico.insert(endereco);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(endereco.getId())
				.toUri();
		return ResponseEntity.created(uri).body(endereco);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		enderecoServico.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco endereco) {
		endereco = enderecoServico.update(id, endereco);
		return ResponseEntity.ok().body(endereco);
	}
}
