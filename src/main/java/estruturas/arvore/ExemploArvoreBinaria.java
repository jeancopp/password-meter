package estruturas.arvore;

import java.util.Arrays;
import java.util.function.BiConsumer;

public class ExemploArvoreBinaria {
	
	public static void main(String[] args) {
		
		/*
		 * Uma estrutura do tipo árvore consiste em usar um nó inicial, comumente chamdo de raiz, para armazenar alguma informação 
		 * e, com base nisso, distribuir informações abaixo de forma, que o acesso seja rápido e pouco gasto.
		 * 
		 * Optou-se por implementar uma das árvores mais simples que é a binária. Ou seja, há apenas dois elementos abaixo de cada nó,
		 * um maior e um menor.
		 * 
		 * A estrutura árvore é usada para, por exemplo, armazenamento de dados, porém a implementação é distinta desta, sendo conhecida com árvore B.
		 * Uma arvore B pode, por exemplo, para cada pasta que se deseja apresentar, criar um nó abaixo.
		 * Dessa forma, cada pasta terá uma referência à um nó abaixo. 
		 *
		 * Voltando à implementação abaixo, para cada momento que um item é adicionado, à árvore é percorrida parcialmente para a adição de um novo elemento.
		 */
		ArvoreBinaria arvore = new ArvoreBinaria();
	
		System.out.println(arvore);
/*Neste momento, nossa árvore estará vazia, e então adicionaremos o elemento 5 nela. Este será nossa raiz*/
		arvore.adicionar(5);
		System.out.println(arvore);
		
/*Agora, iremos adicionar os elementos 3 e 6, deixando nossa árvore da seguinte forma:
 * 				5
 * 		3				6
 */
		arvore.adicionar(3);
		System.out.println(arvore);
		
		arvore.adicionar(6);
		System.out.println(arvore);
/* A partir de agora, sempre que adicionarmos um elemento, 
 * a adição será feita de forma recursiva, 
 * até validar-se o nó que faz sentido de possuir o valor*/
		
		arvore.adicionar(2); // estes itens ficarão na sub-árvore do elemento 3
		System.out.println(arvore);
		arvore.adicionar(4);
		System.out.println(arvore);
		
		arvore.adicionar(1); // este item ficará na sub-árvore do elemento 2
		System.out.println(arvore);

		
		arvore.adicionar(7);// estes itens ficarão na sub-árvore do elemento 6
		System.out.println(arvore);
		arvore.adicionar(8);
		System.out.println(arvore);
	/* 					5
	 * 			3				6
	 * 		2		4		7		8
	 * 	1
	 */
	
	/*
	 * É interessante observar que, mesmo crescendo muito, conseguimos com poucos acesso chegar à um elemento.
	 * Por exemplo, para acessarmos o elemento 4, partindo da raiz, faremos acesso ao 3 e depois ao 4.
	 * 
	 * Abaixo é apresentado um buscador que realiza um busca em profundidade
	 * */
		
		BuscadorEmProfundidade buscador = new BuscadorEmProfundidade();
		buscador.buscar(4, arvore.getRaiz());

/*
 * Quando falamos ainda de acesso à elementos, há três formas de acessar: o pre-order, pos-order e o in-order
 * Sendo que para o primeiro, acessa-se o no primeiro, e depois acessa-se o menor e depois o maior.
 * O pos-order é o oposto, no sentido de acessar os nos primeiro, e depois acessar o valor do no corrente.
 * Por fim, o in-order acessar o menor elemento, o elemento atual e o elemento maior.
 * 
 * Abaixo, são apresentadas as implementações referentes
 * */

		BiConsumer<No, Integer> exibidor = (no,camada) -> 
			System.out.println( new String(new char[camada]).replace("\0", "-") + no.getValor().toString() );
		
		Arrays.asList(new PreOrder(), new PosOrder(), new InOrder()).forEach( v -> v.visitar(arvore.getRaiz(),exibidor) );
		
	}

	
}
