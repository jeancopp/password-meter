package br.com.coppieters.score.decremental;

import br.com.coppieters.score.ScoreCalculator;
import br.com.coppieters.utils.Regex;

public class SimpleDescrementalScoreCalculatorFactory {
	
	public ScoreCalculator LetterOnlyScoreCalculator(){
		return s -> s.replaceAll(Regex.LetterIgnoreCase.getRegex(), "").length() > 0 ? 0 : s.length() ;//	-n	
	}
	
	public ScoreCalculator NumbersOnlyScoreCalculator(){
		return s -> s.replaceAll(Regex.OnlyNumber.getRegex(), "").length() > 0 ? 0 : s.length();
	}

	private static SimpleDescrementalScoreCalculatorFactory instance;
	public static SimpleDescrementalScoreCalculatorFactory getInstance(){
		if( null == instance )
			instance = new SimpleDescrementalScoreCalculatorFactory();
		return instance;
	}
	
	private SimpleDescrementalScoreCalculatorFactory(){}
}
