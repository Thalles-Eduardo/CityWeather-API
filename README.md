<h1 align="center">
  CityWeather-API
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=License&message=MIT&color=8257E5&labelColor=000000" alt="License" />
</p>

O projeto foi implementado visando a utilização de API de terceiro, neste caso foi utilizado a API da [OpenWeatherMap](https://openweathermap.org/api)
para a consulta climática de um certa cidade passada na API.


## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Security](https://spring.io/projects/spring-security)
- [Swagger](https://swagger.io/)
- [RestTemplate](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html)
- [Docker](https://www.docker.com)


## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Injeção de Dependências
- Documentação
- Consultar em API externa
- Teste unitário
- Teste de integração
- Dockernização


## Como Executar Sem Docker

- Clonar repositório git
```bash
git clone https://github.com/Thalles-Eduardo/CityWeather-API
```
- Executar a aplicação sem docker:
```bash
./mvnw spring-boot:run
```

## Como Executar Com Docker

- Clonar repositório git
```bash
git clone https://github.com/Thalles-Eduardo/CityWeather-API
```
- Executar a aplicação pelo docker:
```bash
 docker build -t cityweather .
 docker run -p 8080:8080 cityweather
```


## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [Postman](https://www.postman.com/downloads/) ou pode ser feito pelo [Swagger](http://localhost:8080/swagger-ui/index.html).

- Pesquisar por cidade

![Pesquisar por cidade](https://github.com/Thalles-Eduardo/CityWeather-API/assets/69612509/f3350b18-f160-413a-9991-3b0da78a1b4d)


# Author

Thalles Eduardo Dias da Silva

- [Linkedin](https://linkedin.com/in/thalles-eduardo-7297a6237)
