package br.com.limaisaias.apipedido.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.limaisaias.apipedido.domains.Categoria;
import br.com.limaisaias.apipedido.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Categoria> retorno = service.findAll();
		return ResponseEntity.ok().body(retorno);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Categoria retorno;
		retorno = service.findByID(id);
		return ResponseEntity.ok().body(retorno);
	}

}
