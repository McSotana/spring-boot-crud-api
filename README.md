Sobre o Projeto

Este projeto é uma API RESTful desenvolvida em Java com o framework Spring Boot. A aplicação implementa as quatro operações básicas de um CRUD (Create, Read, Update, Delete) para gerenciar uma entidade de "Produtos". Ela utiliza o Spring Data JPA para a persistência de dados em um banco de dados PostgreSQL.
Este repositório foi criado como um exemplo prático para demonstrar as habilidades fundamentais no desenvolvimento de back-end com o ecossistema Spring, servindo como um excelente ponto de partida para projetos mais complexos e como uma peça de portfólio.

Funcionalidades

[x] Criar um novo produto.
[x] Ler a lista de todos os produtos cadastrados.
[x] Ler um produto específico pelo seu ID.
[x] Atualizar as informações de um produto existente.
[x] Deletar um produto do banco de dados.

Tecnologias Utilizadas:

Java 17: Linguagem de programação principal.
Spring Boot: Framework para criação de aplicações stand-alone.
Spring Web: Módulo para construir aplicações web, incluindo APIs REST.
Spring Data JPA: Para facilitar a persistência de dados e a comunicação com o banco.
Hibernate: Implementação do JPA utilizada pelo Spring Data.
PostgreSQL: Banco de dados relacional para armazenamento dos dados.
Maven: Ferramenta para gerenciamento de dependências e build do projeto.

Como Executar o Projeto

Pré-requisitos:

Java JDK 17 ou superior.
Maven.
PostgreSQL.
Um cliente de API como o Postman para testar os endpoints.

Passos

Clone este repositório:
Bash
git clone https://github.com/[seu-usuario]/spring-boot-crud-api.git
Navegue até o diretório do projeto:
Bash
cd spring-boot-crud-api
Configure o banco de dados:
Crie um novo banco de dados no seu PostgreSQL. Ex: crud_api_db.
Configure as variáveis de ambiente:
Abra o arquivo src/main/resources/application.properties.
Altere as propriedades spring.datasource.url, spring.datasource.username e spring.datasource.password com as suas credenciais do PostgreSQL.

Properties

# Exemplo de configuração
spring.datasource.url=jdbc:postgresql://localhost:5432/crud_api_db
spring.datasource.username=postgres
spring.datasource.password=sua_senha_secreta
Execute a aplicação:

Você pode executar diretamente pela sua IDE (ex: IntelliJ, Eclipse) encontrando a classe CrudApiApplication.java e rodando o método main.

Endpoints da API

A tabela abaixo descreve os endpoints disponíveis na API:
Método HTTP
Endpoint
Descrição
Exemplo de Corpo (Body)
POST
/api/produtos
Cria um novo produto.

{ "nome": "Teclado Mecânico", "descricao": "RGB, Switch Blue", "preco": 350.00 }
GET
/api/produtos
Retorna a lista de todos os produtos.
N/A
GET
/api/produtos/{id}
Retorna um produto específico pelo ID.
N/A
PUT
/api/produtos/{id}
Atualiza um produto existente pelo ID.
{ "nome": "Teclado Mecânico Pro", "descricao": "RGB, Switch Red, ABNT2", "preco": 450.00 }
DELETE
/api/produtos/{id}
Deleta um produto pelo ID.
N/A
