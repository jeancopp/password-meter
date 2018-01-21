package br.com.coppieters.facade;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.coppieters.score.ScoreCalculator;
import br.com.coppieters.score.incremental.LetterCaseParser;
import br.com.coppieters.score.incremental.MiddleNumbersOrSymbolsFlat;
import br.com.coppieters.score.incremental.Requirements;
import br.com.coppieters.score.incremental.SimpleIncrementalScoreCalculatorFactory;
import br.com.coppieters.utils.Regex;
/**
 * Facade responsável por implementar a regra de pontuação a ser incrementada
 *
 * @since 10 de jan de 2017 
 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
 *
 */
@Component
public class IncrementalScoreFacade {
	
	@Autowired
	private MiddleNumbersOrSymbolsFlat middleNumbersOrSymbols;	
	
	private ScoreCalculator numberOfCharacters = SimpleIncrementalScoreCalculatorFactory.getInstance().numberOfCharactersScoreCalculator();	
	private ScoreCalculator numbers = SimpleIncrementalScoreCalculatorFactory.getInstance().numbersScoreCalculator();
	private ScoreCalculator symbols = SimpleIncrementalScoreCalculatorFactory.getInstance().symbolsScoreCalculator();	
	
	private ScoreCalculator uppercaseLetters =  new LetterCaseParser(Regex.UpperCaseLetters);	
	private ScoreCalculator lowercaseLetters =  new LetterCaseParser(Regex.LowerCaseLetters);	
	private ScoreCalculator requirements = new Requirements(Arrays.asList(numberOfCharacters,uppercaseLetters,lowercaseLetters, numbers, symbols));

	public ScoreCalculator getNumberOfCharacters() {
		return numberOfCharacters;
	}

	public ScoreCalculator getUppercaseLetters() {
		return uppercaseLetters;
	}

	public ScoreCalculator getLowercaseLetters() {
		return lowercaseLetters;
	}

	public ScoreCalculator getNumbers() {
		return numbers;
	}

	public ScoreCalculator getSymbols() {
		return symbols;
	}

	public ScoreCalculator getMiddleNumbersOrSymbols() {
		return middleNumbersOrSymbols;
	}

	public ScoreCalculator getRequirements() {
		return requirements;
	}

	public List<Function<String, Integer>> getAll() {
		return Arrays.asList(getNumberOfCharacters(),getUppercaseLetters(),getLowercaseLetters(), getNumbers(), 
				getSymbols(), getMiddleNumbersOrSymbols() , getRequirements() );
	}
	
	
	
}
