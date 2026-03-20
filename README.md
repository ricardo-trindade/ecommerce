

# 📦 Ecommerce Backend

Este projeto é um backend para um sistema de e-commerce, desenvolvido em **Java + Spring Boot**, utilizando **JPA/Hibernate** para persistência e **DTOs** para transferência de dados entre cliente e servidor.

## 🚀 Tecnologias utilizadas
- Java 25+
- Spring Boot
- Spring Web
- Spring Data JPA
- Jakarta Validation
- Spring DevTools
- MySQL
- Lombok

## 📂 Estrutura do projeto
```
src/main/java/com/projeto/ecommerce
│
├── controllers        # Controllers (camada de entrada da API)
├── entities           # Entidades JPA (representam tabelas do banco)
├── repositories       # Interfaces de acesso ao banco (JpaRepository)
├── requests           # DTOs de entrada (UserRequestDTO, ProductRequestDTO, OrderRequestDTO)
├── responses          # DTOs de saída (UserResponseDTO, ProductResponseDTO, OrderResponseDTO)
└── services           # Regras de negócio (UserService, ProductService, OrderService)
```

---

## 🔑 Endpoints disponíveis

### 👤 Usuários

#### 1. Criar usuário
```http
POST /user/create
```
**Body:**
```json
{
  "name": "João Silva",
  "email": "joao@email.com",
  "phone": "11999999999",
  "password": "123456",
  "roles": "USER"
}
```

#### 2. Buscar usuário por ID
```http
GET /user/show/{id}
```

#### 3. Atualizar usuário
```http
PUT /user/update/{id}
```

#### 4. Deletar usuário
```http
DELETE /user/delete/{id}
```

---

### 🛒 Produtos

#### 1. Criar produto
```http
POST /products/create
```
**Body:**
```json
{
  "name": "Notebook Gamer",
  "description": "RTX 4060, 16GB RAM",
  "price": 5999.90,
  "imgURL": "http://imagem.com/notebook.png"
}
```

#### 2. Buscar produto por ID
```http
GET /products/show/{id}
```

#### 3. Atualizar produto
```http
PUT /products/update/{id}
```
**Body:**
```json
{
  "name": "Notebook Gamer Atualizado",
  "description": "RTX 4070, 32GB RAM",
  "price": 7999.90,
  "imgURL": "http://imagem.com/notebook2.png"
}
```

#### 4. Deletar produto
```http
DELETE /products/delete/{id}
```

---

### 📦 Pedidos

#### 1. Criar pedido
```http
POST /orders/create
```
**Body:**
```json
{
  "moment": "2026-03-16T15:30:00",
  "status": "AWAITING_PAYMENT",
  "client": "b2d1f9a0-9876-5432-1abc-def098765432",
  "payment": null,
  "items": [
    {
      "productId": "aa03e1b3-14b1-4960-afa3-04153372ebfc",
      "quantity": 1
    },
    {
      "productId": "c67d210e-ccac-425b-9ec9-71de485edfba",
      "quantity": 2
    }
  ]
}
```

#### 2. Buscar pedido por ID
```http
GET /orders/show/{id}
```

#### 3. Atualizar status do pedido
```http
PUT /orders/update/{id}
```
**Body:**
```json
{
  "status": "PAID"
}
```

#### 4. Deletar pedido
```http
DELETE /orders/delete/{id}
```

---

## ⚙️ Como rodar o projeto
1. Dê uma estrelinha no repositório

2. Clone o repositório:
   ```bash
   git clone https://github.com/srjuninn/Ecommerce-Backend.git
   ```
3. Entre na pasta do projeto:
   ```bash
   cd Ecommerce-Backend
   ```
4. Compile e rode:
   ```bash
   mvn spring-boot:run
   ```
5. Acesse a API em:
   ```
   http://localhost:8080
   ```

Ou abra no **IntelliJ IDEA**, rode a classe `EcommerceApplication` e teste os endpoints no **Postman** ou **Insomnia**.

---

## 🛡️ Tratamento de erros
A API retorna mensagens claras em caso de erro:
- **404 Not Found** → Usuário, produto ou pedido não encontrado.
- **409 Conflict** → Email ou nome de produto já cadastrado.
- **400 Bad Request** → Dados inválidos.

---

## 📌 Próximos passos
- Implementar autenticação e autorização (Spring Security + JWT).
- Documentar a API com Swagger/OpenAPI.
- Criar endpoints para relatórios (ex.: histórico de pedidos por usuário).
