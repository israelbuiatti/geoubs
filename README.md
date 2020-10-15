## Descrição

Sistema de geolocalização de UBS. 

Este sistema tem como objetivo retornar a lista de UBSs mais próximas da localização fornececida, conforme exemplo abaixo:


<p align="center">
<img src="http://buiatte.com.br/geoubs.png">
</p>


Este projeto foi desenvolvido com Spring Boot no seu backend e React Js no seu frontend. Foi utilizando o flyway para criação das tabelas e inserção dos dados necessários para o uso do sistema.

A base de dados foi extraída do site https://dados.gov.br/dataset/unidades-basicas-de-saude-ubs




## Pré requisito
- Maven 3
- Java 8+
- Docker 1.13.0+
- Node 10+

&nbsp;


## Executando o projeto


```
mvn clean package

java -jar target/dbc-spring-bach-0.0.1-SNAPSHOT.jar file=file/dados.csv

```


