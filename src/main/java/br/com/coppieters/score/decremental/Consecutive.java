package br.com.coppieters.score.decremental;

import java.util.function.Function;

import br.com.coppieters.utils.Regex;
/**
 * Classe responsável por implementar a regra calculo de pontuação para caracteres consecutivos
 *
 * @since 10 de jan de 2017 
 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
 *
 */
public class Consecutive implements Function<String, Integer> {

	private final String regex;

	public Consecutive(Regex regex) {
		this.regex = regex.getRegexWithNOrMore(2);
	}

	@Override
	public Integer apply(String s) {
		String wordWithoutRegex = s.replaceAll(regex, "");
		if(wordWithoutRegex.length() == s.length())return 0;
		return (s.length() - wordWithoutRegex.length() - 1 ) * 2;
	}

}
