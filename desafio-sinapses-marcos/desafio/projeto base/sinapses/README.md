# Sinapses API 🧠

## Índice
1. [Sobre o Projeto](#sobre-o-projeto)
2. [Tecnologias Utilizadas](#tecnologias-utilizadas)
3. [Conceitos Abordados](#conceitos-abordados)
4. [Exemplos de Endpoints da API](#exemplos-de-endpoints)
5. [Documentação Interativa](#documentação-com-swagger)

## Sobre o Projeto
'Sinapses API' trata-se de uma aplicação CRUD sobre revisões de estudos de alunos. A partir desta API, um aluno pode se cadastrar e, a partir da inserção de sua matrícula gerada, o estudante terá algumas funcionalidades disponíveis, como:

- Criar uma sinapse; 
- Acessar apenas as suas sinapses salvas;
- Filtrar por categoria, palavra-chave e data de criação;
- Pegar sinapse por ID;
- Editar;
- Remover;

## Tecnologias Utilizadas 
- **Framework**: Spring Boot 3.4.1;.
- **Banco de Dados**: PostgreSQL 18.1.
---
- **Postman**: Para testes da API e documentação dela.
- **Flyway**: Gerenciamento das tabelas e colunas do banco de dados.n
- **Mapstruct**: Administração de conversões entre DTO's e Entity.

## Conceitos Abordados
- Estrutura MVC de pastas;
- Anotações do Hibernate para indicação de tabelas e colunas;
- Utilização de métodos do JPA para a execução da regra de negócios no banco de dados;
- Anotações do Spring Web para a conexão da api com o usuário;
- Requisições e respostas ao usuário a partir de DTO's, escondendo a entidade de dados.

## Exemplos de Endpoints
Para o gerenciamento de suas sinapses, primeiro, você deve criar um aluno e, depois, sendo-lhe mostrado sua matrícula:

### **Criar um novo educando**
`POST /alunos`

**Response (JSON):**
```http
POST /alunos
Content-Type: application/json

{
    "nome": "Maria",
    "matricula": "2026-0005"
}
```
---
Após a matrícula, o aluno poderá a utilizar na URL para, desta forma, poder acessar os métodos pertencentes à sinapse:

### **Criar uma nova sinapse**
`POST /{matricula}/sinapses`

**Request (JSON):**
```http
POST /2026-0005/sinapses
Content-Type: application/json

{
    "titulo": "Estudo do mapstruct",
    "descricao": "utilização da dependência de gerenciamento de conversões e retornos de DTO",
    "categoria": "Java",
    "urlConteudo": "guiadev.com"
}
```

**Response (JSON):**
```http
POST /2026-0005/sinapses
Content-Type: application/json

{
    "id": 10,
    "matricula": "2026-0005",
    "titulo": "Estudo do mapstruct",
    "descricao": "utilização da dependência de gerenciamento de conversões e retornos de DTO",
    "categoria": "Java",
    "dataCriacao": "2026-01-06",
    "ultimaAtualizacao": "2026-01-06",
    "urlConteudo": "guiadev.com"
}
```

## Documentação com Swagger

A API possui documentação interativa que permite testar os endpoints diretamente pelo navegador.

1. Inicie a aplicação Spring Boot
2. Acesse o link: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Nesta interface, você poderá visualizar todos os métodos HTTP, modelos de Request/Response e códigos de status tratados.