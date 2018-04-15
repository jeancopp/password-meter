package estruturas.pilha;

public class ExemploPilha {
	
	public static void main(String[] args) {
		Pilha p = new Pilha(5);
		/* 
		 * Uma pilha � uma estrutura do LIFO, que � um acromono para Last In, First Out, ou seja, �ltimo a inserir, primeiro a sair.
		 * A estrutura de dados do tipo pilha � uma estrutura que permite acesso apenas ao �ltimo elemento.
		 * 
		 * A conven��o em torno dessa estrutura de dados � que ela � acessada e manipulada atrav�s de dois m�todos, o push e o pop.
		 * O primeiro � ter� por responsabilidade receber um valor e coloca-l� no topo da pilha.
		 * Dessa forma, e apenas dessa nessa implementa��o, t�m-se acesso � algum valor. 
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
		
		/* O segundo m�todo, o pop, � o respons�vel por retirar o valor do topo pilha*/
		Integer valorRetiradoDaPilha = p.pop();
		/* Aqui iremos exibir o 14, que � o mesmo elemento exibido anterioremente atrav�s do m�todo "mostrarTopo"*/
		System.out.println("Elemento retirado do topo da lista:" +valorRetiradoDaPilha);
		
		/*Ao exibirmos o topo novamente, nossa sa�da � agora o 13*/
		p.mostrarTopo();
		
		/* Obviamente, o exemplo aqui � muito simplorio, mostrando apenas as caracteristiscas principais da pilha.
		 * 
		 * Esta estrutura � usada, por exemplo, para realizar processamento. 
		 * Este pr�prio c�digo, ao ser executado, far� uso do conceito de pilha, de forma que,
		 * ao executarmos o push, a m�quina virtual passa a executar o c�digo de dentro do m�todo push abaixo e, quando concluir, retornar� para c�.
		 * 
		 * Um ganho da pilha, frente a outras estrutura, � que o foco passa ser apenas no que est� no topo, e pelo fato que h� apenas um elemento abaixo do topo.
		 * Retirou-se o elemento do topo para realizar a a��o, s� haver� um para tornar-se o novo topo. Tal ponto � importante de ressalva j� que a estrutura Heap 
		 * se assemelha-se, j� que o topo � o elemento mais importante, mas � necess�rio avaliar os candidatos abaixo para definir qual ser� o pr�ximo topo
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
