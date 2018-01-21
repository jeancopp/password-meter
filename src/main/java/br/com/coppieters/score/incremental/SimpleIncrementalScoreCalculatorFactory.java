package br.com.coppieters.score.incremental;

import br.com.coppieters.score.ScoreCalculator;
import br.com.coppieters.utils.Regex;

public class SimpleIncrementalScoreCalculatorFactory {

	public ScoreCalculator numberOfCharactersScoreCalculator() {
		return s -> s.length() * 4;
	}

	public ScoreCalculator numbersScoreCalculator() {
		return s -> (s.length() - s.replaceAll(Regex.OnlyNumber.getRegex(), "").length()) * 4;
	}

	public ScoreCalculator symbolsScoreCalculator() {
		return s -> s.replaceAll(Regex.AllCommonCharacters.getRegex(), "").length() * 6;
	}

	private static SimpleIncrementalScoreCalculatorFactory instance;
	public static SimpleIncrementalScoreCalculatorFactory getInstance() {
		if (null == instance)
			instance = new SimpleIncrementalScoreCalculatorFactory();
		return instance;
	}

	private SimpleIncrementalScoreCalculatorFactory() {}
}
