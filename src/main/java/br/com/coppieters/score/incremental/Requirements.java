package br.com.coppieters.score.incremental;


import java.util.List;
import java.util.function.Function;
/**
 * Classe responsável por calcular se a senha antende ao mínimo de requisitos
 *
 * @since 10 de jan de 2017 
 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
 *
 */
public class Requirements implements Function<String, Integer> {

	private List<Function<String, Integer>> requirements;

	public Requirements(List<Function<String, Integer>> requirements) {
		this.requirements = requirements;
	}

	@Override
	public Integer apply(final String s) {
		int requirementssAccepted = requirements.stream().mapToInt(f -> {
			int v = f.apply(s);
			return v / Math.max(v, 1);
		}).sum();
		return (double) requirementssAccepted / requirements.size() > 0.75 ? requirementssAccepted * 2 : 0;
	}

}
