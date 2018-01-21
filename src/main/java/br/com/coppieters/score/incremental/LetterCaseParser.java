package br.com.coppieters.score.incremental;

import br.com.coppieters.score.ScoreCalculator;
import br.com.coppieters.utils.Regex;
/**
 * Classe responsável por implementar a regra de calculo para para a busca de letras de determinado case 
 *
 * @since 10 de jan de 2017 
 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
 *
 */
public class LetterCaseParser implements ScoreCalculator {

	private final String REGEX_TO_FIND ;

	public LetterCaseParser(Regex caseletters) {
		REGEX_TO_FIND = caseletters.getRegex();
	}
	
	@Override
	public Integer apply(String s) {
		String wordWithoutRegex = s.replaceAll(REGEX_TO_FIND, "");
		if(wordWithoutRegex.length() == s.length())return 0;
		return ( s.length() - (s.length() - wordWithoutRegex.length() ) ) * 2;
	}

}
