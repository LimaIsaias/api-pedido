package br.com.limaisaias.apipedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.limaisaias.apipedido.domains.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
