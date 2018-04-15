package estruturas.arvore;

import java.util.function.BiConsumer;

public class PosOrder implements Visitor {

	@Override
	public void visitar(No no, BiConsumer<No,Integer> consumer) {
		System.out.println("Visitando PosOrder");
		this.visitar(no, consumer,0);
	}
	
	private void visitar(No no, BiConsumer<No,Integer> consumer, int camada) {
		if(no != null){
			visitar(no.getMenor(),consumer,camada+1);
			visitar(no.getMaior(),consumer,camada+1);
			consumer.accept(no,camada);
		}
	}



}
