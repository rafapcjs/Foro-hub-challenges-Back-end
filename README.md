
markdown
Copiar código
# 📚 Proyecto Foro Hub con Spring Boot, MySQL, JWT y Spring Security

## 📋 Resumen
Este proyecto es una implementación de un foro backend utilizando Spring Boot, MySQL para la persistencia de datos, JWT (JSON Web Tokens) para la autenticación, Spring Security para asegurar los endpoints y OpenAPI (Swagger) para la documentación de la API.

## 🛠 Tecnologías utilizadas
- **Spring Boot**: Framework para crear aplicaciones de Spring independientes y listas para producción.
- **MySQL**: Base de datos relacional utilizada para el almacenamiento y recuperación de datos.
- **JWT (JSON Web Tokens)**: Utilizado para la autenticación segura entre las partes.
- **Spring Security**: Proporciona autenticación, autorización y protección contra vulnerabilidades comunes.
- **OpenAPI (Swagger)**: Herramientas de documentación y diseño de API para desarrolladores y equipos.

## 📋 Requisitos previos
- JDK 8 o superior instalado
- Herramienta de construcción Maven o Gradle instalada
- Servidor MySQL instalado y en ejecución
- IDE (IntelliJ IDEA, Eclipse, etc.) con soporte para Spring Boot

## 🚀 Instrucciones de configuración
1. Clona el repositorio:
   ```bash
   git clone https://github.com/rafapcjs/Foro-hub-challenges-Back-end.git
   cd Foro-hub-challenges-Back-end
Configuración de la base de datos:

Crea una base de datos MySQL llamada foro_hub.
Actualiza src/main/resources/application.properties con la configuración de tu base de datos MySQL:
properties
Copiar código
spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
Ejecuta la aplicación:

bash
Copiar código
mvn spring-boot:run
🔒 Seguridad
Este proyecto utiliza JWT (JSON Web Tokens) para la autenticación de usuarios y Spring Security para proteger los endpoints de la API. Asegúrate de configurar correctamente las propiedades de seguridad en el archivo application.properties.

📄 Documentación de la API
Para acceder a la documentación de la API generada con Swagger, inicia la aplicación y navega a:

bash
Copiar código
http://localhost:8080/swagger-ui.html
🤝 Contribuciones
Las contribuciones son bienvenidas. Si deseas contribuir, por favor sigue los pasos a continuación:

Haz un fork del proyecto.
Crea una rama con tu nueva funcionalidad (git checkout -b nueva-funcionalidad).
Realiza tus cambios y haz commit (git commit -am 'Añadir nueva funcionalidad').
Haz push a la rama (git push origin nueva-funcionalidad).
Crea un nuevo Pull Request.
