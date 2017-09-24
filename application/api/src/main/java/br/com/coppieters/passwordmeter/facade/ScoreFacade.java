package br.com.coppieters.passwordmeter.facade;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.coppieters.passwordmeter.application.ScoreApplication;
import br.com.coppieters.passwordmeter.commons.utils.ResponseDtoBuilder;
import br.com.coppieters.passwordmeter.score.ScoreLabelEnum;

@Service
public class ScoreFacade implements ScoreApplication<Map<String,String>>{

	@Autowired
	@Qualifier("IncrementalScore")
	List<Function<String, Integer>> incrementalScores;
	
	@Autowired
	@Qualifier("DecrementalScore")
	List<Function<String, Integer>> decrementalScores;
	
	@Autowired
	Environment environment;
	
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
	public String getLabelOfScore(Integer score,Integer incrementalScore, Integer decrementalScore) {
		return ScoreLabelEnum.getLabel(score,incrementalScore,decrementalScore).getValue();
	}
	
	private final int calculate(Collection<Function<String, Integer>> functions, String password){
		return functions.stream()
				.mapToInt( f -> f.apply(password) )
				.sum();
	}
	
	@Override
	public void doThingsWithBuilder(ResponseDtoBuilder<Map<String, String>> builder) {
		builder.addKeyAndValue("port", environment.getProperty("local.server.port"));
	}
}
