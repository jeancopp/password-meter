package br.com.coppieters.facade;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import br.com.coppieters.score.ScoreLabelEnum;
import br.com.coppieters.service.ScoreApplication;
/**
 * Facade responsável por implementar a regra de calculo para pontuação da senha
 *
 * @since 10 de jan de 2017 
 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
 *
 */
@Service
public class ScoreFacade implements ScoreApplication<Map<String,String>>{

	private List<Function<String, Integer>> incrementalScores;
	private List<Function<String, Integer>> decrementalScores;
	private MessageSource messageSource;

	@Autowired
	public ScoreFacade(
		@Qualifier("IncrementalScore")	List<Function<String, Integer>> incrementalScores
		,@Qualifier("DecrementalScore") List<Function<String, Integer>> decrementalScores
		,MessageSource messageSource) {
			this.incrementalScores = incrementalScores;
			this.decrementalScores = decrementalScores;
			this.messageSource = messageSource;
	}
	
	
	@Override
	public Integer calculateDescrementalScoreWith(String password) {
		int ret = calculate(decrementalScores,password);
		return ret;
	}

	@Override
	public Integer calculateIncrementalScoreWith(String password) {
		int ret = calculate(incrementalScores,password);
		return ret;
	}

	@Override
	public Integer calculateScore(Integer incrementalScore, Integer decrementalScore) {
		return incrementalScore - decrementalScore;
	}

	@Override
	public ScoreLabelEnum getScore(Integer score,Integer incrementalScore, Integer decrementalScore) {
		return ScoreLabelEnum.getLabel(score,incrementalScore,decrementalScore);
	}
	
	private final int calculate(Collection<Function<String, Integer>> functions, String password){
		return functions.stream()
				.mapToInt( f -> f.apply(password) )
				.sum();
	}


	@Override
	public String translateScore(ScoreLabelEnum scoreLabel, Locale locale) {
		String score = messageSource.getMessage(scoreLabel.getValue(),null, locale);
		return score;
	}
}
