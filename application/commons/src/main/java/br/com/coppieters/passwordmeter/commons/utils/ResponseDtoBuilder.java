package br.com.coppieters.passwordmeter.commons.utils;
/**
 * Classe abstrata genérica responsável por definir o template de como funcionará a criação do DTO de resposta.
 *
 * @since 10 de jan de 2017 
 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
 *
 */
public abstract class ResponseDtoBuilder<T> {
	protected final String INCREMENTAL_SCORE= "incremental";
	protected final String DECREMENTAL_SCORE= "descremental";
	protected final String SCORE= "score";
	
	private T response;
	/**
	 * Método responsável por criar a instãncia desejada
	 *
	 * @since 10 de jan de 2017 
	 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
	 * @return Instância do objeto genérico
	 */
	public abstract ResponseDtoBuilder<T> newInstance();
	/**
	 * Método responsável por adicionar a pontuação positiva da senha
	 *
	 * @since 10 de jan de 2017 
	 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
	 * @param score - pontuação
	 * @return
	 */
	public abstract ResponseDtoBuilder<T> addIncrementalScore(Integer score);
	/**
	 * Método responsável por adicionar a pontuação negativa da senha
	 *
	 * @since 10 de jan de 2017 
	 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
	 * @param score - pontuação
	 * @return
	 */
	public abstract ResponseDtoBuilder<T> addDecrementalScore(Integer score);
	/**
	 * Método responsável por adicionar a pontuação
	 *
	 * @since 10 de jan de 2017 
	 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
	 * @param score - pontuação
	 * @return
	 */
	public abstract ResponseDtoBuilder<T> addScore(Integer score);
	/**
	 * Método responsável por adicionar um valor genérico ao dto de resposta
	 *
	 * @since 10 de jan de 2017 
	 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
	 * @param score - pontuação
	 * @return
	 */
	public abstract ResponseDtoBuilder<T>  addKeyAndValue(String key, String value);
		
	public T getResponse(){
		return this.response;
	}
	protected void setResponse(T response){
		this.response = response;
	}
}
