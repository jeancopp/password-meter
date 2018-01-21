package br.com.coppieters.facade;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.coppieters.score.ScoreCalculator;
import br.com.coppieters.score.decremental.Consecutive;
import br.com.coppieters.score.decremental.MoreOf3Sequential;
import br.com.coppieters.score.decremental.RepeatCharacter;
import br.com.coppieters.score.decremental.SimpleDescrementalScoreCalculatorFactory;
import br.com.coppieters.utils.Regex;
/**
 *Facade responsável por implementar o conjunto de métodos de pontuação a ser removida
 *
 * @since 10 de jan de 2017 
 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
 *
 */
@Component
public class DecrementalScoreFacade {
	@Autowired
	private RepeatCharacter repeatCharacters;
	
	private ScoreCalculator lettersOnly = SimpleDescrementalScoreCalculatorFactory.getInstance().LetterOnlyScoreCalculator();	
	private ScoreCalculator numbersOnly = SimpleDescrementalScoreCalculatorFactory.getInstance().NumbersOnlyScoreCalculator();
	
	private ScoreCalculator consecutiveUppercaseLetters = new Consecutive(Regex.UpperCaseLetters);//-(n*2)	
	private ScoreCalculator consecutiveLowercaseLetters = new Consecutive(Regex.LowerCaseLetters);//-(n*2)	
	private ScoreCalculator consecutiveNumbers = new Consecutive(Regex.OnlyNumber);//-(n*2)	
	private ScoreCalculator sequentialLetters = new MoreOf3Sequential(Regex.OnlyNumber);
	private ScoreCalculator sequentialNumbers = new MoreOf3Sequential(Regex.LetterIgnoreCase);//-(n*3)	
	private ScoreCalculator sequentialSymbols = new MoreOf3Sequential(Regex.AllCommonCharacters);// -(n*3)
	
	public ScoreCalculator getLettersOnly() {
		return lettersOnly;
	}
	public ScoreCalculator getNumbersOnly() {
		return numbersOnly;
	}
	public ScoreCalculator getRepeatCharacters() {
		return repeatCharacters;
	}
	public ScoreCalculator getConsecutiveUppercaseLetters() {
		return consecutiveUppercaseLetters;
	}
	public ScoreCalculator getConsecutiveLowercaseLetters() {
		return consecutiveLowercaseLetters;
	}
	public ScoreCalculator getConsecutiveNumbers() {
		return consecutiveNumbers;
	}
	public ScoreCalculator getSequentialLetters() {
		return sequentialLetters;
	}
	public ScoreCalculator getSequentialNumbers() {
		return sequentialNumbers;
	}
	public ScoreCalculator getSequentialSymbols() {
		return sequentialSymbols;
	}
	
	public List<Function<String, Integer>> getAll() {
		return Arrays.asList(getLettersOnly()
				,getNumbersOnly()
				,getRepeatCharacters()
				,getConsecutiveUppercaseLetters()
				,getConsecutiveLowercaseLetters()
				,getConsecutiveNumbers()
				,getSequentialLetters()
				,getSequentialNumbers()
				,getSequentialSymbols());
	}
	
	
}
