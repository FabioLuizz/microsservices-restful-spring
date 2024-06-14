# Aplicação Java
Bem-vindo ao meu projeto! Esta é uma aplicação robusta desenvolvida com tecnologias modernas para gerenciar a coleta de lixo em cidades inteligentes, utilizando uma arquitetura baseada em microserviços.



O projeto se trata de um sistema de agenda para coleta de lixo nas cidades inteligentes...



Foram utilizadas, ferramentas do Spring, Java como tecnologia principal e Docker como gerenciador de container.



### Tecnologias Utilizadas:

- **Spring Boot 3**: Framework para desenvolvimento eficiente de WebServices RESTful.
- **Java**: Linguagem de programação principal para a lógica da aplicação.
- **Spring Data JPA**: Facilita a implementação de camadas de persistência baseadas em JPA.
- **Spring Validation**: Garante a integridade dos dados através da validação de entrada.



### Arquitetura de MicrosServiços:

- **Microserviços**: Organizamos a aplicação em serviços independentes, cada um responsável por uma funcionalidade específica.
- **Comunicação entre Microserviços**: Utilizamos comunicação RESTful e troca de mensagens para a integração entre os microserviços.
- **Escalabilidade**: A arquitetura de microserviços permite escalar partes individuais da aplicação conforme necessário, proporcionando flexibilidade e desempenho otimizado.



### Outras Tecnologias:

- **Lombok**: Utilizado para reduzir a verbosidade do código, gerando automaticamente getters, setters e outros métodos.
- **Oracle Database**: Banco de dados utilizado para armazenar e gerenciar os dados da aplicação.
- **Data Transfer Objects (DTOs)**: Utilizados para consultas e persistência de dados, garantindo a integridade e consistência das informações.
- **Validação e Tratamento de Exceções Avançados**: Implementados para garantir a confiabilidade e robustez da aplicação em cenários complexos.
- **JPQL (Java Persistence Query Language)**: Utilizado para consultas personalizadas, paginação e ordenação de resultados.
- **Autenticação JWT (JSON Web Token)**: Implementada para garantir a segurança dos serviços e dados da aplicação.
- **Docker**: Gerenciamento e execução de aplicações em containers.





### Como Testar:

1. Faça o download ou clone o repositório do projeto.

2. Caso queira somente ter a aplicação através da imagem Docker para finalidade de teste, execute o comando abaixo para criar e iniciar um contêiner da a aplicação:

   ```
   docker container run --name meu-app -d -p 8080:8080 fabio1934/spring-fiap:1.0
   ```

3. Importe o arquivo Insomnia que está na raiz do projeto para ter acesso aos endpoints e testá-los.

4. Comece pelo gerenciamento de usuários, realizando o registro e login conforme descrito na documentação.

5. Após o login, obtenha o Token de acesso Bearer para utilizar nos demais métodos disponíveis.



