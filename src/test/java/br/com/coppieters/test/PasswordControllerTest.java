package br.com.coppieters.test;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PasswordControllerTest {

	private static final String PASSWORD_SCORE_URL = "/password/score?pass=teste";
	@Autowired
	private TestRestTemplate rest;

	@Test
	public void retornarComplexidadeEmInglesCorretamente() {
		String complexidade = retornarComplexidade("en");
		assertEquals("Very Weak", complexidade);
	}
	@Test
	public void retornarComplexidadeEmPortuguesCorretamente() {
		String complexidade = retornarComplexidade("pt_BR");
		assertEquals("Muito Fraca", complexidade);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String retornarComplexidade(String locale){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept-Language",locale);
		ResponseEntity<Map> entity = rest.exchange(PASSWORD_SCORE_URL, HttpMethod.GET, new HttpEntity<>(headers), Map.class);
		Map<String, String> resposta = (Map<String, String>)entity.getBody();
		return resposta.get("complexity");
	}
}
