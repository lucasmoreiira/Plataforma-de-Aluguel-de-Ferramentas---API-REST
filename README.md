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
### 📁 Requisições Insomnia
Dentro deste projeto há uma pasta chamada requisicaoInsomnia, que contém arquivos de requisições HTTP organizadas por recursos da API (como usuários, ferramentas e reservas).

Esses arquivos foram criados para facilitar os testes e a utilização da API REST durante o desenvolvimento ou integração. Eles podem ser importados diretamente no Insomnia, permitindo realizar chamadas como GET, POST, PUT e DELETE com exemplos prontos.

Como usar:

Abra o Insomnia.

Clique em "Importar" no menu superior.

Selecione "Arquivo" e escolha o conteúdo da pasta requisicaoInsomnia.

Você verá os endpoints organizados por categorias.

Essa é uma forma prática e rápida de explorar todos os recursos oferecidos pela API sem precisar configurar cada requisição manualmente.

## 📄 Exemplos de JSON (payloads)

### 🔸 Criar um Usuário

```json
{
	"nome": "Ana Souza",
	"cpf": "12345678901",
	"telefone": {
		"ddd": "11",
		"numero": "98765-4321"
	},
	"endereco": {
		"logradouro": "Rua das Acácias",
		"numero": "123",
		"cidade": "São Paulo",
		"uf": "SP",
		"cep": "01001000"
	}
}
```

### 🔸 Criar uma Ferramenta

```json
  {
    "nome": "Lavadora de Alta Pressão",
    "valorDia": "30",
    "categoria": "limpeza"
  }
```

### 🔸 Criar uma Reserva

```json
{
	"dataInicioReserva": "2025-05-04T14:30:00",
	"dataFimReserva": "2025-05-10T14:30:00",
	"usuario": {
		"id": "6820bf94cf2d8e0e35b8eee5"
	},
	"ferramentas": [
		{
			"id": "68210f0b1747752c108b85ad"
		},
		{
			"id": "68210eec1747752c108b85a8"
		}
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
   lojaferramentasdb
   ```

### 3. Configuração do `application.properties`

Caso necessário, altere as configurações no arquivo `src/main/resources/application.properties`:

```properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=lojaferramentasdb
spring.data.mongodb.username=admin
spring.data.mongodb.password=password
```

### 4. Executar o projeto

1. **Abra o projeto no IntelliJ IDEA.**
2. Aguarde o carregamento completo do Maven (verifique se todas as dependências estão baixadas).
3. No painel lateral esquerdo, navegue até:
   ```
   src/main/java/com/example/toolstore/ToolstoreApplication.java
   ```
4. Clique com o botão direito no arquivo `LojaDeFerramentasApplication.java`.
5. Selecione a opção **Run 'LojaDeFerramentasApplication.main()'**.
6. O servidor Spring Boot será iniciado em:
   ```
   http://localhost:8080
   ```

> 💡 Certifique-se de que o MongoDB esteja em execução antes de iniciar a aplicação.


## 📝 Observações

- As respostas de reservas retornam apenas ID e nome do usuário e das ferramentas.
- O relacionamento é feito por ID (referência), facilitando o uso com MongoDB.
- Recomendado utilizar o MongoDB Compass para monitorar dados e inserir registros manualmente se necessário.

---
