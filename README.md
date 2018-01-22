# password-meter

Calculo de pontuação da senha.

Foi desenvolvido baseado no site: http://www.passwordmeter.com/
Para executar, faça clone do projeto e rode via maven.
A aplicação funciona por default na porta 8080, sendo acessada por http://localhost:8080/

A api está disponível para acesso em: http://localhost:8080/password/score?pass=SENHA, onde SENHA deverá ser informado.
O retorno da api é dado no formato:
```
{
  "score": Integer(Range: 0-100),
  "complexity": Enum("Muito Curta","Muito Fraca","Fraca","Boa","Forte","Muito Forte"),
  "incremental": Integer,
  "descremental": Integer
}
```
----------------------------------------------------------------------------------------------------------------------------
# Mestre dos Códigos - Respostas:

Q.1) **Criar uma aplicação que utilize Orientação a Objetos, demonstrando no código o porquê da escolha de pelo menos 3 design patterns, e onde foi aplicado os principios SOLID na aplicação;**

Resposta:
1. Design Patterns:
  *	A interface ScoreApplication é uma aplicação da pattern Template Method, ficando a cabo dos descendentes preencherem os "buracos" deixados pela mesma;
  *	As classes DecrementalScoreFacade e IncrementalScoreFacade são façades/fachadas para classes de cálculo de pontuação, tanto incremental quanto decremental; 
  *	A aplicação faz uso do padrão DTO para transitar as informações para o front da aplicação; 
  *	Para implementações mais simples de calculadores, o código foi refatorado, dando origem a factorys;
  *	As classes SimpleDescrementalScoreCalculatorFactory e  SimpleIncrementalScoreCalculatorFactory são também Singletons;
2. SOLID:
  *	Na camada de API da aplicação é possível observar os princípios SRP e DIP sendo respeitados. 
  *	Na camada de DTO, é possível observar o princípio OCP sendo seguido, através do uso de templates da linguagem;
  *	As facades da aplicação respeitam o LSP. 
  *	A classe MoreOf3Sequential e um exemplo que respeita o SRP, o OCP, LSP e o ISP. 
-----
Q.4) **Criar uma aplicação que faça uso da injeção de dependências, tanto de interfaces quanto classes concretas, com injeção de implementações especificas com base no ambiente em que a aplicação está rodando.**

Resposta:
*	A aplicação injeta as dependências da classe ScoreFacade, injetando através do uso de rótulos para diferenciar uma da outra, já que ambas são a mesma abstração;
*	A aplicação injeta dependências de classes concretas nos façades DecrementalScoreFacade e IncrementalScoreFacade;
*	Foram criados dois profiles, prod e dev, e para cada um, é injetado um tipo de dependência no façade DecrementalScoreFacade, sendo um definido através do arquivo .properties referente de cada profile um definido através da notação @Profile(vide as classes: AmericanLetterOnlyScoreCalculator e RussianLetterOnlyScoreCalculator)
-----
Q.14) **Criar uma funcionalidade que faça o uso de regex para validação e busca de informações dentro de entrada de dados fornecidas pelo usuário;**

Resposta:
Aplicação faz uso de regex para verificar os caracteres da senha informada, vide as classes: 
 * MoreOf3Sequential; 
 * Consecutive;
 * LetterCaseParser;  e 
 * MiddleNumbersOrSymbolsFlat.

-----
