# challenge_backend
# API REST - Cálculo con Porcentaje Dinámico

Este proyecto es una API REST desarrollada con **Spring Boot** y **PostgreSQL** en Docker.  
La API permite calcular una suma con un porcentaje dinámico, almacenando el historial de llamadas en una base de datos.

---

#**Requisitos Previos**
Asegúrate de tener instalados en tu sistema:
- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Maven](https://maven.apache.org/install.html)
- Java 21 ([OpenJDK](https://jdk.java.net/21/))

---

#**Ejecutar el Proyecto con Docker**
1. **Clonar el repositorio**
   git clone https://github.com/LuisFer2500/challenge_backend.git
2. **Descargar la imagen de DockerHub**
	https://hub.docker.com/r/luisrodriguez2506/desafio_backend
3. **Construir el JAR con Maven**
	mvn clean package -DskipTests
4. **Levantar los contenedores de la API y la base de datos**
	docker-compose up --build
5. **URL del Swagger**	
	http://localhost:8080/swagger-ui/index.html
6. **Verificar que la API está corriendo**
	curl -X GET "http://localhost:8080/api/calcular?num1=10&num2=5"
	curl -X GET "http://localhost:8080/api/historial"

7. **Respuestas del postman**
	**Calcular**
		15.03526106059444
	**Historial de llamada**
	{
		"content": [
			{
				"id": 1,
				"timestamp": "2025-03-09T00:40:36.66657",
				"endpoint": "/api/calcular",
				"parameters": "num1=10.0, num2=5.0",
				"response": "Resultado: 15.091560350976604"
			},
			{
				"id": 2,
				"timestamp": "2025-03-09T06:18:49.205882",
				"endpoint": "/api/calcular",
				"parameters": "num1=10.0, num2=5.0",
				"response": "Resultado: 15.009461530302925"
			},
			{
				"id": 3,
				"timestamp": "2025-03-09T06:18:54.818835",
				"endpoint": "/api/calcular",
				"parameters": "num1=10.0, num2=5.0",
				"response": "Resultado: 15.009461530302925"
			},
			{
				"id": 4,
				"timestamp": "2025-03-09T06:18:58.280403",
				"endpoint": "/api/calcular",
				"parameters": "num1=10.0, num2=5.0",
				"response": "Resultado: 15.009461530302925"
			},
			{
				"id": 5,
				"timestamp": "2025-03-09T07:11:51.733768",
				"endpoint": "/api/calcular",
				"parameters": "num1=10.0, num2=5.0",
				"response": "Resultado: 15.03526106059444"
			},
			{
				"id": 6,
				"timestamp": "2025-03-09T07:11:54.720053",
				"endpoint": "/api/calcular",
				"parameters": "num1=10.0, num2=5.0",
				"response": "Resultado: 15.03526106059444"
			},
			{
				"id": 7,
				"timestamp": "2025-03-09T07:12:11.118647",
				"endpoint": "/api/calcular",
				"parameters": "num1=10.0, num2=5.0",
				"response": "Resultado: 15.03526106059444"
			}
		],
		"pageable": {
			"pageNumber": 0,
			"pageSize": 10,
			"sort": {
				"empty": true,
				"sorted": false,
				"unsorted": true
			},
			"offset": 0,
			"paged": true,
			"unpaged": false
		},
		"last": true,
		"totalPages": 1,
		"totalElements": 7,
		"size": 10,
		"number": 0,
		"sort": {
			"empty": true,
			"sorted": false,
			"unsorted": true
		},
		"first": true,
		"numberOfElements": 7,
		"empty": false
	}
8. **Detener los Contenedores**
	docker-compose down
	**para limpiar los volúmenes de PostgreSQL**
	docker-compose down -v
9. ** Tecnologías Usadas **
	Spring Boot 3.2.2
	JDK 21
	PostgreSQL 15
	Docker & Docker Compose
	Maven
	Lombok
	JUnit, Mockito
	Cache, caffeine
	
	



   

