package br.com.coppieters.test.facade;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.coppieters.facade.IncrementalScoreFacade;
import br.com.coppieters.test.AbstractTestConfiguration;

public class IncrementalScoreFacadeTest extends AbstractTestConfiguration{

	private String senhaEmBranco = "";
	private String senhaForte = "[Aqt3912]";
	private String senhaEmCaixaAlta = "[Aqt3912]".toUpperCase();
	private String senhaEmCaixaBaixa = "[Aqt3912]".toLowerCase();

	@Autowired	
	private IncrementalScoreFacade incrementalScore;

/////////////////////////	
	@Test
	public void numeroDeCaracteres(){
		Function<String, Integer> function = incrementalScore.getNumberOfCharacters();
		int valor = function.apply(senhaForte);
		assertEquals(senhaForte.length() * 4, valor);
	}
/////////////////////////
	@Test
	public void letrasEmCaixaAltaInformandoStringValida(){
		Function<String, Integer> function = incrementalScore.getUppercaseLetters();
		int valor = function.apply(senhaForte);
		assertEquals(16, valor);
	}
	
	@Test
	public void letrasEmCaixaAltaNaoInformandoStringComCaracterSoEmUmPadrao(){
		Function<String, Integer> function = incrementalScore.getUppercaseLetters();
		assertEquals(new Integer(0), function.apply(senhaEmCaixaBaixa)	);
		assertEquals(new Integer(12), function.apply(senhaEmCaixaAlta)	);
	}
	
	@Test
	public void letrasEmCaixaAltaNaoInformandoStringEmBranco(){
		Function<String, Integer> function = incrementalScore.getUppercaseLetters();
		assertEquals(new Integer(0), function.apply(senhaEmBranco)	);
	}	
	
/////////////////////////
	@Test
	public void letrasEmCaixaBaixaInformandoStringValida(){
		Function<String, Integer> function = incrementalScore.getLowercaseLetters();
		int valor = function.apply(senhaForte);
		assertEquals(14, valor);
	}
	
	@Test
	public void letrasEmCaixaBaixaNaoInformandoStringComCaracterSoEmUmPadrao(){
		Function<String, Integer> function = incrementalScore.getLowercaseLetters();
		assertEquals(new Integer(12), function.apply(senhaForte.toLowerCase()));
		assertEquals(new Integer(0), function.apply(senhaForte.toUpperCase()));
	}
	
	@Test
	public void letrasEmCaixaBaixaNaoInformandoStringEmBranco(){
		Function<String, Integer> function = incrementalScore.getUppercaseLetters();
		assertEquals(new Integer(0), function.apply(senhaEmBranco)	);
	}	
/////////////////////////	 
	@Test
	public void haLetrasOuSImbolosNoMeio(){
		Function<String, Integer> function = incrementalScore.getMiddleNumbersOrSymbols();
		int valor = function.apply(senhaForte);
		assertEquals(8, valor);
	}
	@Test
	public void naoHaLetrasOuSimbolosNoMeio(){
		Function<String, Integer> function = incrementalScore.getMiddleNumbersOrSymbols();
		int valor = function.apply("senhaForte");
		assertEquals(0, valor);
	}
	@Test
	public void senhaSemMeio(){
		Function<String, Integer> function = incrementalScore.getMiddleNumbersOrSymbols();
		int valor = function.apply("aa");
		assertEquals(0, valor);
	}
/////////////////////////	
	@Test
	public void temNumerosNaSenha(){
		Function<String, Integer> function = incrementalScore.getNumbers();
		int valor = function.apply(senhaForte);
		assertEquals(16, valor);
	}
	@Test
	public void naoTemNumerosNaSenha(){
		Function<String, Integer> function = incrementalScore.getNumbers();
		int valor = function.apply("senhaForte");
		assertEquals(0, valor);
	}
///////////////
	@Test
	public void temCaracteresEspeciais(){
		Function<String, Integer> function = incrementalScore.getSymbols();
		int valor = function.apply(senhaForte);
		assertEquals(12, valor);
	}
	@Test
	public void naoTemCaracteresEspeciais(){
		Function<String, Integer> function = incrementalScore.getSymbols();
		int valor = function.apply("senhaForte");
		assertEquals(0, valor);
	}
/////////////////////////
	@Test
	public void atendeTodasAsNecessidades(){
		Function<String, Integer> function = incrementalScore.getRequirements();
		int valor = function.apply(senhaForte);
		assertEquals(10, valor);
	}
	@Test
	public void naoAtendeNenhumaNecessidade(){
		Function<String, Integer> function = incrementalScore.getRequirements();
		int valor = function.apply("aa");
		assertEquals(0, valor);
	}
}
