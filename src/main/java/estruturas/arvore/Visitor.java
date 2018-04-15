package estruturas.arvore;

import java.util.function.BiConsumer;

public interface Visitor {

	void visitar(No no, BiConsumer<No,Integer> consumer);

}
