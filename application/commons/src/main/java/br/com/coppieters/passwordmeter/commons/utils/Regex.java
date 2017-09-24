package br.com.coppieters.passwordmeter.commons.utils;

public enum Regex {
	UpperCaseLetters("[A-Z]"),
	LowerCaseLetters("[a-z]"),
	OnlyNumber("[0-9]"),
	LetterIgnoreCase("[a-zA-Z]"),
	AllCommonCharacters("[a-zA-Z0-9]");
	
	
	private final String regex;

	private Regex(String regex) {
		this.regex = regex;
		
	}
	
	public String getRegex() {
		return regex;
	}
	public String getRegexWithNOrMore(int n){
		if(n<=0){
			throw new RuntimeException("Valor inválido");
		}
		return this.regex + "{"+n+",}";
	}
}
