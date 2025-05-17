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

- `GET /usuarios` — Listar todos os usuários
- `GET /usuarios/{id}` — Buscar usuário por ID
- `POST /usuarios` — Criar novo usuário
- `PUT /usuarios/{id}` — Atualizar usuário existente
- `DELETE /usuarios/{id}` — Deletar usuário

### 🔹 Ferramentas

- `GET /ferramentas` — Listar ferramentas
- `GET /ferramentas/{id}` — Buscar ferramenta por ID
- `POST /ferramentas` — Cadastrar nova ferramenta
- `PUT /ferramentas/{id}` — Atualizar ferramenta
- `DELETE /ferramentas/{id}` — Deletar ferramenta

### 🔹 Reservas

- `GET /reservas` — Listar reservas (retorna apenas ID e nome de usuário e ferramentas)
- `GET /reservas/{id}` — Buscar reserva por ID
- `POST /reservas` — Criar nova reserva
- `PUT /reservas/{id}` — Atualizar reserva
- `DELETE /reservas/{id}` — Cancelar reserva

---

## 📄 Exemplo de JSON para criar uma reserva

```json
{
  "dataInicioReserva": "2025-05-20",
  "dataFimReserva": "2025-05-25",
  "usuario": {
    "id": "user123"
  },
  "ferramentas": [
    { "id": "ferra001" },
    { "id": "ferra002" }
  ]
}
```

---

## 🧪 Como testar

1. Clone o projeto:
   ```bash
   git clone https://github.com/seu-usuario/aluguel-ferramentas-api.git
   ```

2. Navegue até o diretório e execute:
   ```bash
   ./mvnw spring-boot:run
   ```

3. A API estará disponível em:  
   `http://localhost:8080`

---

## ✅ Requisitos

- Java 17+
- MongoDB em execução (localhost:27017)
- Maven

---

## 📝 Observações

- A resposta das reservas usa DTOs (`ReservaDTO`) para retornar **somente o ID e nome do usuário e das ferramentas**.
- As entidades estão organizadas de forma aninhada em alguns casos por simplicidade no consumo da API.
- Este projeto pode ser facilmente estendido com autenticação (JWT), paginação, filtros por data ou status etc.

---

## 👤 Autor

Feito por [Seu Nome]  
📧 seu.email@example.com  
📂 [LinkedIn ou GitHub](https://github.com/seu-usuario)
