# 🛠️ Plataforma de Aluguel de Ferramentas - API REST

Esta é uma API REST desenvolvida com **Spring Boot** e **MongoDB**, projetada para gerenciar uma plataforma de aluguel de ferramentas. Nela é possível cadastrar usuários, ferramentas e criar reservas associando ambos.

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- MongoDB
- Spring Data MongoDB
- Lombok
- Maven

## 📁 Estrutura da aplicação

```
src/
 ├─ controller/         # Controllers REST
 ├─ dto/                # Data Transfer Objects (resumos usados na resposta)
 ├─ model/              # Modelos/entidades
 ├─ repository/         # Repositórios (MongoDB)
 ├─ service/            # Regras de negócio
```

---

## 📌 Endpoints disponíveis

### 🔹 Usuários

- `GET /usuarios`
- `GET /usuarios/{id}`
- `POST /usuarios`
- `PUT /usuarios/{id}`
- `DELETE /usuarios/{id}`

### 🔹 Ferramentas

- `GET /ferramentas`
- `GET /ferramentas/{id}`
- `POST /ferramentas`
- `PUT /ferramentas/{id}`
- `DELETE /ferramentas/{id}`

### 🔹 Reservas

- `GET /reservas`
- `GET /reservas/{id}`
- `POST /reservas`
- `PUT /reservas/{id}`
- `DELETE /reservas/{id}`

---

## 📄 Exemplos de JSON (payloads)

### 🔸 Criar um Usuário

```json
{
  "nome": "João da Silva",
  "cpf": "12345678900",
  "telefone": "11999998888",
  "endereco": {
    "logradouro": "Rua das Ferramentas",
    "numero": "100",
    "cidade": "São Paulo",
    "uf": "SP",
    "cep": "01000-000"
  }
}
```

### 🔸 Criar uma Ferramenta

```json
{
  "nome": "Furadeira Bosch",
  "valor_dia": 25.0,
  "status": "disponível",
  "categoria": "Elétrica"
}
```

### 🔸 Criar uma Reserva

```json
{
  "dataInicioReserva": "2025-05-20",
  "dataFimReserva": "2025-05-25",
  "usuario": {
    "id": "usuario123"
  },
  "ferramentas": [
    { "id": "ferramenta001" },
    { "id": "ferramenta002" }
  ]
}
```

---

## 🧪 Como rodar o projeto

### 1. Requisitos

- Java 17+
- MongoDB instalado (pode usar o **MongoDB Compass**)
- Maven

### 2. Conectando ao MongoDB com o MongoDB Compass

1. Abra o MongoDB Compass e conecte à instância local:
   ```
   mongodb://localhost:27017
   ```
2. Crie um banco de dados chamado:
   ```
   aluguel_ferramentas
   ```

### 3. Configuração do `application.properties`

Caso necessário, altere as configurações no arquivo `src/main/resources/application.properties`:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/aluguel_ferramentas
spring.data.mongodb.database=aluguel_ferramentas
server.port=8080
```

### 4. Executar o projeto

```bash
./mvnw spring-boot:run
```

A aplicação estará acessível em:

```
http://localhost:8080
```

---

## 📝 Observações

- As respostas de reservas retornam apenas ID e nome do usuário e das ferramentas.
- O relacionamento é feito por ID (referência), facilitando o uso com MongoDB.
- Recomendado utilizar o MongoDB Compass para monitorar dados e inserir registros manualmente se necessário.

---
