package br.com.coppieters.score;

import java.util.Arrays;
import java.util.List;
/**
 * Enumerado dos rótulos do score
 *
 * @since 10 de jan de 2017 
 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
 *
 */
public enum ScoreLabelEnum {
	TooShort(0,"complexity.tooshort")
	,VeryWeak(20,"complexity.veryweak")
	,Weak(40,"complexity.weak")
	,Good(60,"complexity.good")
	,Strong(80,"complexity.strong")
	,VeryStrong(100,"complexity.verystrong");
	
	private String value;
	private int limit;

	private ScoreLabelEnum(int limit, String value) {
		this.limit = limit;
		this.value = value;
	}

	public static ScoreLabelEnum getLabel(Integer score, Integer incrementalScore, Integer decrementalScore) {
		List<ScoreLabelEnum> values = Arrays.asList(ScoreLabelEnum.values());
		for(ScoreLabelEnum s : values){
			if(score <= s.limit){
				return s;
			}
		}
		throw new RuntimeException("Score not previst");
	}

	public String getValue() {
		return this.value;
	}

}
