package br.com.coppieters.score;


import java.util.List;
import java.util.function.Function;

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
