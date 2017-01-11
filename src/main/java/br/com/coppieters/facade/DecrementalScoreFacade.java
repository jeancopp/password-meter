package br.com.coppieters.facade;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.coppieters.score.Consecutive;
import br.com.coppieters.score.MoreOf3Sequential;
import br.com.coppieters.score.RepeatCharacter;

@Component
public class DecrementalScoreFacade {
	
	private Function<String,Integer> lettersOnly = s -> s.replaceAll("[a-zA-Z]", "").length() > 0 ? 0 : s.length() ;//	-n	
	private Function<String,Integer> numbersOnly = s -> s.replaceAll("[0-9]", "").length() > 0 ? 0 : s.length() ;//	-n;//-n
	
	private Function<String,Integer> repeatCharacters = new RepeatCharacter();
	private Function<String,Integer> consecutiveUppercaseLetters = new Consecutive("[A-Z]{2,}");//-(n*2)	
	private Function<String,Integer> consecutiveLowercaseLetters = new Consecutive("[a-z]{2,}");//-(n*2)	
	private Function<String,Integer> consecutiveNumbers = new Consecutive("[0-9]{2,}");//-(n*2)	
	private Function<String,Integer> sequentialLetters = new MoreOf3Sequential("[0-9]");
	private Function<String,Integer> sequentialNumbers = new MoreOf3Sequential("[a-zA-Z]");//-(n*3)	
	private Function<String,Integer> sequentialSymbols = new MoreOf3Sequential("[a-zA-Z0-9]");// -(n*3)
	
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
