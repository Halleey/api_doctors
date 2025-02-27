# Doctors API

A **Doctors API** é uma API RESTful que permite gerenciar o cadastro de médicos, suas informações básicas e outras funcionalidades de um sistema hospitalar. A API foi construída utilizando **Spring Boot** e oferece endpoints para o cadastro e consulta de médicos, além de integração com **Kafka** para envio de notificações quando um novo médico é cadastrado.

## Funcionalidades

- **Cadastro de médicos**: Permite a criação de médicos com dados como nome, senha, CRM e especialização.
- **Consulta de médicos**: Permite buscar médicos pelo nome e senha para obter suas informações básicas.
- **Notificação via Kafka**: Envia uma mensagem para o tópico "Hospital" sempre que um novo médico é cadastrado, para fins de integração com outros sistemas.

## Tecnologias

- **Spring Boot**: Framework para criação de aplicações Java baseadas em microserviços.
- **Kafka**: Sistema de mensageria para a troca de dados entre diferentes partes do sistema.
- **JPA/Hibernate**: Para persistência de dados no banco de dados MySQL.

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
- **Status**: `200 OK` (Caso o médico seja encontrado)
```json
{
  "name": "Dr. João Silva",
  "crm": "123456",
  "expertise": "Cardiologia"
}
```

- **Status**: `404 Not Found` (Caso o médico não seja encontrado)

## Instalação

### 1. Clonando o Repositório

```bash
git clone https://github.com/seu-usuario/doctors-api.git
cd doctors-api
```

### 2. Configuração do Banco de Dados

A API utiliza **MySQL** como banco de dados. Certifique-se de que o MySQL está instalado e em execução. Crie um banco de dados chamado `hospital` e ajuste as configurações no arquivo `application.yml`.

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/hospital?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Sao_Paulo
    username: root
    password: sua-senha
```

### 3. Executando a API

Depois de configurar o banco de dados, basta rodar a aplicação com o comando:

```bash
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

## Integrações Futuras

### 1. Integração com Pacientes e Prontuários

Planejamos futuras integrações com pacientes e prontuários para expandir as funcionalidades do sistema hospitalar. A ideia é conectar os médicos aos pacientes, registrando suas especialidades e permitindo que os prontuários dos pacientes sejam atualizados diretamente pelos médicos.

Possíveis Funcionalidades Futuras:

- Prontuário Eletrônico: Criar um sistema de prontuário eletrônico, onde médicos podem registrar as consultas, diagnósticos e tratamentos dos pacientes.
- Histórico Médico: Permitir que médicos visualizem o histórico de atendimentos dos pacientes e adicionem novos registros no prontuário.
- Notificações de Atendimento: Enviar notificações via Kafka sempre que um médico atender um paciente ou alterar o prontuário.

