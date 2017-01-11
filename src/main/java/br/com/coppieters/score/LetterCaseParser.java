package br.com.coppieters.score;

import java.util.function.Function;

public class LetterCaseParser implements Function<String, Integer> {

	private final String REGEX_TO_FIND ;

	public LetterCaseParser(String regexLetterToFind) {
		REGEX_TO_FIND = regexLetterToFind;
	}
	
	@Override
	public Integer apply(String s) {
		String wordWithoutRegex = s.replaceAll(REGEX_TO_FIND, "");
		if(wordWithoutRegex.length() == s.length())return 0;
		return ( s.length() - (s.length() - wordWithoutRegex.length() ) ) * 2;
	}

}
