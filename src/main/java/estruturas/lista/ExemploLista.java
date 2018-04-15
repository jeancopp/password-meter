package estruturas.lista;

public class ExemploLista {
	
	public static void main(String[] args) {
		
		Lista lista = new Lista();
		for(int i = 0; i < 10; i++)
			lista.adicionar(new Integer(i));
		
		int elemento = lista.retornar(5);
		System.out.println(elemento);
		
		int elementoRemovido = lista.remover(5);
		System.out.println(elementoRemovido);
		
		int novoElementoNoIndice5 = lista.retornar(5);
		System.out.println(novoElementoNoIndice5);
		
	}
	
}
