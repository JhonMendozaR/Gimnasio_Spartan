# Sistema de Gestión de Gimnasio Spartan

## Descripción General
El sistema de gestión de gimnasio permite administrar socios, planes, entrenadores, membresías y asistencias. 
Facilita el registro de socios, la gestión de planes y entrenadores, la adquisición y control de membresías, 
el registro de asistencias y la generación de reportes de uso e ingresos. Utiliza Java 17+, Spring Boot y una 
base de datos relacional, siguiendo una arquitectura por capas para garantizar escalabilidad y mantenibilidad.

## Arquitectura por Capas
- **Entity**: Clases mapeadas a las tablas de la base de datos (Socio, Plan, Membresía, Asistencia, Entrenador).
- **Dto**: Objetos para transferencia de datos entre capas, evitando exponer entidades directamente.
- **Repository**: Interfaces que extienden JpaRepository para acceso a datos.
- **Service**: Interfaces que definen la lógica de negocio.
- **Impl**: Implementaciones de los servicios.
- **Controller**: Endpoints REST para interacción con el sistema.
- **Config**: Configuraciones generales (Spring, seguridad, CORS, etc.).
- **Exception**: Manejo centralizado de errores y excepciones personalizadas.

## Estructura de Carpetas
```
com/exe/gym/
├── Entity/        # Entidades JPA
├── Dto/           # DTOs para transferencia de datos
├── Repository/    # Interfaces JpaRepository
├── Service/       # Interfaces de servicios
├── Impl/          # Implementaciones de servicios
├── Controller/    # Controladores REST
├── Config/        # Configuraciones generales
└── Exception/     # Manejo de errores
```

## Definición de Entidades y Relaciones
- **Socio**: id, doc, nombres, apellidos, email
- **Plan**: id, nombre, precio, duracion_dias
- **Membresía**: id, id_socio, id_plan, fecha_inicio, fecha_fin, estado (activa, vencida, suspendida)
- **Asistencia**: id, id_socio, fecha_hora
- **Entrenador**: id, nombres, especialidad

### Relaciones
- Un socio puede tener varias membresías (1–*)
- Un plan puede estar asociado a varias membresías (1–*)
- Un socio puede registrar varias asistencias (1–*)
- Un entrenador puede estar vinculado a varios planes (1–*)

## Endpoints REST Disponibles
- **/socios**: CRUD de socios
- **/planes**: CRUD de planes
- **/membresias**: CRUD y gestión de membresías
- **/asistencias**: Registro y consulta de asistencias
- **/entrenadores**: CRUD de entrenadores y vinculación a planes
- **/reportes**: Generación de reportes de uso e ingresos

## Lógica de Validación de Membresía Vigente
Antes de registrar una asistencia, el sistema verifica que el socio tenga una membresía activa y vigente
(fecha actual entre fecha_inicio y fecha_fin, estado = activa). Si no cumple, se rechaza el registro con un 
error personalizado.

## Ejemplo de Flujo de Datos
1. **Controller** recibe una solicitud para registrar asistencia.
2. **Service** valida la membresía vigente del socio.
3. Si la validación es exitosa, se registra la asistencia usando el **Repository**.
4. Si falla, se lanza una excepción personalizada desde **Exception**.
5. El **Controller** responde con el estado HTTP adecuado.

## Guía de Configuración del Entorno
- Instalar **Java 17+**
- Instalar **Maven**
- Clonar el repositorio y ejecutar `mvn clean install`
- Configurar la conexión a la base de datos en `application.properties`
- Usar **Spring Boot Starter** para inicializar el proyecto
- Ejecutar la aplicación con `mvn spring-boot:run`

## Posibles Reportes Generados
- Ingresos por plan
- Visitas por socio
- Planes más adquiridos
- Asistencias por periodo
- Socios con membresía activa/vencida

## Buenas Prácticas
- Código limpio y modular
- Uso de DTOs en controladores
- Manejo de excepciones personalizado
- Nomenclatura y empaquetado estándar Java
- Spring Data JPA para acceso a datos

---
**Autor:** Jhon Alexis Mendoza Rojas

