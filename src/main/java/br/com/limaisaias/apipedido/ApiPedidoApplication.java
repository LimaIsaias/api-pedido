package br.com.limaisaias.apipedido;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.limaisaias.apipedido.domains.Categoria;
import br.com.limaisaias.apipedido.repository.CategoriaRepository;

@SpringBootApplication
public class ApiPedidoApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiPedidoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria categoria1 = new Categoria(null, "Informatica");
		Categoria categoria2 = new Categoria(null, "Escritorio");
		
		repository.saveAll(Arrays.asList(categoria1,categoria2));
	}
}
