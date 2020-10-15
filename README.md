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


## Endpoint

- query: Coordenada geográfica usada como parâmetro de busca para as UBSs mais próximas
- per_page: define a quantidade de registros por página
- page: define a página atual de retorno

```
https://buiatti-geoubs-backend.herokuapp.com/api/v1/find_ubs?query=-3.745584,20-38.489624&page=2&per_page=1
```

&nbsp;

## Executando o back-end com docker


```
cd backend

mvn clean package dockerfile:build 

docker-compose up
```
Acessando:
- http://localhost:8090/api/v1/find_ubs?query=-3.745584,%20-38.489624&page=1&per_page=1

&nbsp;



## Executando o front-end


```
cd frontend

npm i && npm start
```
Acessando:
- http://localhost:3000


&nbsp;

## Deploy no Heroku

Projeto front-end feito deploy no heroku

- https://buiatti-geoubs-frontend.herokuapp.com


Projeto back-end feito deploy no heroku


- https://buiatti-geoubs-backend.herokuapp.com/api/v1/find_ubs?query=-3.745584,%20-38.489624&page=2



&nbsp;

## Deploy na Digital Ocean 

Projeto back-end feito deploy na Digital Ocean

- http://165.227.127.44:8090/api/v1/find_ubs?query=-3.745584,%20-38.489624&page=2

