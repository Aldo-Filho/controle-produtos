# Controle de Produtos

API para cadastro e controle de produtos, feita com Java e Spring Boot.

## Requisitos

- Java 21
- PostgreSQL

## Como rodar

1. Crie um banco PostgreSQL chamado `products`.
2. Confira as credenciais em `src/main/resources/application.yaml`. Por padrão, a aplicação usa `localhost:5432`, usuário `postgres` e senha `1234`.
3. Na pasta do projeto, execute:

```powershell
./mvnw.cmd spring-boot:run
```

O Flyway cria a tabela necessária ao iniciar a aplicação. A API ficará disponível em `http://localhost:8080`.
