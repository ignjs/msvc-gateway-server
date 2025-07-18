# Proyecto: msvc-gateway-server

Este proyecto es un servidor de gateway utilizando Spring Cloud. Su finalidad es educativa y está diseñado para enseñar cómo configurar y utilizar un gateway en una arquitectura de microservicios.

## Requisitos

- Java 21 o superior
- Maven 3.6.3 o superior
- Spring Boot 3.4.1 o superior

## Instalación

1. Navega al directorio del proyecto:
	```bash
	cd msvc-gateway-server
	```
2. Compila el proyecto utilizando Maven:
	```bash
	mvn clean install
	```

## Ejecución

1. Ejecuta la aplicación:
	```bash
	mvn spring-boot:run
	```
2. La aplicación estará disponible en `http://localhost:8080`.

## Configuración

El archivo de configuración principal se encuentra en `src/main/resources/application.yml`. Aquí puedes configurar las rutas y filtros del gateway.

## Estructura del Proyecto

- `src/main/java`: Contiene el código fuente del proyecto.
- `src/main/resources`: Contiene los archivos de configuración y recursos estáticos.
- `pom.xml`: Archivo de configuración de Maven.

## Trazabilidad con Zipkin

El proyecto utiliza Zipkin para la trazabilidad distribuida de las solicitudes entre microservicios.  
Para ejecutar Zipkin usando MySQL como almacenamiento, utiliza el siguiente comando:

```sh
STORAGE_TYPE=mysql MYSQL_USER=zipkin MYSQL_PASS=zipkin java -jar zipkin.jar
```

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.