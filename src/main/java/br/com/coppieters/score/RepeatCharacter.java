package br.com.coppieters.score;

import java.util.function.Function;

public class RepeatCharacter implements Function<String,Integer>{

	@Override
	public Integer apply(String senha) {
		int contador = 0;
		double complexidade = 0;

		for (int i = 0; i < senha.length(); i++) {
			boolean existe = false;
			for (int j = 0; j < senha.length() ; j++) {
				if(senha.charAt(i) == senha.charAt(j) && (i != j)) {
					existe = true;
					complexidade += Math.abs((double) senha.length() / (j - i));
				}
			}
			
			if ( existe ) {
				contador++;
				int quantidade = senha.length() - contador;
				complexidade = Math.ceil(complexidade / Math.max( quantidade,1) );
			}
		}
		return contador > 0 ? (int) complexidade : 0;
	}

}
