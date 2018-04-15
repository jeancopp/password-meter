package estruturas.lista;

public class ExemploLista {
	
	public static void main(String[] args) {
		
		Lista lista = new Lista();
		for(int i = 0; i < 10; i++)
			lista.adicionar(new Integer(i));
		
		int elemento = lista.retornar(50);
		System.out.println(elemento);
		
		int elementoRemovido = lista.remover(50);
		System.out.println(elementoRemovido);
		
		int novoElementoNoIndice50 = lista.retornar(50);
		System.out.println(novoElementoNoIndice50);
		
	}
	
}
