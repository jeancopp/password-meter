package estruturas.lista;

public class ExemploLista {
	
	public static void main(String[] args) {
		/* 
		 * A Lista talvez seja a estrutura de dados mais utilizada normalmente, 
		 * por permitir que trabalhar com uma grande quantidade de dados.
		 * O limite dela � o tamanho de mem�ria que houver dispon�vel, havendo 
		 * a poss�bilidade de, dada uma implementa��o, usar tamb�m a mem�ria em disco.
		 * Diferente d'uma estrutura cl�ssica de vetor, onde o tamanho dever� ser pr�viamente 
		 * definido, a lista permitir� adicionarmos a quantidade de elementos necess�rios. 
		 * Por�m, diferente do vetor cl�ssico, � preciso percorr�-l� para acessar os elementos,
		 * j� que n�o obrigat�riamente os elementos estar�o dispostos em sequ�ncia na mem�ria.
		 * H� implementa��es que h� tratativas diferentes, obviamente, mas a id�ia seguir� pr�xima.
		 * 
		 * Na implementa��o abaixo, optou-se por usar um lista duplamente encadeada, de forma 
		 * que cada elemento tem acesso r�pido ao seguinte e ao anterior.
		 * Essa � uma outra desvantagem, j� que para armazenar um elemento � preciso dispor do 
		 * espa�o de mem�ria do mesmo + refer�ncia ao anterior + referencia ao pr�ximo, 
		 * bem como outras refer�ncias usadas pela lista, como um ponteiro para o primeiro e para o �ltimo elemento.
		 * 
		 * Ou seja, o gasto � quantidade de elementos * (tamanho de mem�rio preciso + duas referencias) + duas referencias
		 *  
		 */
		Lista lista = new Lista();
		for(int i = 0; i < 10; i++){
			System.out.println("Adicionando o item("+i+") � lista");
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
		System.out.println("Novo elemento do indice 5 �: " + novoElementoNoIndice5);
		System.out.println("Tamanho atual:"+lista.getTamanho());
		
	}
	
}
