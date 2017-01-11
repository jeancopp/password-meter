package br.com.coppieters.facade;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.coppieters.score.decremental.Consecutive;
import br.com.coppieters.score.decremental.MoreOf3Sequential;
import br.com.coppieters.score.decremental.RepeatCharacter;
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
	
	private Function<String,Integer> lettersOnly = s -> s.replaceAll(Regex.LetterIgnoreCase.getRegex(), "").length() > 0 ? 0 : s.length() ;//	-n	
	private Function<String,Integer> numbersOnly = s -> s.replaceAll(Regex.OnlyNumber.getRegex(), "").length() > 0 ? 0 : s.length() ;//	-n;//-n
	
	private Function<String,Integer> repeatCharacters = new RepeatCharacter();
	private Function<String,Integer> consecutiveUppercaseLetters = new Consecutive(Regex.UpperCaseLetters);//-(n*2)	
	private Function<String,Integer> consecutiveLowercaseLetters = new Consecutive(Regex.LowerCaseLetters);//-(n*2)	
	private Function<String,Integer> consecutiveNumbers = new Consecutive(Regex.OnlyNumber);//-(n*2)	
	private Function<String,Integer> sequentialLetters = new MoreOf3Sequential(Regex.OnlyNumber);
	private Function<String,Integer> sequentialNumbers = new MoreOf3Sequential(Regex.LetterIgnoreCase);//-(n*3)	
	private Function<String,Integer> sequentialSymbols = new MoreOf3Sequential(Regex.AllCommonCharacters);// -(n*3)
	
	public Function<String, Integer> getLettersOnly() {
		return lettersOnly;
	}
	public Function<String, Integer> getNumbersOnly() {
		return numbersOnly;
	}
	public Function<String, Integer> getRepeatCharacters() {
		return repeatCharacters;
	}
	public Function<String, Integer> getConsecutiveUppercaseLetters() {
		return consecutiveUppercaseLetters;
	}
	public Function<String, Integer> getConsecutiveLowercaseLetters() {
		return consecutiveLowercaseLetters;
	}
	public Function<String, Integer> getConsecutiveNumbers() {
		return consecutiveNumbers;
	}
	public Function<String, Integer> getSequentialLetters() {
		return sequentialLetters;
	}
	public Function<String, Integer> getSequentialNumbers() {
		return sequentialNumbers;
	}
	public Function<String, Integer> getSequentialSymbols() {
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
