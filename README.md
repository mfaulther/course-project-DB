# course-project-DB
Курсовой проект по дисциплине "Базы Данных"

## Инструкция по запуску 
* С помощью Maven
```
./mvnw package
java -jar target/*.jar
```

Или
```
./mvnw spring-boot:run
```

* С помощью Docker
```
docker build -t courseproject .
docker run -p 8080:8080 -t courseproject
```
