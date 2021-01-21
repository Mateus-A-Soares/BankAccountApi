# BankAccountApi
  API RESTful desenvolvida para o desafio da segunda etapa do processo seletivo do programa de treinamento Orange Talents, oferecido pela empresa Zup Innovation.

-----------------------------------

## PRÉ REQUISITOS
* Porta 8080 liberada para rodar a aplicação;  
  (A porta pode ser alterada em BankAccountApi\src\main\resources\application.properties)
* Porta 3306 da máquina local configurada para conexão com banco de dados MySQL;  
  (A porta e a máquina também podem ser alteradas em BankAccountApi\src\main\resources\application.properties)
* Usuário root no banco de dados cadastrado com senha root132;  
  (Também pode ser alterado em BankAccountApi\src\main\resources\application.properties)
* JDK instalada e variável de ambiente JAVA_HOME configurada;

## CONFIGURAÇÃO
  Depois de clonar, abra a linha de comando do seu sistema operacional no diretório do projeto e digite: 
```
mvnw spring-boot:run
```
  Espere o plugin maven carregar as dependências utilizadas e colocar a aplicação dentro de um web container, depois que terminar a aplicação estará rodando na porta configurada.
