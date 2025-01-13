# Proyecto eureka-server

Este proyecto es un servidor Eureka, parte del ecosistema de Spring Cloud. Su finalidad es educativa, permitiendo a los desarrolladores aprender cómo configurar y utilizar un servidor de descubrimiento de servicios.

## Requisitos

- Java 21 o superior
- Maven 3.6.3 o superior
- IDE de su preferencia (IntelliJ IDEA, Eclipse, etc.)

## Paso a Paso

### 1. Compilar el proyecto

```bash
mvn clean install
```

### 2. Ejecutar el servidor Eureka

```bash
mvn spring-boot:run
```

### 3. Acceder al panel de Eureka

Abra su navegador y vaya a `http://localhost:8761`. Debería ver el panel de Eureka donde se listarán los servicios registrados.

## Configuración

El archivo principal de configuración se encuentra en `src/main/resources/application.yml`. Aquí puede ajustar las propiedades del servidor Eureka según sus necesidades.

```yaml
server:
	port: 8761

eureka:
	client:
		register-with-eureka: false
		fetch-registry: false
	server:
		enable-self-preservation: false
```

## Contribuciones

Las contribuciones son bienvenidas. Por favor, haga un fork del repositorio y envíe un pull request con sus cambios.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulte el archivo `LICENSE` para más detalles.
