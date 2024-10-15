# Proyecto Pokemon Bankaya

## Miguel de la Concha 

## Descripción

La siguiente aplicación expone 2 metodos SOAP que pueden ser consumidos con SOAP UI
- getPokemon
- pokemonAbilities

A su vez, consumimos el API via REST - GET de https://pokeapi.co/ para obtener la información de los pokemones.
Esta información es almacenada en una base de datos H2 en memoria.
Que consiste en una tabla donde guardamos información de la invocación del servicio.

Se implementaron pruebas unitarias para 2 clases controllers 
y la información de esta se puede visualizar en el sonarqube.
Esta herramienta puede ser ejecutada con el Docker compose


## Tecnologías

- **SOAP**: Proporciona endpoints para obtener ser invocado mediante herramientas como SOAP UI.
- **API REST**: Proporciona endpoints para obtener información sobre los Pokémon.
- **Spring Boot**: Utiliza el framework Spring Boot para facilitar la configuración y el desarrollo.
- **Maven**: Gestión de dependencias y construcción del proyecto.
- **Base de Datos H2**: Base de datos en memoria para el desarrollo.
- **Swagger/OpenAPI**: Documentación interactiva de la API.
- **SonarQube**: Análisis estático del código para asegurar la calidad.

## Requisitos

- Java 17+
- Maven 3.6+
- Spring Boot 3.3.4
- SonarQube (opcional, para análisis de código)

## Instalación

1. Clona el repositorio:
    ```sh
    Puedes clonar el repositorio con el siguiente comando:
   
    git clone https://github.com/cogm940302/pokemon-bnky.git
    ```
2. El proyecto cuenta con Docker para su ejecución, por lo que puedes ejecutar los siguientes comandos:
    ```sh
    docker build -t pokemon-soap .
   
   docker run -p 8080:8080 pokemon-soap
    ```

3. Para construir el proyecto puedes ejecutar el siguiente comando:
    ```sh
    mvn clean install
    ```

4. Para ejecutar el proyecto puedes ejecutar el siguiente comando:
    ```sh
    mvn spring-boot:run
    ```

## Uso

### Endpoints
URL del Swagger: 
   ```sh
    http://localhost:8080/swagger-ui/index.html
   ```

   En la herramienta de consumo colocar la URL
   ```sh
    http://localhost:8080/ws/pokemon.wsdl
   ```
Esto generará los métodos correspondientes.

- **Parámetro de entrada**: Cada método recibe el nombre del pokemon.

   ```sh
    getPokemon
  
  <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:pok="http://poke.bankaya/pokemon">
   <soapenv:Header/>
   <soapenv:Body>
      <pok:getPokemonRequest>
         <pok:name>raichu</pok:name>
      </pok:getPokemonRequest>
   </soapenv:Body>
   </soapenv:Envelope>
   ```

   ```sh
    pokemonAbilities
  
  <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:pok="http://poke.bankaya/pokemon">
   <soapenv:Header/>
   <soapenv:Body>
      <pok:pokemonAbilitiesRequest>
         <pok:name>raichu</pok:name>
      </pok:pokemonAbilitiesRequest>
   </soapenv:Body>
   </soapenv:Envelope>
   ```
