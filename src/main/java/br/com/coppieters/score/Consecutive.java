package br.com.coppieters.score;

import java.util.function.Function;

public class Consecutive implements Function<String, Integer> {

	private final String regex;

	public Consecutive(String regex) {
		this.regex = regex;
	}

	@Override
	public Integer apply(String s) {
		String wordWithoutRegex = s.replaceAll(regex, "");
		if(wordWithoutRegex.length() == s.length())return 0;
		return (s.length() - wordWithoutRegex.length() - 1 ) * 2;
	}

}
