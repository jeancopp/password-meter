package br.com.coppieters.service;

import br.com.coppieters.utils.ResponseDtoBuilder;

public interface ScoreApplication<T> {

	 public default T calculateScore(String pass, ResponseDtoBuilder<T> responseDtoBuilder){
		 
		 Integer incrementalScore = calculateIncrementalScoreWith(pass);
		 Integer descrementalScore = calculateDescrementalScoreWith(pass);
		 Integer score = calculateScore(incrementalScore, descrementalScore);
		 
		 if(score < 0) score = 0;
		 else if(score > 100) score = 100;
		 
		 String label = getLabelOfScore(score,incrementalScore,descrementalScore);
		 
		 return responseDtoBuilder.addDecrementalScore(descrementalScore)
			 					.addIncrementalScore(incrementalScore)
			 					.addScore(score)
			 					.addKeyAndValue("complexity", label)
			 					.getResponse();
	 }
	 
	 Integer calculateDescrementalScoreWith(String password);
	 Integer calculateIncrementalScoreWith(String password);
	 Integer calculateScore(Integer incrementalScore, Integer decrementalScore);
	 String getLabelOfScore(Integer score,Integer incrementalScore, Integer decrementalScore);
}
