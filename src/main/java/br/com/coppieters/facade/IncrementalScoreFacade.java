package br.com.coppieters.facade;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.coppieters.score.LetterCaseParser;
import br.com.coppieters.score.MiddleNumbersOrSymbolsFlat;
import br.com.coppieters.score.Requirements;

@Component
public class IncrementalScoreFacade {
	
	
	private Function<String,Integer> numberOfCharacters = s -> s.length() * 4 ;	
	private Function<String,Integer> numbers = s -> ( s.length() - s.replaceAll("[0-9]", "").length() )  * 4;
	private Function<String,Integer> symbols = s -> s.replaceAll("[a-zA-Z0-9]","").length() * 6;	
	
	private Function<String,Integer> uppercaseLetters =  new LetterCaseParser("[A-Z]");	
	private Function<String,Integer> lowercaseLetters =  new LetterCaseParser("[a-z]");	
	private Function<String,Integer> middleNumbersOrSymbols = new MiddleNumbersOrSymbolsFlat();	
	private Function<String,Integer> requirements = new Requirements(Arrays.asList(numberOfCharacters,uppercaseLetters,lowercaseLetters, numbers,symbols));

	public Function<String, Integer> getNumberOfCharacters() {
		return numberOfCharacters;
	}

	public Function<String, Integer> getUppercaseLetters() {
		return uppercaseLetters;
	}

	public Function<String, Integer> getLowercaseLetters() {
		return lowercaseLetters;
	}

	public Function<String, Integer> getNumbers() {
		return numbers;
	}

	public Function<String, Integer> getSymbols() {
		return symbols;
	}

	public Function<String, Integer> getMiddleNumbersOrSymbols() {
		return middleNumbersOrSymbols;
	}

	public Function<String, Integer> getRequirements() {
		return requirements;
	}

	public List<Function<String, Integer>> getAll() {
		return Arrays.asList(getNumberOfCharacters(),getUppercaseLetters(),getLowercaseLetters(), getNumbers(), 
				getSymbols(), getMiddleNumbersOrSymbols() , getRequirements() );
	}
	
	
	
}
