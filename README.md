# 🚀 API de Gestão de Vendas com Herança JPA

Este projeto é uma API RESTful desenvolvida em Spring Boot, focada na gestão de lançamentos de vendas e diferentes tipos de vendedores (Autônomo e Profissional), utilizando a estratégia de herança **JOINED** do JPA/Hibernate.

## 📋 Pré-requisitos

Antes de começar, você precisa ter instalado:

* **Java 17** ou superior
* **Maven** (para gerenciar o projeto e dependências)
* Um ambiente de desenvolvimento (IDE) como IntelliJ IDEA, Eclipse ou VS Code.
* **PostgreSQL** (opcional, para ambiente de produção)

## 📦 Dependências Utilizadas

O projeto foi configurado com as seguintes tecnologias e bibliotecas:

| Tecnologia/Biblioteca | Finalidade |
| :--- | :--- |
| **Spring Web** | Criação de serviços RESTful. |
| **Spring Data JPA** | Persistência de dados e mapeamento Objeto-Relacional (ORM). |
| **Validation (`jakarta.validation`)** | Validação de dados de entrada (`@Valid`). |
| **PostgreSQL Driver** | Conexão com o banco de dados de Produção. |
| **H2 Database** | Banco de dados em memória/arquivo para Desenvolvimento. |
| **Spring Dev Tools** | Otimização do desenvolvimento (reload automático). |
| **Lombok** | Geração automática de Getters, Setters e Construtores. |
| **Springdoc OpenAPI UI** | Geração de documentação interativa (Swagger UI). |

## ⚙️ Configuração e Perfis de Execução

O projeto está configurado para usar dois perfis distintos (`developer` e `production`).

### Perfis de Banco de Dados

O perfil ativo é definido no arquivo `application.properties`.

| Perfil | Banco de Dados | `spring.profiles.active` | Configuração |
| :--- | :--- | :--- | :--- |
| **developer (Padrão)** | H2 (Arquivo) | `developer` | Banco em arquivo `./data/vendas_db` com console H2 ativado em `/h2-console`. |
| **production** | PostgreSQL | `production` | Conexão externa com PostgreSQL. |

### Inicialização

1.  **Clone o repositório:**
    ```bash
    git clone [LINK_DO_SEU_REPOSITÓRIO]
    cd vendas-api
    ```
2.  **Execute a aplicação (Perfil Padrão - Developer):**
    ```bash
    mvn spring-boot:run
    ```
3.  **Para executar com o perfil de produção (PostgreSQL):**
    ```bash
    mvn spring-boot:run -Dspring-boot.run.profiles=production
    ```

## 🌐 Endpoints da API e Documentação

Após iniciar o servidor (padrão em `http://localhost:8080`), você pode acessar:

* **Swagger UI (Documentação Interativa):**
    `http://localhost:8080/swagger-ui.html`

### Principais Endpoints

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/lancamentos` | Insere um novo Lançamento de Vendas. |
| `GET` | `/lancamentos/{id}` | Busca um Lançamento de Vendas pelo ID. |

## 🏛️ Estrutura de Classes e Mapeamento JPA

### 1. Estratégia de Herança (Vendedor)

A herança entre `Vendedor`, `VendedorAutonomo` e `VendedorProfissional` utiliza a estratégia **`InheritanceType.JOINED`**.

* **Tabela `Vendedor`**: Contém campos comuns (`id`, `nome`, `email`, `salario`).
* **Tabela `VendedorAutonomo`**: Contém apenas o campo `comissão` e uma chave estrangeira para `Vendedor`.
* **Tabela `VendedorProfissional`**: Contém apenas o campo `cnpj` e uma chave estrangeira para `Vendedor`.

### 2. Entidades

| Entidade | Relacionamento | Campos Chave |
| :--- | :--- | :--- |
| `Vendedor` (Superclasse) | `@OneToMany` com `LancamentoVendas` | `id`, `nome`, `email`, `salario` |
| `VendedorAutonomo` | Herda de `Vendedor` | `comissão` |
| `VendedorProfissional` | Herda de `Vendedor` | `cnpj` |
| `LancamentoVendas` | `@ManyToOne` com `Vendedor` | `id`, `data`, `valor`, `vendedor_id` |

### 3. DTO

A classe `LancamentoVendasResponseDTO` é utilizada para transferir dados de forma simplificada ao cliente, expondo apenas os campos: `dataVenda`, `valorVenda` e `nomeVendedor`.

## ✅ Validações e Tratamento de Exceções

### Validações (`@jakarta.validation`)

As seguintes validações estão implementadas na classe `Vendedor`:

* **Nome:** Não pode ser nulo ou vazio (`@NotBlank`).
* **E-mail:** Formato de e-mail válido (`@Email` e `@NotBlank`).
* **Salário:** Não pode ser nulo (`@NotNull`) e não pode ser inferior ao salário mínimo de R$ 1.412,00 (`@DecimalMin`).

### Tratamento Global de Exceções

O projeto inclui um `GlobalExceptionHandler` (`@ControllerAdvice`) para interceptar e padronizar as respostas de erro da API:

* **`handleMethodArgumentNotValid`**: Trata erros de validação (`@Valid`), retornando o status **400 Bad Request** e uma lista detalhada dos campos com erro.
* **`handleNotFound`**: Trata erros de recursos não encontrados (ex: `findById().orElseThrow(NoSuchElementException)`), retornando **404 Not Found**.

## 📊 Popularização de Dados

Um `DataInitializer` (implementando `CommandLineRunner`) é responsável por popular a tabela `Vendedor` com **1000 registros** na inicialização da aplicação, utilizando dados mockados gerados via Mockaroo.
