package br.com.coppieters.test.facade;

import java.util.function.Function;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.coppieters.facade.DecrementalScoreFacade;

public class DecrementalScoreFacadeTest {
	private String senhaForte = "[Aqt3912]";
	private DecrementalScoreFacade facade;

	@Before
	public void init(){
		facade = new DecrementalScoreFacade();
	}
//////////////////	
	@Test
	public void senhaComApenasLetras(){
		Function<String, Integer> function = facade.getLettersOnly();
		int valor = function.apply("senha");
		Assert.assertEquals(5, valor);
	}
	
	@Test
	public void senhaComLetrasEOutrasCoisas(){
		Function<String, Integer> function = facade.getLettersOnly();
		int valor = function.apply(senhaForte);
		Assert.assertEquals(0, valor);
	}
//////////////////
	@Test
	public void senhaComNumeros(){
		Function<String, Integer> function = facade.getNumbersOnly();
		int valor = function.apply("14367");
		Assert.assertEquals(5, valor);
	}
	
	@Test
	public void senhaComNumerosEOutrasCoisas(){
		Function<String, Integer> function = facade.getNumbersOnly();
		int valor = function.apply(senhaForte);
		Assert.assertEquals(0, valor);
	}
////////////////
	@Test
	public void temLetrasMaisculasConsecutivas(){
		Function<String, Integer> function = facade.getConsecutiveUppercaseLetters();
		String senha = "SEnha";
		int valor = function.apply(senha);
		Assert.assertEquals( 2, valor);
	}
	@Test
	public void naoTemLetrasMaisculasConsecutivas(){
		Function<String, Integer> function = facade.getConsecutiveUppercaseLetters();
		String senha = "SeNhA";
		int valor = function.apply(senha);
		Assert.assertEquals( 0, valor);
	}
////////////////
	@Test
	public void temLetrasMinusculasConsecutivas(){
		Function<String, Integer> function = facade.getConsecutiveLowercaseLetters();
		String senha = "aaaaaaaaaaaaaa";
		int valor = function.apply(senha);
		Assert.assertEquals( 26, valor);
	}
	@Test
	public void naoTemLetrasMinusculasConsecutivas(){
		Function<String, Integer> function = facade.getConsecutiveLowercaseLetters();
		String senha = "SeNhA";
		int valor = function.apply(senha);
		Assert.assertEquals( 0, valor);
	}
////////////////
	@Test
	public void temNumerosConsecutivas(){
		Function<String, Integer> function = facade.getConsecutiveNumbers();
		String senha = "SEnha123";
		int valor = function.apply(senha);
		Assert.assertEquals( 4, valor);
	}
	@Test
	public void naoTemNumerosConsecutivas(){
		Function<String, Integer> function = facade.getConsecutiveNumbers();
		String senha = "S3Nh4";
		int valor = function.apply(senha);
		Assert.assertEquals( 0, valor);
	}
////////////////
	@Test
	public void temMaisDe3NumerosEmSequencia(){
		String senha = "1234a56789";
		Function<String, Integer> function = facade.getSequentialNumbers();
		int valor = function.apply(senha);
		Assert.assertEquals( 15, valor);
	}
	@Test
	public void naoTemNumerosEmSequencia(){
		Function<String, Integer> function = facade.getSequentialNumbers();
		String senha = "S3Nh4";
		int valor = function.apply(senha);
		Assert.assertEquals( 0, valor);
	}
////////////////
	@Test
	public void temMaisDe3LetrasEmSequencia(){
		String senha = "1234abcd56789";
		Function<String, Integer> function = facade.getSequentialLetters();
		int valor = function.apply(senha);
		Assert.assertEquals( 6, valor);
	}
	@Test
	public void naoTemLetrasEmSequencia(){
		Function<String, Integer> function = facade.getSequentialLetters();
		String senha = "S3Nh4";
		int valor = function.apply(senha);
		Assert.assertEquals( 0, valor);
	}
////////////////
	@Test
	public void temMaisDe3SimbolosEmSequencia(){
		String senha = "1234()*+56789";
		Function<String, Integer> function = facade.getSequentialSymbols();
		int valor = function.apply(senha);
		Assert.assertEquals( 6, valor);
	}
	@Test
	public void naoTemSimbolosEmSequencia(){
		Function<String, Integer> function = facade.getSequentialSymbols();
		String senha = "S3Nh4";
		int valor = function.apply(senha);
		Assert.assertEquals( 0, valor);
	}
////////////////
	@Test
	public void temCaracteresRepetidos(){
		Function<String, Integer> function = facade.getRepeatCharacters();
		String senha = "aaaa";
		int valor = function.apply(senha);
		Assert.assertEquals( 25, valor);
	}
	@Test
	public void naoTemCaracteresRepetidos(){
		Function<String, Integer> function = facade.getRepeatCharacters();
		String senha = "naotem";
		int valor = function.apply(senha);
		Assert.assertEquals( 0, valor);
	}
	
}
