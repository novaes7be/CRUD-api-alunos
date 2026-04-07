 #  API de Alunos (CRUD) - Spring Boot + Docker

Este projeto foi desenvolvido como parte da jornada de aprendizado em desenvolvimento backend com Java, com foco em construção de APIs REST utilizando boas práticas de mercado.

A proposta foi criar uma API simples, porém estruturada, capaz de realizar operações básicas de cadastro de usuários (CRUD), utilizando uma arquitetura organizada e preparada para evolução.

---

##  Objetivo

Construir uma API backend completa que permita:

•⁠  ⁠Criar usuários
•⁠  ⁠Listar usuários
•⁠  ⁠Atualizar usuários
•⁠  ⁠Excluir usuários

Além disso, o projeto foi pensado para:

•⁠  ⁠Rodar localmente de forma simples
•⁠  ⁠Utilizar banco relacional (PostgreSQL)
•⁠  ⁠Integrar com MongoDB (exploração futura)
•⁠  ⁠Ser executado com Docker

---

##  Tecnologias utilizadas

•⁠  ⁠Java 17+
•⁠  ⁠Spring Boot
•⁠  ⁠Spring Web
•⁠  ⁠Spring Data JPA
•⁠  ⁠PostgreSQL
•⁠  ⁠MongoDB
•⁠  ⁠Docker / Docker Compose
•⁠  ⁠Maven

---

## 🏗️ Arquitetura

O projeto segue uma separação clássica de camadas:
  controller → recebe requisições HTTP
  service → regras de negócio
  repository → acesso ao banco
  model → entidades
  dto → transferência de dados
  exception → tratamento global de erros
  
 Essa estrutura facilita manutenção, testes e evolução.

---

## ⚙️ Como rodar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/novaes7be/CRUD-api-alunos.git
cd api-alunos
```

### 2.⁠ ⁠Subir os bancos com Docker
```bash
   docker compose up -d
```
 Isso irá subir:
  PostgreSQL → porta 5433
  MongoDB → porta 27018
  Mongo Express → porta 8083
   ./mvnw spring-boot:run

3.⁠ ⁠Rodar a aplicação

```bash
  ./mvnw spring-boot:run
```
   ou
```bash
mvn spring-boot:run
```
