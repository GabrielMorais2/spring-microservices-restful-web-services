# Spring Microservices - REST + Spring Boot

Este é um projeto de exemplo de uma API RESTful desenvolvida com o Spring Boot, que permite gerenciar informações de usuários. A API foi criada para demonstrar boas práticas de desenvolvimento e arquitetura, bem como o uso de recursos como mapeamento de entidades e DTOs, validação de dados e tratamento de exceções.

## Tecnologias
- Java 17
- Spring Boot 3
- Maven
- H2
- Hibernate
- Lombok

## Pré-requisitos

- Java 17 ou superior
- Maven 3.6.x ou superior

## Configuração

1. Clone o repositório do projeto.
```shell
git clone https://github.com/GabrielMorais2/spring-microservices-restful-web-services.git
```
2. Navegue até o diretório do projeto.
```shell
cd rest-web-services
```
4. Execute o comando Maven para compilar e empacotar o projeto.
```shell
mvn clean package
```
5. Execute o comando Maven para iniciar o aplicativo Spring Boot.
```shell
mvn spring-boot:run
```
6. O aplicativo estará disponível em http://localhost:8080.

## Endpoints da API

GET /users/{id}: Retorna um usuário específico com base no ID fornecido.

GET /users: Retorna uma lista com todos os usuários cadastrados.

POST /users: Cria um novo usuário com base nos dados fornecidos no corpo da requisição.

DELETE /users/{id}: Exclui o usuário com o ID fornecido.

## Contribuição

Sinta-se à vontade para contribuir com novas funcionalidades, correções de bugs ou melhorias neste projeto. Faça um fork deste repositório, faça suas alterações e envie um pull request.

Esperamos que este projeto de exemplo possa ser útil para você aprender sobre o desenvolvimento de APIs RESTful com o Spring Boot e outras tecnologias relacionadas. Se tiver alguma dúvida, não hesite em entrar em contato.
