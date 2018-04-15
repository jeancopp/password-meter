package estruturas.arvore;

public class ArvoreBinaria {
	private No raiz;
	private int tamanho;
	
	public ArvoreBinaria() {
		raiz = null;
		tamanho = 0;
	}
	
	public void adicionar(Integer elemento){
		if( raiz == null ){
			raiz = new No(elemento);
		}else{
			raiz.adicionar(elemento);
		}
		tamanho++;
	}
	
	public No getRaiz() {
		return raiz;
	}

	@Override
	public String toString() {
		return "ArvoreBinaria [raiz=" + raiz + ", tamanho=" + tamanho + "]";
	}
	
	
}
