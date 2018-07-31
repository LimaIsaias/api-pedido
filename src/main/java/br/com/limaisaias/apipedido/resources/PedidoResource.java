package br.com.limaisaias.apipedido.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.limaisaias.apipedido.domains.Pedido;
import br.com.limaisaias.apipedido.services.PedidoService;

public class PedidoResource {

	@Autowired
	private PedidoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pedido> findById(@PathVariable Integer id) {
		Pedido retorno;
		retorno = service.find(id);
		return ResponseEntity.ok().body(retorno);
	}
}
