package br.com.coppieters.passwordmeter.facade;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.coppieters.passwordmeter.commons.utils.Regex;
import br.com.coppieters.passwordmeter.score.LetterCaseParser;
import br.com.coppieters.passwordmeter.score.MiddleNumbersOrSymbolsFlat;
import br.com.coppieters.passwordmeter.score.Requirements;
/**
 * Facade responsável por implementar a regra de pontuação a ser incrementada
 *
 * @since 10 de jan de 2017 
 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
 *
 */
@Component
public class IncrementalScoreFacade {
	
	
	private Function<String,Integer> numberOfCharacters = s -> s.length() * 4 ;	
	private Function<String,Integer> numbers = s -> ( s.length() - s.replaceAll(Regex.OnlyNumber.getRegex(), "").length() )  * 4;
	private Function<String,Integer> symbols = s -> s.replaceAll(Regex.AllCommonCharacters.getRegex(),"").length() * 6;	
	
	private Function<String,Integer> uppercaseLetters =  new LetterCaseParser(Regex.UpperCaseLetters);	
	private Function<String,Integer> lowercaseLetters =  new LetterCaseParser(Regex.LowerCaseLetters);	
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
