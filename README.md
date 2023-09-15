# Sistema de Transferências

O Sistema de Transferências é uma aplicação Java baseada em Spring Boot que permite a realização de transações entre usuários (clientes e empresas).

## Pré-requisitos

- Java Development Kit (JDK) 17
- Maven 3.8.6 ou superior
- Banco de Dados H2 (configurado no arquivo `application.properties`)

## Configuração

1. Clone o repositório:

        git clone https://github.com/seu-usuario/sistema-transferencias.git
        cd sistema-transferencias

2. Certifique-se de ter o JDK 17 instalado. Verifique com:

        java -version
            
3. Compile e execute o projeto:

        mvn spring-boot:run
    
A aplicação estará acessível em http://localhost:8080.

## Funcionalidades

- Cadastro de Usuários (Clientes e Empresas)
- Realização de Transações entre Usuários
- Adição de Saldo (Disponível após o login)

## Estrutura do Projeto
O projeto é dividido em três principais pacotes:

- com.transfersystem.domain: Contém as entidades JPA (User e Transaction).
- com.transfersystem.repositories: Repositórios JPA para acesso ao banco de dados.
- com.transfersystem.services: Serviços que implementam a lógica de negócio.

## Endpoints
- POST /users/create: Cria um novo usuário.
- POST /transactions/create: Cria uma nova transação entre usuários.


## Frontend (Thymeleaf)
O projeto também inclui um frontend em Thymeleaf para interação com o usuário. As páginas HTML estão localizadas no diretório src/main/resources/templates.

## testes
A aplicação possui testes unitários para os serviços e controladores. Para executá-los, utilize o comando:

      mvn test

      
## Contribuição
Sinta-se à vontade para contribuir com melhorias, correções de bugs ou novas funcionalidades. Basta abrir uma nova issue ou um pull request.

## Licença
Este projeto é licenciado sob a MIT License - veja o arquivo LICENSE para detalhes.
