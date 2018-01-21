package br.com.coppieters.score.decremental;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.coppieters.score.ScoreCalculator;
import br.com.coppieters.utils.Regex;

@Configuration
public class SimpleDescrementalScoreCalculatorFactory {
	private final Logger LOG = Logger.getLogger(getClass());

	@Bean(name = "AmericanNumbersOnlyScoreCalculator")
	public ScoreCalculator AmericanNumbersOnlyScoreCalculator(){
		return s -> {
			LOG.info("Usando o AmericanNumbersOnlyScoreCalculator");
			return s.replaceAll(Regex.OnlyNumber.getRegex(), "").length() > 0 ? 0 : s.length();
		};
	}

	@Bean(name = "CanadianNumbersOnlyScoreCalculator")
	public ScoreCalculator CanadianNumbersOnlyScoreCalculator(){
		return s -> {
			LOG.info("Usando o CanadianNumbersOnlyScoreCalculator");
			return s.replaceAll(Regex.OnlyNumber.getRegex(), "").length() > 0 ? 0 : s.length();
		};
	}

}
