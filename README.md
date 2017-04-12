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
-----------------------------------------------------------------------------------------------------------------------------
Password score Calculation.

Was developed with base on website: http://www.passwordmeter.com/
To execute, do clone of the project and run in with maven.
The application will run on port 8080 by default, and will can be access in http://localhost:8080/

The api will be enabled for access in http://localhost:8080/password/score?pass=PASSWORD where PASSWORD needs to be infomated.
The return of Api will be in the format:
```
{
  "score": Integer(Range: 0-100),
  "complexity": Enum("Muito Curta","Muito Fraca","Fraca","Boa","Forte","Muito Forte"),
  "incremental": Integer,
  "descremental": Integer
}
```
