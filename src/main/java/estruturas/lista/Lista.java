package estruturas.lista;

public class Lista {

	private Elemento comeco;
	private Elemento fim;
	private int tamanho; 
	
	public Lista() {
		tamanho = 0;
		comeco = null;
		fim = null;
	}
	
	public void adicionar(Integer valor) {
		Elemento novo = new Elemento(valor);
		
		if(fim == null) fim = novo;
		
		fim.setProximo(novo);
		novo.setAnterior(fim);
		
		if(comeco == null) comeco = novo;
		
		fim = novo;
		tamanho ++;
	}
	
	
	
	public Integer retornar(int indiceDoElemento) {
		if( tamanho < indiceDoElemento ) return null;
		Elemento elementoBuscado = comeco;
		for(int i = 0; i < indiceDoElemento; i++) elementoBuscado = elementoBuscado.getProximo();
		
		return elementoBuscado.getValor();
	}

	public Integer remover(int indiceDoElemento) {
		return 0;
	}
	
}
