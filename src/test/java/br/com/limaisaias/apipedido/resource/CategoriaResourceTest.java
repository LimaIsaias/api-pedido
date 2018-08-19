package br.com.limaisaias.apipedido.resource;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import br.com.limaisaias.apipedido.ApiPedidoApplicationTests;


public class CategoriaResourceTest extends ApiPedidoApplicationTests {

	@Test
	public void deve_procurar_todos() throws IOException {
//		String response = restTemplate.getForObject(BASE_PATH + "/findAll", String.class);
//		List<Categoria> categorias = MAPPER.readValue(response,
//				MAPPER.getTypeFactory().constructCollectionType(List.class, Categoria.class));
//		Assert.assertNotNull(categorias);
        given().get("/categorias/").then().log().body().and().statusCode(HttpStatus.OK.value());

	}
}
