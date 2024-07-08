 
# Proyecto Foro hub con Spring Boot con MySQL, JWT y Spring Security

## Resumen
Este proyecto es una implementación de ejemplo que utiliza Spring Boot, MySQL para la persistencia de datos, JWT (JSON Web Tokens) para la autenticación, Spring Security para asegurar los endpoints y OpenAPI (Swagger) para la documentación de la API.

## Tecnologías utilizadas
- **Spring Boot**: Framework para crear aplicaciones de Spring independientes y listas para producción.
- **MySQL**: Base de datos relacional utilizada para el almacenamiento y recuperación de datos.
- **JWT (JSON Web Tokens)**: Utilizado para la autenticación segura entre las partes.
- **Spring Security**: Proporciona autenticación, autorización y protección contra vulnerabilidades comunes.
- **OpenAPI (Swagger)**: Herramientas de documentación y diseño de API para desarrolladores y equipos.

## Requisitos previos
- JDK 8 o superior instalado
- Herramienta de construcción Maven o Gradle instalada
- Servidor MySQL instalado y en ejecución
- IDE (IntelliJ IDEA, Eclipse, etc.) con soporte para Spring Boot

## Instrucciones de configuración
1. Clona el repositorio:
   ```bash
   git clone https://github.com/your/repository.git
   cd repository
   ```

2. Configuración de la base de datos:
   - Crea una base de datos MySQL llamada `your_database_name`.
   - Actualiza `application.properties` o `application.yml` con la configuración de tu base de datos MySQL:
     ```yaml
     spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```

3. Ejecuta la aplicación:
Security
