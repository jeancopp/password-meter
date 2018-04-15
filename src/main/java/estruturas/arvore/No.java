package estruturas.arvore;

public class No {
	
	private Integer valor;
	private No menor;
	private No maior;
	
	public No(Integer valor) {
		this.valor = valor;
		this.menor = null;
		this.maior = null;
	}
	
	public No getMenor() {
		return menor;
	}
	public void setMenor(No menor) {
		this.menor = menor;
	}
	public No getMaior() {
		return maior;
	}
	public void setMaior(No maior) {
		this.maior = maior;
	}
	
	public Integer getValor() {
		return valor;
	}

	public void adicionar(Integer elementoNovo) {
		if( this.valor > elementoNovo ){
			if(this.menor == null) this.menor = new No(elementoNovo);
			else this.menor.adicionar(elementoNovo);
		}else {
			if(this.maior == null) this.maior = new No(elementoNovo);
			else this.maior.adicionar(elementoNovo);
		}
	}

	@Override
	public String toString() {
		return "No [valor=" + valor + ", menor=" + menor + ", maior=" + maior + "]";
	}

	
	
	
}
