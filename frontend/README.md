# Frontend - Desafio-Fullstack-Java

Este projeto é o Front do sistema de Pontos turísticos.

## Pré-requisitos

Para a execução deste projeto é necessário que a maquina tenha o seguintes sistemas instalados:

- [Node](https://nodejs.org/en/download/). 
  - Aconselhamos utilizar a [versão 16.19.1](https://nodejs.org/download/release/v16.19.1/).
- [NPM](https://www.npmjs.com/)
  - Será instalado junto do Node
- [Angular](https://angular.io/)
  - Siga o guia para instalar o [angular-cli](https://angular.io/guide/setup-local) corretamente

Após a instalação dos sistemas não esqueça de realizar a instalação das dependências.

Outro ponto importante é quando for rodar o projeto utilize o comando `npm start` inves do `ng serve`

## Rodando o projeto

O projeto já esta integrando com o Back-End, lembre-se de sempre estar com os dois projetos rodando para realizar o desenvolvimento.

## 1. Instalação do projeto
- nvm use 16.19.1
- npm install

## 2. Inicialização do frontend e do backend
- npm start no terminal do frontend
- Inicializar o backend para testar criação do pais.

## Estrutra do frontend:
src/
└── app/
    ├── comentarios/
    │   ├── cadastro-comentario/
    │   │   ├── cadastro-comentario.component.ts
    │   │   ├── cadastro-comentario.component.html
    │   │   └── cadastro-comentario.component.css
    │   ├── comentarios.component.ts
    │   ├── comentarios.component.html
    │   └── comentarios.component.css
    ├── paises/
    │   ├── cadastro-paises/
    │   │   ├── cadastro-paises.component.ts
    │   │   ├── cadastro-paises.component.html
    │   │   └── cadastro-paises.component.css
    │   ├── paises.component.ts
    │   ├── paises.component.html
    │   └── paises.component.css
    ├── pontos-turisticos/
    │   ├── cadastro-pontos-turisticos/
    │   │   ├── cadastro-pontos-turisticos.component.ts
    │   │   ├── cadastro-pontos-turisticos.component.html
    │   │   └── cadastro-pontos-turisticos.component.css
    │   ├── pontos-turisticos.component.ts
    │   ├── pontos-turisticos.component.html
    │   └── pontos-turisticos.component.css
    ├── service/
    │   └── http-service.service.ts
    ├── shared/
    ├── app-routing.module.ts
    ├── app.component.ts
    ├── app.component.html
    ├── app.component.css
    └── app.module.ts


### Observação sobre testes

> Os arquivos de teste (`*.spec.ts`) serão removidos do projeto.  
> O foco atual está na implementação da lógica funcional, estrutura dos componentes (`.html`) e estilização (`.css`).  
> Testes automatizados poderão ser considerados em fases futuras, após validação completa dos fluxos principais.

### Implementação Base — Países

> A estrutura dos componentes para Comentários, Países e Pontos Turísticos já está criada. A lógica funcional será construída inicialmente no módulo de Países, servindo como base para os demais.

A aplicação possui três módulos principais, cada um com estrutura de componentes já criada e preparados para receber a lógica funcional:

#### 1. Países
- [x] Componentes criados: cadastro-paises e paises.
- [x] Interfaces `Pais` e `NovoPais` implementadas.
- [x] Refatoração do método `enviarPost` com lógica condicional aprimorada.
- [x] Refatoração da cadastro-pais o ts esteja alinhada com o backend.
- [x] Integração completa com o backend (CRUD funcional).
- [x] Refatoração das rotas para orginazação funcional do código.
- [x] refatoração do httpService e urlApi;
- [x] Pos alteração testar o crud novamente!
> Status: **finalizado** 

#### 2. Pontos Turísticos
- [x] Componentes criados: cadastro-pontos-turisticos e pontos-turisticos, responsáveis respectivamente pelo formulário de cadastro e pela listagem dos pontos turísticos.
- [x] Interfaces implementadas: PontoTuristico e NovoPontoTuristico, definindo a estrutura dos dados utilizados no front-end.
- [x] Lógica funcional aplicada: HTML e TypeScript para exibição da lista de pontos turísticos, com estrutura responsiva e navegação integrada.
- [x] Refatoração de rotas: ajustes na configuração de rotas para garantir organização e fluidez na navegação entre os módulos.
- [x] Formulário de cadastro funcional: implementação completa do layout e lógica de cadastro, incluindo validações, integração com FormGroup, uso de po-select com enums e dados dinâmicos.
- [ ] Integração com o back-end (CRUD): endpoints ainda serão conectados para persistência e edição dos dados.
- [ ] Análise do README.md: verificar a estrutura das tabelas e relações para garantir consistência entre front e back.
> Status: **Em desenvolvimento front-end estruturado e pronto para testes com o back-end.**

#### 3. Comentários
- [x] Componentes criados: cadastro-comentario e comentarios.
- [x] Interface `Comentario` e `NovoComentario` pendentes.
- [ ] Implementação da lógica funcional baseada no padrão do módulo Países
- [ ] Desenvolvimento da integração com o backend (CRUD)
- [ ] Verificar o readme.md do projeto para entender qual é a relação das tabelas.
> Status: **Aguardando implementação da lógica**

### BACKEND

#### Domain:

# Pais: 
Representa um país cadastrado no sistema, contendo informações básicas e servindo como referência para os pontos turísticos associados.
- Campos principais: id, nome, sigla, continente, ddi
- Relacionamento: @OneToMany com PontoTuristico
- Validações: @NotBlank e @Min para garantir integridade dos dados
- Construtor baseado em DTO para facilitar integração com a camada de serviço

# PontoTuristico:
Representa um local turístico vinculado a um país, com informações detalhadas sobre sua localização e época ideal de visita.
- Campos principais: id, nome, cidade, resumo, melhorEstacao, pais
- Enum Estacoes: define a melhor estação do ano para visitar o ponto turistico.
- Relacionamentos:
  - @ManyToOne com Pais
  - @OneToMany com Comentario
- Validações: @NotBlank e @Enumerated(EnumType.STRING)
- Método utilitário adicionarComentario() para manter vínculo bidirecional

# Comentario:
Representa uma avaliação ou observação feita por usuários sobre um ponto turístico.
- Campos principais: id, mensagem, autor, dataCriacao, pontoTuristico
- Relacionamento: @ManyToOne com PontoTuristico
- Validação: @NotBlank no campo mensagem
- dataCriacao preenchido automaticamente com LocalDateTime.now()
> Status: **finalizado** 

# Repository:
Os repositórios são interfaces responsáveis por acessar e manipular os dados persistidos no banco, utilizando Spring Data JPA.
Cada entidade principal (Pais, PontoTuristico, Comentario) possui seu respectivo repositório estendendo JpaRepository, o que garante 
acesso a métodos prontos como findAll(), findById(), save(), deleteById(), entre outros.
- Integração automática com o contexto do Spring Boot
- Facilidade para criar consultas personalizadas com @Query ou métodos derivados
- Suporte a paginação, ordenação e filtro.
> Status: **finalizado** 

# DTOs (Data Transfer Objects):
Os DTOs são usados para transportar dados entre as camadas da aplicação, especialmente entre os controllers e os services, sem expor diretamente as entidades JPA.
- Evitam o acoplamento direto entre entidades e a camada de apresentação
- Permitem aplicar validações específicas para entrada de dados
- Facilitam o mapeamento e transformação de dados recebidos via API
> Status: **finalizado** 

# Camada de Serviços (services):
A camada de serviços é responsável por implementar a lógica de negócio da aplicação. Ela atua como intermediária 
entre os controllers (camada de entrada) e os repositórios (camada de persistência).

services/
├── interfaces/
│   ├── PaisService.java
│   ├── PontoTuristicoService.java
│   └── ComentarioService.java
├── impl/
│   ├── PaisServiceImpl.java
│   ├── PontoTuristicoServiceImpl.java
│   └── ComentarioServiceImpl.java

- Interfaces de serviço definem os contratos de cada funcionalidade (CRUD + buscas específicas)

- Implementações (Impl) executam a lógica de negócio:
  - Validação de entidades relacionadas (ex: paisId, pontoTuristicoId)
  - Conversão entre entidades e DTOs
  - Chamada aos repositórios para persistência e consulta

# Funcionalidades por entidade:

PaisService:
- Criar, atualizar, buscar, listar e deletar países
- Buscar países por continente.

PontoTuristicoService:
- Criar e atualizar pontos turísticos vinculados a um país
- Buscar por ID, listar todos ou filtrar por país.

ComentarioService:
- Criar e atualizar comentários vinculados a um ponto turístico.
- Buscar por ID, listar todos ou filtrar por ponto turístic
> Status: **finalizado** 
