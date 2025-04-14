# Hospital Staff API

A **Hospital Staff API** é uma API RESTful desenvolvida em **Spring Boot** para facilitar o gerenciamento de profissionais da saúde, como **médicos** e **enfermeiros(as)**, dentro de um subsistema hospitalar. Essa API centraliza dados de cadastro e consulta, permitindo que sistemas hospitalares consultem e administrem suas equipes com segurança e organização.

---

## 🔧 Funcionalidades Atuais

- ✅ **Cadastro de Médicos**: Cria novos registros com nome, senha, CRM e especialização.
- ✅ **Cadastro de Enfermeiros(as)**: Cadastra enfermeiros(as) com nome, número de registro e turno de trabalho.
- ✅ **Autenticação de Médicos e Enfermeiros(as)**: Consulta usando nome e senha via método `POST` para autenticar e obter as informações do profissional.

---

## 🚀 Tecnologias Utilizadas

- **Spring Boot**: Framework para desenvolvimento de microserviços.
- **JPA / Hibernate**: Camada de persistência com MySQL.
- **MySQL**: Banco de dados relacional.
- **BCryptPasswordEncoder**: Criptografia de senha.

---

## 🔗 Endpoints Disponíveis

### 1. `POST /doctors`
Cadastra um novo médico.

**Request Body:**
```json
{
  "name": "Dr. João Silva",
  "password": "senha123",
  "crm": "123456",
  "expertise": "Cardiologia"
}
```

**Response:**
- Status: `201 Created`
```json
{
  "name": "Dr. João Silva",
  "crm": "123456",
  "expertise": "Cardiologia"
}
```

---

### 2. `POST /doctors/login`
Autentica um médico através do nome e senha.

**Request Body:**
```json
{
  "name": "Dr. João Silva",
  "password": "senha123"
}
```

**Response:**
- Status: `200 OK`
```json
{
  "name": "Dr. João Silva",
  "crm": "123456",
  "expertise": "Cardiologia",
  "role": "ROLE_DOCTOR"
}
```
- Status: `401 Unauthorized` (Credenciais inválidas)

---

### 3. `POST /nurses`
Cadastra um(a) enfermeiro(a).

**Request Body:**
```json
{
  "name": "Maria Clara",
  "registrationNumber": "COREN-548723",
  "shift": "NIGHT",
  "password": "senhaSegura"
}
```

**Response:**
- Status: `201 Created`
```json
{
  "name": "Maria Clara",
  "registrationNumber": "COREN-548723",
  "shift": "NIGHT"
}
```

---

### 4. `POST /nurses/login`
Autentica um(a) enfermeiro(a) através do nome e senha.

**Request Body:**
```json
{
  "name": "Maria Clara",
  "password": "senhaSegura"
}
```

**Response:**
- Status: `200 OK`
```json
{
  "name": "Maria Clara",
  "registrationNumber": "COREN-548723",
  "shift": "NIGHT",
  "role": "ROLE_NURSE"
}
```
- Status: `401 Unauthorized` (Credenciais inválidas)

---

## 🚫 Tratamento de Senhas
Todas as senhas de médicos e enfermeiros(as) são armazenadas de forma criptografada com **BCrypt** para garantir segurança no armazenamento.

---

## 🌐 Instalação Local

### 1. Clonando o repositório
```bash
git clone https://github.com/seu-usuario/hospital-staff-api.git
cd hospital-staff-api
```

### 2. Configuração do Banco de Dados
Edite o `application.yml` com suas credenciais MySQL:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/hospital?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Sao_Paulo
    username: root
    password: sua-senha
```

### 3. Executando a aplicação
```bash
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

---

## 🚡 Roadmap Futuro

- Integração de sistema de alteração de dados de profissionais.
- Sistema de notificações internas para turnos, alterações e novos atendimentos.
- Evolução para roles personalizados e hierarquia de acesso.

---
