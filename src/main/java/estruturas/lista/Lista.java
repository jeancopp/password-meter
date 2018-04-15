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
		if(this.emBranco()){
			comeco = novo;
			fim = novo;
		}
		novo.setAnterior(fim);
		fim.setProximo(novo);
		
		this.fim = novo;
		tamanho ++;
	}
	
	
	
	public Integer retornar(int indiceDoElemento) {
		Elemento elementoBuscado = buscarElemento(indiceDoElemento);
		return (null == elementoBuscado) ? null : elementoBuscado.getValor();
	}

	private Elemento buscarElemento(int indiceDoElemento) {
		if( tamanho < indiceDoElemento ) return null;
		Elemento elementoBuscado = comeco;
		for(int i = 0; i < indiceDoElemento; i++) elementoBuscado = elementoBuscado.getProximo();
		return elementoBuscado;
	}

	public Integer remover(int indiceDoElemento) {
		Elemento elementoBuscado = buscarElemento(indiceDoElemento);
		if(null == elementoBuscado) return null;
		
		Elemento anterior = elementoBuscado.getAnterior();
		Elemento proximo = elementoBuscado.getProximo();
		
		anterior.setProximo(proximo);
		proximo.setAnterior(anterior);
		
		elementoBuscado.setAnterior(null);
		elementoBuscado.setProximo(null);
		tamanho--;
		
		return elementoBuscado.getValor();
	}

	public void mostrarOPrimeiro() {
		System.out.println( this.emBranco() ? "Não há elementos na lista" : "Primeiro elemento:"+comeco.getValor());
	}
	private boolean emBranco() {
		return this.tamanho == 0;
	}

	public void mostrarOUltimo() {
		System.out.println( this.emBranco() ? "Não há elementos na lista" : "Ultimo elemento:"+fim.getValor());
	}

	public Integer getTamanho() {
		return tamanho;
	}
	
}
