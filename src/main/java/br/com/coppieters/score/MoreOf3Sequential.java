package br.com.coppieters.score;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MoreOf3Sequential implements Function<String, Integer> {

	private String regexToRemove;

	public MoreOf3Sequential(String regexToRemove) {
		this.regexToRemove = regexToRemove;
	}
	
	@Override
	public Integer apply(String s) {
		String all = s.replaceAll(regexToRemove, " ").trim().replaceAll("\\s+", ";");
		List<String> list = Arrays.asList(all.split(";")).stream().filter( w -> w.length() >= 3 ).collect(Collectors.toList());
		int count = list.stream()
						.mapToInt( w -> {
							int c = 0;
							for(int j=0; j + 2 < w.length(); j++){
								String p = w.substring(j, j+3);
								if(p.charAt(0) +1 == p.charAt(1) && p.charAt(1) == p.charAt(2) - 1){
									c++;
								}
							}
							return c;
						}).sum();
		return count * 3;
	}

}
