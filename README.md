## CRUD PROJECT
- Projeto para implementação de um crud para um sistema de  web service REST.

## REQUISIÇÕES 

### Busca de cliente por id
- GET /clients/1

### Busca paginada de clientes
- GET /clients?page=0&size=6&sort=name

### Inserção de novo cliente
- POST /clients
 ``` 
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20",
  "children": 2
}   
``` 
### Atualização de cliente
- POST /clients/1
 ``` 
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20",
  "children": 2
}   
``` 

### Deleção de cliente
- DELETE /clients/1

## Tecnologias utilizadas:

### Linguagem
- JAVA - Versão 17;
### Framework
- Springboot - Versão 3.1.0;

### IDE
- Intellij

### Teste de requisições
- Postman

### Banco de dados
- H2