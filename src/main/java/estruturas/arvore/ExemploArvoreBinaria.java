package estruturas.arvore;

import java.util.Arrays;
import java.util.function.BiConsumer;

public class ExemploArvoreBinaria {
	
	public static void main(String[] args) {
		
		/*
		 * Uma estrutura do tipo �rvore consiste em usar um n� inicial, comumente chamdo de raiz, para armazenar alguma informa��o 
		 * e, com base nisso, distribuir informa��es abaixo de forma, que o acesso seja r�pido e pouco gasto.
		 * 
		 * Optou-se por implementar uma das �rvores mais simples que � a bin�ria. Ou seja, h� apenas dois elementos abaixo de cada n�,
		 * um maior e um menor.
		 * 
		 * A estrutura �rvore � usada para, por exemplo, armazenamento de dados, por�m a implementa��o � distinta desta, sendo conhecida com �rvore B.
		 * Uma arvore B pode, por exemplo, para cada pasta que se deseja apresentar, criar um n� abaixo.
		 * Dessa forma, cada pasta ter� uma refer�ncia � um n� abaixo. 
		 *
		 * Voltando � implementa��o abaixo, para cada momento que um item � adicionado, � �rvore � percorrida parcialmente para a adi��o de um novo elemento.
		 */
		ArvoreBinaria arvore = new ArvoreBinaria();
	
		System.out.println(arvore);
/*Neste momento, nossa �rvore estar� vazia, e ent�o adicionaremos o elemento 5 nela. Este ser� nossa raiz*/
		arvore.adicionar(5);
		System.out.println(arvore);
		
/*Agora, iremos adicionar os elementos 3 e 6, deixando nossa �rvore da seguinte forma:
 * 				5
 * 		3				6
 */
		arvore.adicionar(3);
		System.out.println(arvore);
		
		arvore.adicionar(6);
		System.out.println(arvore);
/* A partir de agora, sempre que adicionarmos um elemento, 
 * a adi��o ser� feita de forma recursiva, 
 * at� validar-se o n� que faz sentido de possuir o valor*/
		
		arvore.adicionar(2); // estes itens ficar�o na sub-�rvore do elemento 3
		System.out.println(arvore);
		arvore.adicionar(4);
		System.out.println(arvore);
		
		arvore.adicionar(1); // este item ficar� na sub-�rvore do elemento 2
		System.out.println(arvore);

		
		arvore.adicionar(7);// estes itens ficar�o na sub-�rvore do elemento 6
		System.out.println(arvore);
		arvore.adicionar(8);
		System.out.println(arvore);
	/* 					5
	 * 			3				6
	 * 		2		4		7		8
	 * 	1
	 */
	
	/*
	 * � interessante observar que, mesmo crescendo muito, conseguimos com poucos acesso chegar � um elemento.
	 * Por exemplo, para acessarmos o elemento 4, partindo da raiz, faremos acesso ao 3 e depois ao 4.
	 * 
	 * Abaixo � apresentado um buscador que realiza um busca em profundidade
	 * */
		
		BuscadorEmProfundidade buscador = new BuscadorEmProfundidade();
		buscador.buscar(4, arvore.getRaiz());

/*
 * Quando falamos ainda de acesso � elementos, h� tr�s formas de acessar: o pre-order, pos-order e o in-order
 * Sendo que para o primeiro, acessa-se o no primeiro, e depois acessa-se o menor e depois o maior.
 * O pos-order � o oposto, no sentido de acessar os nos primeiro, e depois acessar o valor do no corrente.
 * Por fim, o in-order acessar o menor elemento, o elemento atual e o elemento maior.
 * 
 * Abaixo, s�o apresentadas as implementa��es referentes
 * */

		BiConsumer<No, Integer> exibidor = (no,camada) -> 
			System.out.println( new String(new char[camada]).replace("\0", "-") + no.getValor().toString() );
		
		Arrays.asList(new PreOrder(), new PosOrder(), new InOrder()).forEach( v -> v.visitar(arvore.getRaiz(),exibidor) );
		
	}

	
}
