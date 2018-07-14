package br.com.limaisaias.apipedido;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.limaisaias.apipedido.domains.Categoria;
import br.com.limaisaias.apipedido.domains.Produto;
import br.com.limaisaias.apipedido.repository.CategoriaRepository;
import br.com.limaisaias.apipedido.repository.ProdutoRepository;

/**
 * @author LimaI
 ***/
@SpringBootApplication
public class ApiPedidoApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(final String[] args) {
		SpringApplication.run(ApiPedidoApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {

		final Produto produto1 = new Produto(null, "Computador", 2000.00);
		final Produto produto2 = new Produto(null, "Impressora", 1000.00);
		final Produto produto3 = new Produto(null, "Mouse", 10.00);
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

		final Categoria categoria1 = new Categoria(null, "Informatica");
		final Categoria categoria2 = new Categoria(null, "Escritorio");
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().add(produto2);
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
	}
}
