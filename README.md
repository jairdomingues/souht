# swarm-micro-service

WildFly Swarm Modules

### Run App

Antes de executar é necessário criar um DB no postgres 9.x com o nome de "swarm". 
Caso queria trocar o nome do BD, favor alterar em "projects-stages.yml"
 

``` sh

$ ./mvnw clean package \
  && java -jar target/swarm-micro-service-thorntail.jar

```

## Usage

criar conta corrente pessoa

``` sh

curl -d '{	"pessoa":	{"apelido": "Nome Testes","documento": "67876572189",	"score": 9},	"idAgencia": "1"}' -H "Content-Type: application/json" \
-X POST http://localhost:8080/api/v1/contas
```

criar produtos ( cartão e especial )

``` sh

curl -d -H "Content-Type: application/json" -X PUT http://localhost:8080/api/v1/contas/{numeroDaContaCorrente}
```


Exemplo lista de pessoas

``` sh

curl -v -H "Content-Type: application/json" localhost:8080/api/v1/pessoas/

```

Exemplo lista de contas

``` sh

curl -v -H "Content-Type: application/json" localhost:8080/api/v1/contas/

```



