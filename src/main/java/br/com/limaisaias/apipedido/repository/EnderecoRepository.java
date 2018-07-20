package br.com.limaisaias.apipedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.limaisaias.apipedido.domains.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
