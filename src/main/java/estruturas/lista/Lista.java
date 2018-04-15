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
		
		fim.setProximo(novo);
		novo.setAnterior(novo);
		
		if(comeco == null) comeco = novo;
		
		fim = novo;
		tamanho ++;
	}
	
	
	
	public Integer retornar(int indiceDoElemento) {
		if( tamanho < indiceDoElemento ) return null;
		return 0;
	}

	public Integer remover(int indiceDoElemento) {
		return 0;
	}
	
}
