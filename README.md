# TrabajoIndividual-TT1-Docs

Este proyecto es la parte del trabajo individual de la practica 3 y 4 de la asignatura **Taller Transversal I: Programación y Proceso de Información** de la Universidad de La Rioja (curso 25/26)

## Autor

*Santiago Die Morejón* – Universidad de La Rioja

## Descripción del Proyecto

Este proyecto es una aplicación web que permite a los usuarios:
- Solicitar simulaciones especificando cantidades de diferentes entidades
- Validar datos de entrada con mensajes de error detallados
- Obtener un token único para cada solicitud de simulación
- Visualizar los resultados de simulaciones en una grilla interactiva
- Gestionar el envío de notificaciones por email a destinatarios
- Consumir un servicio externo REST (ServicioConsumible) mediante un cliente OpenAPI generado automáticamente

El sistema está construido sobre Spring Boot 4.0.3 con Java 17, utilizando Thymeleaf para las vistas y servicios REST para la comunicación.

## Requisitos Previos

- Java 17
- Maven 3.9.6 (incluido Maven Wrapper en el proyecto)
- Un IDE compatible con Java
- El servicio externo ServicioConsumible corriendo en `http://localhost:8080` (para el cliente OpenAPI)

## Uso

### Solicitar una Simulación

1. Navega a `http://localhost:8080/solicitud`
2. Completa el formulario con las cantidades deseadas para cada entidad:
3. Envía el formulario
4. El sistema validará los datos y:
   - Si hay errores, mostrará mensajes de validación
   - Si es exitoso, devolverá un token único para la simulación

### Visualizar una Simulación

1. Navega a `http://localhost:8080/grid?tok=<token>`
2. El sistema descargará los datos de la simulación y mostrará:
   - Una grilla visual con los puntos de la simulación
   - Colores diferenciados para cada punto
   - Evolución temporal de la simulación


## Estructura del Proyecto

```
trabajo-individual-tt1-testing-sadie27/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/tt1/trabajo/
│   │   │   │   ├── SolicitudController.java      # Controlador web principal
│   │   │   │   ├── GridController.java           # Controlador de visualización de grilla
│   │   │   │   └── TrabajoApplication.java       # Clase principal de Spring Boot
│   │   │   │
│   │   │   ├── interfaces/
│   │   │   │   ├── InterfazContactoSim.java      # Interfaz para servicio de simulación
│   │   │   │   └── InterfazEnviarEmails.java     # Interfaz para servicio de emails
│   │   │   │
│   │   │   ├── modelo/
│   │   │   │   ├── DatosSimulation.java          # Modelo de datos de simulación
│   │   │   │   ├── DatosSolicitud.java           # Modelo de solicitud
│   │   │   │   ├── Destinatario.java             # Modelo de destinatario de email
│   │   │   │   ├── Entidad.java                  # Modelo de entidad simulable
│   │   │   │   └── Punto.java                    # Modelo de punto en la grilla
│   │   │   │
│   │   │   ├── servicios/
│   │   │   │   ├── ContactoSimService.java       # Servicio de gestión de simulaciones
│   │   │   │   ├── EnviarEmailsService.java      # Servicio de envío de emails
│   │   │   │   └── LoggerConfig.java             # Configuración de logging
│   │   │   │
│   │   │   └── utilidades/                       # Cliente OpenAPI generado (ServicioConsumible)
│   │   │       ├── ApiClient.java                # Cliente HTTP central (RestTemplate)
│   │   │       ├── BaseApi.java                  # Clase base para todas las APIs
│   │   │       ├── EmailApi.java                 # Cliente para /Email
│   │   │       ├── ResultadosApi.java            # Cliente para /Resultados
│   │   │       ├── SolicitudApi.java             # Cliente para /Solicitud/*
│   │   │       ├── JavaTimeFormatter.java        # Utilidad de fechas
│   │   │       ├── ServerConfiguration.java      # Configuración de servidor
│   │   │       ├── ServerVariable.java           # Variables de servidor
│   │   │       ├── auth/
│   │   │       │   ├── Authentication.java       # Interfaz de autenticación
│   │   │       │   ├── ApiKeyAuth.java           # Autenticación por API key
│   │   │       │   ├── HttpBasicAuth.java        # Autenticación Basic
│   │   │       │   └── HttpBearerAuth.java       # Autenticación Bearer token
│   │   │       └── modelo/
│   │   │           ├── Solicitud.java            # DTO de solicitud al servicio externo
│   │   │           ├── EmailResponse.java        # DTO de respuesta de email
│   │   │           └── ProblemDetails.java       # DTO de error RFC 7807
│   │   │
│   │   └── resources/
│   │       ├── application.properties            # Configuración de la aplicación
│   │       └── templates/
│   │           ├── solicitud.html                # Vista del formulario
│   │           ├── formResult.html               # Vista de resultados
│   │           └── grid.html                     # Vista de grilla de simulación
│   │
│   └── test/
│       └── java/com/tt1/trabajo/
│           ├── ContactoSimServiceTest.java           # Tests del servicio de simulación
│           ├── EnviarEmailsServiceTest.java          # Tests del servicio de emails
│           └── utilidades/
│               └── ServicioConsumibleClientTest.java # Test de integración del cliente OpenAPI
│
├── .mvn/wrapper/                 
├── pom.xml                                       # Configuración de Maven
├── mvnw                                          # Maven Wrapper (Linux/Mac)
├── mvnw.cmd                                      # Maven Wrapper (Windows)
└── README.md                                     # Este archivo
```

## Tests

Los tests incluyen:
- `ContactoSimServiceTest`: Pruebas unitarias del servicio de simulaciones (tokens, entidades, validación de IDs)
- `EnviarEmailsServiceTest`: Pruebas unitarias del servicio de emails con Mockito
- `ServicioConsumibleClientTest`: Test de integración del cliente OpenAPI contra el servicio externo en `http://localhost:8080`

## Tecnologías Utilizadas

- **Spring Boot 4.0.3**: Framework principal
- **Spring MVC**: Para controladores web
- **Thymeleaf**: Motor de plantillas para las vistas
- **Spring REST Client / RestTemplate**: Para comunicación REST
- **OpenAPI Generator 7.21.0**: Generación automática del cliente HTTP
- **Maven 3.9.6**: Gestión de dependencias y construcción
- **JUnit 5**: Framework de testing
- **Mockito**: Mocking en tests unitarios

## Licencia

Este proyecto está bajo la licencia especificada en el archivo LICENSE.
