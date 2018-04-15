package estruturas.pilha;

public class ExemploPilha {
	
	public static void main(String[] args) {
		Pilha p = new Pilha(5);
		/* 
		 * Uma pilha é uma estrutura do LIFO, que é um acromono para Last In, First Out, ou seja, último a inserir, primeiro a sair.
		 * A estrutura de dados do tipo pilha é uma estrutura que permite acesso apenas ao último elemento.
		 * 
		 * A convenção em torno dessa estrutura de dados é que ela é acessada e manipulada através de dois métodos, o push e o pop.
		 * O primeiro é terá por responsabilidade receber um valor e coloca-lô no topo da pilha.
		 * Dessa forma, e apenas dessa nessa implementação, têm-se acesso à algum valor. 
		 */
		p.mostrarTopo();
		
		p.push(10);
		p.mostrarTopo();
		p.push(11);
		p.mostrarTopo();
		p.push(12);
		p.mostrarTopo();
		p.push(13);
		p.mostrarTopo();
		p.push(14);
		p.mostrarTopo();

		p.push(15);
		p.mostrarTopo();
		
		/* O segundo método, o pop, é o responsável por retirar o valor do topo pilha*/
		Integer valorRetiradoDaPilha = p.pop();
		/* Aqui iremos exibir o 14, que é o mesmo elemento exibido anterioremente através do método "mostrarTopo"*/
		System.out.println("Elemento retirado do topo da lista:" +valorRetiradoDaPilha);
		
		/*Ao exibirmos o topo novamente, nossa saída é agora o 13*/
		p.mostrarTopo();
		
		/* Obviamente, o exemplo aqui é muito simplorio, mostrando apenas as caracteristiscas principais da pilha.
		 * 
		 * Esta estrutura é usada, por exemplo, para realizar processamento. 
		 * Este próprio código, ao ser executado, fará uso do conceito de pilha, de forma que,
		 * ao executarmos o push, a máquina virtual passa a executar o código de dentro do método push abaixo e, quando concluir, retornará para cá.
		 * 
		 * Um ganho da pilha, frente a outras estrutura, é que o foco passa ser apenas no que está no topo, e pelo fato que há apenas um elemento abaixo do topo.
		 * Retirou-se o elemento do topo para realizar a ação, só haverá um para tornar-se o novo topo. Tal ponto é importante de ressalva já que a estrutura Heap 
		 * se assemelha-se, já que o topo é o elemento mais importante, mas é necessário avaliar os candidatos abaixo para definir qual será o próximo topo
		 */
		
		p.pop();
		p.mostrarTopo();
		
		p.pop();
		p.mostrarTopo();
		
		p.pop();
		p.mostrarTopo();
		
		p.pop();
		p.mostrarTopo();

	}
}
