package br.com.coppieters.facade;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.coppieters.score.ScoreLabelEnum;
import br.com.coppieters.service.ScoreApplication;

@Service
public class ScoreFacade implements ScoreApplication<Map<String,String>>{

	@Autowired
	@Qualifier("IncrementalScore")
	List<Function<String, Integer>> incrementalScores;
	
	@Autowired
	@Qualifier("DecrementalScore")
	List<Function<String, Integer>> decrementalScores;
	
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
		return Math.abs(incrementalScore - decrementalScore);
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
}
