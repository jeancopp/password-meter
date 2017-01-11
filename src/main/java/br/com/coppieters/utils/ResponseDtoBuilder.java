package br.com.coppieters.utils;

public abstract class ResponseDtoBuilder<T> {
	protected final String INCREMENTAL_SCORE= "incremental";
	protected final String DECREMENTAL_SCORE= "descremental";
	protected final String SCORE= "score";

	private T response;
	
	public abstract ResponseDtoBuilder<T> newInstance();
	
	public abstract ResponseDtoBuilder<T> addIncrementalScore(Integer score);
	
	public abstract ResponseDtoBuilder<T> addDecrementalScore(Integer score);

	public abstract ResponseDtoBuilder<T> addScore(Integer score);
	
	public abstract ResponseDtoBuilder<T>  addKeyAndValue(String key, String value);
		
	public T getResponse(){
		return this.response;
	}
	protected void setResponse(T response){
		this.response = response;
	}
}
