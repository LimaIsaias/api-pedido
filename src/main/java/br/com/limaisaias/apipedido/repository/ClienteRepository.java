package br.com.limaisaias.apipedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.limaisaias.apipedido.domains.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Transactional(readOnly = true)
	public Cliente findByEmail(String email);
}
