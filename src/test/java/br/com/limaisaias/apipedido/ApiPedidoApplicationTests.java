package br.com.limaisaias.apipedido;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public abstract class ApiPedidoApplicationTests {

	protected ObjectMapper MAPPER = new ObjectMapper();

	@Value("${local.server.port}")
	protected int porta;

	@Before
	public void setUp() throws Exception {
		RestAssured.port = porta;
	}

}
