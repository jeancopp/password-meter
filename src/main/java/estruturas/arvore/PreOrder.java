package estruturas.arvore;

import java.util.function.BiConsumer;

public class PreOrder implements Visitor {

	@Override
	public void visitar(No no, BiConsumer<No,Integer> consumer) {
		System.out.println("Visitando PreOrder");
		this.visitar(no, consumer, 0);
	}
	
	private void visitar(No no, BiConsumer<No,Integer> consumer, int camada) {
		if(no != null){
			consumer.accept(no,camada);
			visitar(no.getMenor(),consumer,camada+1);
			visitar(no.getMaior(),consumer,camada+1);
		}
	}

}
