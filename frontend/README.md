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


