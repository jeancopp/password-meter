package br.com.coppieters.score.incremental;

import java.util.function.Function;

import br.com.coppieters.utils.Regex;
/**
 * Classe responsável por realizar o calculo referente se há ou não simbolos e numeros no meio da senha
 *
 * @since 10 de jan de 2017 
 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
 *
 */
public class MiddleNumbersOrSymbolsFlat implements Function<String, Integer> {

	@Override
	public Integer apply(String p) {
		if( p.length() <= 2) return 0;
		int resp = p.replaceAll(".(.*).","$1").replaceAll(Regex.LetterIgnoreCase.getRegex(),"").replaceAll(" ","").trim().length();
		return resp * 2;
	}

}
