package br.com.coppieters.score;

import java.util.function.Function;

public class MiddleNumbersOrSymbolsFlat implements Function<String, Integer> {

	@Override
	public Integer apply(String p) {
		if( p.length() <= 2) return 0;
		int resp = p.replaceAll(".(.*).","$1").replaceAll("[a-zA-Z]","").replaceAll(" ","").trim().length();
		return resp * 2;
	}

}
