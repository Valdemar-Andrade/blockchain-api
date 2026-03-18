# API Blockchain (Spring Boot)

Este projeto é uma versão refatorada de uma implementação blockchain anterior, agora redesenhada como uma API REST utilizando Spring Boot e práticas modernas de arquitetura de backend.

O objetivo deste projeto é demonstrar como uma implementação conceptual de blockchain pode evoluir para um serviço de backend estruturado com camadas claras, validação, documentação e facilidade de manutenção.

## Versão Anterior

Este projeto foi originalmente implementado como um protótipo de blockchain em Java independente.

Repositório original:
- [BlockChain](https://github.com/Valdemar-Andrade/BlockChain)

A versão atual refatora esta implementação numa API de backend com estilo de produção.

---

# Arquitetura

O projeto segue uma arquitetura por camadas comummente utilizada em aplicações Spring Boot.

src/main/java/com/projeto1/blockchainapi
```
├── controller
├── config
├── service
├── model
├── dto
├── exception
└── mapper
```
### Responsabilidades

**Controlador**

Lida com pedidos e respostas HTTP.

**Serviço**

Contém a lógica de negócio para as operações blockchain.

**Modelo**

Objetos principais do domínio blockchain, tais como:

- Bloco
- Transação
- Blockchain

**DTO**

Utilizado para transferir dados entre a API e o cliente.

**Exceção**

Tratamento centralizado de erros utilizando `@ControllerAdvice`.

**Configuração**

Configuração Swagger/OpenAPI.

---

# Endpoints da API

### Criar Transação
POST /api/transacoes

Adiciona uma transação à lista de transações pendentes.

Exemplo de requisição:
{"sender": "Alice",
"recipient": "Bob",
"quantidade": 10
}

---

### Bloco Minerar
POST /api/mineracao

Cria um novo bloco ao minerar as transações pendentes.

---

### Obter Blockchain
GET /api/blockchain

Retorna a blockchain completa.

---

### Validar Chain
GET /api/blockchain/validate

Verifica se a blockchain é válida.

---

# Tecnologias Utilizadas

- Java
- Spring Boot
- Maven
- API REST
- Validação de Feijão
- OpenAPI/Swagger
- Registo de logs (SLF4J)

---

# Funcionalidades Implementadas

- Lógica central do Blockchain
- Sistema de transações
- Mecanismo de mineração
- Validação da cadeia
- Camada API RESTful
- Validação de DTO
- Tratamento global de exceções
- Documentação da API com Swagger

---

# Documentação do Swagger

Após iniciar a aplicação, aceda a:
http://localhost:8080/swagger-ui/index.html

Este fornece uma interface interativa para testar os endpoints da API.

---

# Executar o Projeto

Clone o repositório:
git clone https://github.com/Valdemar-Andrade/blockchain-api

Execute a aplicação:
mvn spring-boot:run

---

# Objetivos de Aprendizagem

Este projeto foi criado como um exercício de aprendizagem para praticar:

- Arquitetura de backend
- Design de API limpo
- Refactorização de código legado
- Aplicação das melhores práticas de engenharia
- Transformação de protótipos algorítmicos em serviços reais

---

## 👤 Autor
- GitHub: [@Valdemar-Andrade]
- LinkedIn: [Valdemar Valdemar](https://www.linkedin.com/in/valdemar-andrade-8b0b45189)
