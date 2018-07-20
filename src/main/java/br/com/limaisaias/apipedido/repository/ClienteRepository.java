package br.com.limaisaias.apipedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.limaisaias.apipedido.domains.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
