package br.com.coppieters.passwordmeter.facade;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScoreFactory {
	
	@Autowired
	IncrementalScoreFacade incrementalScore;
	
	@Autowired
	DecrementalScoreFacade decrementalScore;
	
	@Bean(name = "IncrementalScore")
	public List<Function<String, Integer>> incrementalScoresFactory(){
		return incrementalScore.getAll();
	}
	
	@Bean(name = "DecrementalScore")
	public List<Function<String, Integer>> decrementalScoresFactory(){
		return decrementalScore.getAll();
	}
}
