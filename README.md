### Stack
- Java 8+
- Spring Boot
- Spring Batch

### O que é ?
Aplicação que consume um arquivo "produtos.csv", utilizando Spring Batch.
Ao rodar o projeto, irá criar automaticamente uma base de dados, em um banco H2.
Criei também 2 @Scheduled, 
Um @Scheduled é responsável por processar o Job que processa o arquivo "produtos.csv", 
Já o outro @Scheduled é reponsável por cadastrar um produto, conforme dados processados do CSV. 

### Como rodar ?
- Execute **`mvn clean package`**
- Execute **`mvn spring-boot:run`**

### Acesso a base de dados:

> **Login**\
> http://localhost:8080/h2-console\

![](https://github.com/lucianoortizsilva/schedule-springbatch/blob/master/src/main/resources/static/github/h2-login.jpg)

> **Tabelas Geradas**\

![](https://github.com/lucianoortizsilva/schedule-springbatch/blob/master/src/main/resources/static/github/h2-tabelas_geradas.jpg)
