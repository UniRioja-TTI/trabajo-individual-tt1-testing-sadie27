# TrabajoIndividual-TT1-Tests

Este proyecto es la parte del trabajo individual de la practica 3 de la asignatura **Taller Transversal I: Programación y Proceso de Información** de la Universidad de La Rioja (curso 25/26)

## Autor

*Santiago Die Morejón* – Universidad de La Rioja

## Descripción del Proyecto

Este proyecto es una aplicación web que permite a los usuarios:
- Solicitar simulaciones especificando cantidades de diferentes entidades
- Validar datos de entrada con mensajes de error detallados
- Obtener un token único para cada solicitud de simulación
- Gestionar el envío de notificaciones por email a destinatarios

El sistema está construido sobre Spring Boot 4.0.3 con Java 17, utilizando Thymeleaf para las vistas y servicios REST para la comunicación.

## Requisitos Previos

- Java 17
- Maven 3.6+ (incluido Maven Wrapper en el proyecto)
- Un IDE compatible con Java 

## Uso

### Solicitar una Simulación

1. Navega a `http://localhost:8080/solicitud`
2. Completa el formulario con las cantidades deseadas para cada entidad:
3. Envía el formulario
4. El sistema validará los datos y:
   - Si hay errores, mostrará mensajes de validación
   - Si es exitoso, devolverá un token único para la simulación

### Validaciones

El sistema valida que:
- Todos los valores sean números enteros
- No se ingresen valores negativos
- Los IDs de entidades sean válidos

## Estructura del Proyecto

```
trabajo-individual-tt1-testing-sadie27/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/tt1/trabajo/
│   │   │   │   ├── SolicitudController.java      # Controlador web principal
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
│   │   │   │   └── Entidad.java                  # Modelo de entidad simulable
│   │   │   │
│   │   │   └── servicios/
│   │   │       ├── ContactoSimService.java       # Servicio de gestión de simulaciones
│   │   │       ├── EnviarEmailsService.java      # Servicio de envío de emails
│   │   │       └── LoggerConfig.java             # Configuración de logging
│   │   │
│   │   └── resources/
│   │       ├── application.properties            # Configuración de la aplicación
│   │       └── templates/
│   │           ├── solicitud.html                # Vista del formulario
│   │           └── formResult.html               # Vista de resultados
│   │
│   └── test/
│       └── java/com/tt1/trabajo/
│           ├── ContactoSimServiceTest.java       # Tests del servicio de simulación
│           └── EnviarEmailsServiceTest.java      # Tests del servicio de emails
│
├── pom.xml                                       # Configuración de Maven
├── mvnw                                          # Maven Wrapper (Linux/Mac)
├── mvnw.cmd                                      # Maven Wrapper (Windows)
└── README.md                                     # Este archivo
```

## Tests

Los tests incluyen:
- `ContactoSimServiceTest`: Pruebas del servicio de simulaciones
- `EnviarEmailsServiceTest`: Pruebas del servicio de emails

## Tecnologías Utilizadas

- **Spring Boot 4.0.3**: Framework principal
- **Spring MVC**: Para controladores web
- **Thymeleaf**: Motor de plantillas para las vistas
- **Spring REST Client**: Para comunicación REST
- **Maven**: Gestión de dependencias y construcción
- **JUnit**: Framework de testing

## Licencia

Este proyecto está bajo la licencia especificada en el archivo LICENSE.
