package br.com.coppieters.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ResponseDtoBuilderImpl extends ResponseDtoBuilder<Map<String,String>> {

	private final String INCREMENTAL_SCORE= "incremental";
	private final String DECREMENTAL_SCORE= "descremental";
	private final String SCORE= "score";

	public ResponseDtoBuilderImpl() {
		newInstance();
	}
	
	@Override
	public ResponseDtoBuilder<Map<String, String>> newInstance() {
		setResponse(new HashMap<>());
		return this;
	}

	@Override
	public ResponseDtoBuilder<Map<String, String>> addIncrementalScore(Integer score) {
		if(null == score) throw new NullPointerException("Score not can be null");
		getResponse().put(INCREMENTAL_SCORE, score.toString());
		return this;
	}

	@Override
	public ResponseDtoBuilder<Map<String, String>> addDecrementalScore(Integer score) {
		if(null == score) throw new NullPointerException("Score not can be null");
		getResponse().put(DECREMENTAL_SCORE, score.toString());
		return this;
	}

	@Override
	public ResponseDtoBuilder<Map<String, String>> addScore(Integer score) {
		if(null == score) throw new NullPointerException("Score not can be null");
		getResponse().put(SCORE, score.toString());
		return this;
	}

	@Override
	public ResponseDtoBuilder<Map<String, String>> addKeyAndValue(String key, String value) {
		if(null == key) throw new NullPointerException("Key not can be null");
		if(null == value) throw new NullPointerException("Value not can be null");
		this.getResponse().put(key,value);
		return this;
	}

}
