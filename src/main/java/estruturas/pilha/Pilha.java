package estruturas.pilha;

public class Pilha {
	private int topo;
	private Integer[] elementos;
	private int tamanhoDaPilha;
	
	public Pilha(int tamanhoDaPilha) {
		this.tamanhoDaPilha = tamanhoDaPilha;
		this.elementos = new Integer[tamanhoDaPilha];
		this.topo = -1;
	}
	
	
	public void push(Integer item) {
		if(topo + 1 == tamanhoDaPilha){
			System.out.println("N�o � poss�vel adicionar esse elemento. Tamanho da pilha � " + tamanhoDaPilha);
		}else { 
			elementos[++topo] = item;
		}
	}
	
	public Integer pop() {
		return  this.pilhaEmBranco() ? null : elementos[topo--];
	}

	public void mostrarTopo() {
		System.out.println(this.pilhaEmBranco() ? "N�o h� elementos na pilha" : "Elemento no topo da lista:" +  elementos[topo]);
	}


	private boolean pilhaEmBranco() {
		return topo == -1;
	}
	
	

}
