package estruturas.lista;

public class ExemploLista {
	
	public static void main(String[] args) {
		/* 
		 * A Lista talvez seja a estrutura de dados mais utilizada normalmente, 
		 * por permitir trabalhar com uma grande quantidade de dados.
		 * O limite dela é o tamanho de memória que houver disponível, havendo 
		 * a possibilidade de, dada a implementação, usar também a memória em disco.
		 * 
		 * Diferente d'uma estrutura clássica de vetor, onde o tamanho deverá ser previamente 
		 * definido, a lista permitirá adicionarmos a quantidade de elementos necessários. 
		 * Porém, diferente do vetor clássico, é preciso percorrê-la para acessar os elementos,
		 * já que não obrigatoriamente os elementos estarão dispostos em sequência na memória.
		 * Há implementações que terão tratativas diferentes, obviamente, mas a idéia seguirá próxima.
		 * 
		 * Na implementação abaixo, optou-se por usar um lista duplamente encadeada, de forma 
		 * que cada elemento tem acesso rápido ao seguinte e ao anterior.
		 * Essa é uma outra desvantagem, já que para armazenar um elemento é preciso dispor do 
		 * espaço de memória do mesmo + referência ao anterior + referência ao próximo, 
		 * bem como outras referências usadas pela lista, como um ponteiro para o primeiro e para o último elemento.
		 * 
		 * Ou seja, o gasto de memória é dado por:
		 * 		quantidade de elementos * (tamanho de memório preciso + duas referências) + duas referências
		 *  
		 */
		Lista lista = new Lista();
		for(int i = 0; i < 10; i++){
			System.out.println("Adicionando o item("+i+") à lista");
			lista.adicionar(new Integer(i));
			lista.mostrarOPrimeiro();
			lista.mostrarOUltimo();
			System.out.println("Tamanho atual:"+lista.getTamanho());
		}
		
		int elemento = lista.retornar(5);
		System.out.println("Elemento no indice 5: " + elemento);
		
		int elementoRemovido = lista.remover(5);
		System.out.println("Elemento do indice 5 foi removido:" +elementoRemovido);
		
		int novoElementoNoIndice5 = lista.retornar(5);
		System.out.println("Novo elemento do indice 5 é: " + novoElementoNoIndice5);
		System.out.println("Tamanho atual:"+lista.getTamanho());
		
	}
	
}
