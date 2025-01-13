# Proyecto Spring Cloud
Este proyecto es una implementación educativa de un sistema de microservicios utilizando Spring Cloud. El objetivo es aprender y demostrar cómo se pueden construir y gestionar microservicios utilizando diversas tecnologías de Spring Cloud, como Eureka, Feign, y Spring Cloud Gateway.

## Estructura del Proyecto
El proyecto está dividido en varios módulos, cada uno representando un microservicio independiente:

- eureka-server: Servidor de registro Eureka.
- msvc-items: Microservicio de gestión de ítems.
- msvc-product: Microservicio de gestión de productos.
- msvc-gateway-server: Servidor de gateway para enrutar las 
solicitudes a los microservicios correspondientes.

## Requisitos Previos
- Java 21 o superior
- Maven 3.9.9 o superior
- MySQL (para el microservicio de productos)

## Configuración
### Base de Datos
Asegúrate de tener una instancia de MySQL en ejecución y crea una base de datos llamada db_springboot_cloud. Configura las credenciales de acceso en el archivo application.properties del microservicio de productos.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_springboot_cloud
spring.datasource.username=root
spring.datasource.password=Asdqwe123
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

### Eureka Server
El servidor Eureka actúa como un registro de servicios donde todos los microservicios se registran y descubren entre sí. Para iniciar el servidor Eureka, navega al directorio eureka-server y ejecuta:

```bash
./mvnw spring-boot:run
```

### Microservicios
Cada microservicio se puede iniciar de manera similar. Navega al directorio del microservicio correspondiente y ejecuta:

```bash
./mvnw spring-boot:run
```

Por ejemplo, para iniciar el microservicio de ítems:

```bash
./mvnw spring-boot:run
```

### Gateway Server
El servidor de gateway enruta las solicitudes a los microservicios correspondientes. Para iniciar el servidor de gateway, navega al directorio msvc-gateway-server y ejecuta:

```bash
./mvnw spring-boot:run
```

## Endpoints
### Eureka Server
URL: http://localhost:8761

### Microservicio de Ítems
URL Base: http://localhost:8002
Endpoints:
/api/items/**

### Microservicio de Productos
URL Base: http://localhost:8001
Endpoints:
/api/products/**

### Gateway Server
URL Base: http://localhost:8080
Endpoints:
/api/items/** (enrutado al microservicio de ítems)
/api/products/** (enrutado al microservicio de productos)

## Objetivo Educativo
Este proyecto tiene como objetivo enseñar los conceptos básicos de los microservicios y cómo se pueden implementar utilizando Spring Cloud. Los temas cubiertos incluyen:

- Registro y descubrimiento de servicios con Eureka.
- Comunicación entre microservicios utilizando Feign.
- Enrutamiento de solicitudes utilizando Spring Cloud Gateway.
- Gestión de configuración y propiedades de los microservicios.

## Contribuciones
Las contribuciones son bienvenidas. Si encuentras algún problema o tienes alguna sugerencia, por favor abre un issue o envía un pull request.

## Licencia
Este proyecto está licenciado bajo la Licencia Apache 2.0. Puedes ver más detalles en el archivo LICENSE.