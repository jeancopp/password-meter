package br.com.coppieters.passwordmeter.application;

import br.com.coppieters.passwordmeter.commons.utils.ResponseDtoBuilder;
/**
 * Interface responsável por definir o contrato do calculo de score, bem como o mesmo funcionará para o calculo, comum à todos
 *
 * @since 10 de jan de 2017 
 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
 *
 */
public interface ScoreApplication<T> {
	/**
	 * Método responsável por definir como o calculo do score serpa realizado
	 *
	 * @since 10 de jan de 2017 
	 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
	 * @param pass -> Senha a ser calculado o score.
	 * @param responseDtoBuilder -> Instância que construira o retorno do tipo T
	 * @return Retorno de tipo genérico, que conterá informações sobre complexidade, a pontuação geral da senha(0 à 100), bem como a pontuação posítiva e a negativa
	 */
	 public default T calculateScore(String pass, ResponseDtoBuilder<T> responseDtoBuilder){
		 Integer incrementalScore = calculateIncrementalScoreWith(pass);
		 Integer descrementalScore = calculateDescrementalScoreWith(pass);
		 Integer score = calculateScore(incrementalScore, descrementalScore);
		 
		 if(score < 0) score = 0;
		 else if(score > 100) score = 100;
		 
		 String label = getLabelOfScore(score,incrementalScore,descrementalScore);
		 
		 responseDtoBuilder.addDecrementalScore(descrementalScore)
			 					.addIncrementalScore(incrementalScore)
			 					.addScore(score)
			 					.addKeyAndValue("complexity", label);
		 doThingsWithBuilder(responseDtoBuilder);
		 return responseDtoBuilder.getResponse();
	 }
	 default void doThingsWithBuilder(ResponseDtoBuilder<T> builder) {
		 //I DO NOTHING
	 }
	 /**
	  * Método responsável por realizar o calculo de pontuação a ser removida.
	  * @since 10 de jan de 2017 
	  * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
	  * @param password Senha a ser calculada à pontuação
	  * @return Pontuação a ser descrementada
	  */
	 Integer calculateDescrementalScoreWith(String password);
	 /**
	  * Método responsável por realizar o calculo de pontuação a ser adicionada.
	  * @since 10 de jan de 2017 
	  * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
	  * @param password Senha a ser calculada à pontuação
	  * @return Pontuação a ser adicionada
	  */
	 Integer calculateIncrementalScoreWith(String password);
	 /**
	  * Método responsável por calcular a pontuação
	  * @since 10 de jan de 2017 
	  * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
	  * @param incrementalScore Pontos posítivos da senha 
	  * @param decrementalScore Pontos negativos da senha
	  * @return Pontuação da senha
	  */
	 Integer calculateScore(Integer incrementalScore, Integer decrementalScore);
	 /**
	  * Método responsável por analisar 
	  * @since 10 de jan de 2017 
	  * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
	  * @param score Pontuação geral da senha, contiados no intervalo de 0 à 100
	  * @param incrementalScore Total da pontuação positiva que a senha recebeu
	  * @param decrementalScore Total da Pontuação negativa que a senha recebeu
	  * @return String que conterá à complexidade da senha
	  */
	 String getLabelOfScore(Integer score,Integer incrementalScore, Integer decrementalScore);
}
