# COVID ANÁLISE DATA APP

Aplicação com banco e API com análises em cima de dados da Covid-19 no Brasil. Feita para treinamento de conceitos de TDD (a princípio).

## Base de dados

A base de dados foi extraída de um csv baixado do Dataset do [Brasil.IO](https://brasil.io/dataset/covid19/caso_full/), que contém os casos confirmados e óbitos obtidos dos boletins das Secretarias Estaduais de Saúde (SES).

## Tecnologias Utilizadas

* Docker
* Java com Spring Boot (API)
* JUnit com Mockito (Testes na API)
* PostgreSQL (Banco de dados)

## Objetivo da API

A API deve fornecer uma análise em cima da base de dados da Covid-19, fornecendo:

* Análise das Mortes confirmadas, a partir da média móvel das últimas duas semanas.
* Análise dos Casos confirmados, a partir da média móvel das últimas duas semanas.

Podendo estar em tendência de alta ou baixa, caso tenha uma variação acima de 15%, ou em estabilidade.
