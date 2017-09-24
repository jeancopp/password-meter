package br.com.coppieters.passwordmeter.score;

import java.util.function.Function;
/**
 * Classe responsável por calcular se há caracteres repetidos na senha.
 * Calculo é particular do autor do site <http://www.passwordmeter.com/> e foi implementado de forma semelhante
 *
 * @since 10 de jan de 2017 
 * @author Jean Coppieters Souza <jean.coppieters@hotmail.com>
 *
 */
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
