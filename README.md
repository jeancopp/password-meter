# password-meter

Calculo de pontuação da senha.

Foi desenvolvido baseado no site: http://www.passwordmeter.com/

Para executar, faça clone do projeto e rode via maven.
A aplicação funciona por default na porta 8080, sendo acessada por http://localhost:8080/

A api está disponível para acesso em: http://localhost:8080/password/score?pass=SENHA, onde SENHA deverá ser informado.
O retorno da api é dado no formato:
{
  "score": Integer(Range: 0-100),
  "complexity": Enum("Muito Curta","Muito Fraca","Fraca","Boa","Forte","Muito Forte"),
  "incremental": Integer,
  "descremental": Integer
}
