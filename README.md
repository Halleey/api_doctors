# Hospital Staff API

A **Hospital Staff API** é uma API RESTful que permite gerenciar o cadastro de profissionais da saúde, como **médicos** e **enfermeiros**, centralizando suas informações básicas em um subsistema hospitalar. A API foi construída utilizando **Spring Boot** e fornece endpoints para cadastro e consulta de médicos e enfermeiros, compondo um microserviço dedicado ao gerenciamento de equipe.

---

## Funcionalidades atuais

- **Cadastro de médicos**: Permite a criação de médicos com dados como nome, senha, CRM e especialização.
- **Cadastro de enfermeiros(as)**: Permite a criação de enfermeiros(as) com dados como nome, número de registro e turno de trabalho.
- **Consulta de médicos**: Permite buscar médicos pelo nome e senha para obter suas informações básicas.

---

## Tecnologias

- **Spring Boot**: Framework para construção de microserviços em Java.
- **JPA/Hibernate**: Persistência de dados no banco de dados MySQL.
- **MySQL**: Banco de dados relacional para armazenamento das entidades.

---

## Endpoints

### 1. `POST /doctors`
Cria um novo médico.

**Request Body**:
```json
{
  "name": "Dr. João Silva",
  "password": "senha123",
  "crm": "123456",
  "expertise": "Cardiologia"
}
```

**Response**:
- **Status**: `201 Created`
- **Body**:
```json
{
  "name": "Dr. João Silva",
  "crm": "123456",
  "expertise": "Cardiologia"
}
```

---

### 2. `GET /doctors?name={name}&password={password}`
Busca um médico pelo nome e senha.

**Request Params**:
- `name`: Nome do médico.
- `password`: Senha do médico.

**Response**:
- **Status**: `200 OK`
```json
{
  "name": "Dr. João Silva",
  "crm": "123456",
  "expertise": "Cardiologia"
}
```
- **Status**: `404 Not Found` (Caso o médico não seja encontrado)

---

### 3. `POST /nurses`
Cria uma nova enfermeira ou enfermeiro.

**Request Body**:
```json
{
  "name": "Maria Clara",
  "registrationNumber": "COREN-548723",
  "shift": "NIGHT",
  "password": "senhaSegura"
}
```

**Response**:
- **Status**: `201 Created`
- **Body**:
```json
{
  "name": "Maria Clara",
  "registrationNumber": "COREN-548723",
  "shift": "NIGHT"
}
```

---

## Instalação

### 1. Clonando o Repositório
```bash
git clone https://github.com/seu-usuario/hospital-staff-api.git
cd hospital-staff-api
```

### 2. Configuração do Banco de Dados
A API utiliza **MySQL** como banco de dados. Certifique-se de que o MySQL está instalado e em execução. Crie um banco de dados chamado `hospital` e ajuste as configurações no arquivo `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/hospital?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Sao_Paulo
    username: root
    password: sua-senha
```

---

### 3. Executando a API
Depois de configurar o banco de dados, execute o seguinte comando para subir a aplicação:

```bash
mvn spring-boot:run
```

A API estará acessível em:  
`http://localhost:8080`

---

## Integrações Futuras

O sistema está preparado para futuras integrações, incluindo:

- **Criptografia de senha**.
- **Alteração de informações**: Alterar dados a respeito dos agentes que trabalham no hospital.
- **Sistema de notificações internas**: Alerta de alterações em dados sensíveis, turnos e novos atendimentos.

