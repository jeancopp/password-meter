package estruturas.lista;

public class Elemento {

	private Integer valor;
	private Elemento proximo;
	private Elemento anterior;

	public Elemento(Integer valor) {
		this.valor = valor;
	}

	public void setProximo(Elemento proximo) {
		this.proximo = proximo;

	}

	public void setAnterior(Elemento anterior) {
		this.anterior = anterior;
	}

	public Integer getValor() {
		return valor;
	}

	public Elemento getProximo() {
		return proximo;
	}

	public Elemento getAnterior() {
		return anterior;
	}
	
}