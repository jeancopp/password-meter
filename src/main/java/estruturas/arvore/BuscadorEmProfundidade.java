package estruturas.arvore;

public class BuscadorEmProfundidade {

	public void buscar(int valorBuscador, No no) {
		this.buscar(valorBuscador, no, 0);
	}

	private void buscar(int valorBuscador, No no, int camada) {
		String tracos = new String(new char[camada]).replace("\0", "-");
		if (no.getValor() == valorBuscador) {
			System.out.println(tracos+"Elemento encontrado com "+camada+" salto(s)");
		}else if (valorBuscador < no.getValor() ){
			System.out.println(tracos+"Buscando elemento nos itens menores do no("+no.getValor()+")");
			buscar(valorBuscador, no.getMenor(), camada+1);
		}else{
			System.out.println(tracos+"Buscando elemento nos itens maiores do no("+no.getValor()+")");
			buscar(valorBuscador, no.getMaior(), camada+1);
			
		}
	}

}
