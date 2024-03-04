<h1 align="center">
  CAR SERVICE SALES
</h1>

Este projeto é uma API utlizando o conceito de microservicos para criar um sistema de armazanento de carros disponíveis para venda 
além de fornecer dados analíticos sobre os carros, utilizando o KAFKA para produzir e consumir informações


## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [MySQL](https://www.mysql.com/)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Docker](https://www.docker.com/products/docker-desktop/)
- [Apache Kafka](https://kafka.apache.org)


## Como Executar

- Clonar repositório git
```
git clone git@github.com:igorbarret0/car-sales-api.git
```

- Construir o projeto:
```
./mvnw clean package
```

- Iniciar 0 Kafka:
```
docker-compose up -d
```


A API poderá ser acessada em [localhost:8085](http://localhost:8085).

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [Postman](https://www.postman.com/)

-  CarPostController
```
POST /api/car/post - Cadastrar um novo carro
GET /api/car/posts - Recuperar todos os carros cadastrados
PUT /api/car/{id} - Atualizar o registro de um carro 
DELETE /api/product/{id} - Deletar um carro
```

-  OwnerPostController
```
POST /owner - Cadastro um novo proprietário
```

