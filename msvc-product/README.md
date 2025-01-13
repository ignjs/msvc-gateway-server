# Proyecto:msvc-products

Este proyecto es un microservicio de producto desarrollado con Spring Cloud. Su finalidad es educativa y está diseñado para enseñar los conceptos básicos de microservicios y cómo integrarlos utilizando Spring Cloud.

## Requisitos

- Java 21 o superior
- Maven 3.6.3 o superior
- Spring Boot 3.4.1 o superior

## Instalación

1. Navega al directorio del proyecto:
	```bash
	cd msvc-product
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

## Endpoints

- `GET /products`: Obtiene la lista de productos.
- `GET /products/{id}`: Obtiene un producto por su ID.
- `POST /products`: Crea un nuevo producto.
- `PUT /products/{id}`: Actualiza un producto existente.
- `DELETE /products/{id}`: Elimina un producto por su ID.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
