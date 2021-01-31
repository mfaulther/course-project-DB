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

## REST API

### 1. POST /api/students
Принимает на вход данные о студенте в формает JSON и сохраняет
это в БД.

Формат:

Поле | Тип | Значение
--- | --- | ---
*first_name* | string | Имя
*last_name* | string | Фамилия
*birth_date* | string | Дата Рождения
*group_id* | int | Идентификатор группы студента

В случае успеха возвращается ответ с HTTP статусом `201 Created` и идентификатором:

	HTTP 201
	{
		"data": {
			"student_id": 1,
			"info": "Successfully created"
		}
	}

### 2. GET /api/students
Возвращает список всех студентов из БД
```
GET /api/students
```

    HTTP 200 
    {
        "data": [
        {
            "firstName": "Test1",
            "lastName": "Test1",
            "birthDate": "Test3",
            "groupId": 5
        },
        {   
            "firstName": "fsafsd",
            "lastName": "hhghg",
            "birthDate": "ytytrt",
            "groupId": 3
        }   ]
       
    }   
                
### 3. POST /api/groups

Принимает на вход данные о группе в формате JSON и добавляет
в БД.

Формат:

Поле | Тип | Значение
--- | --- | ---
*title* | string | Название группы
*level* | string | Уровень образования (бакалавр, магистр и т.д.)
*direction* | string | Направление подготовки
*facultyId* | int | Идентификатор факультета группы

В случае успеха возвращается ответ с HTTP статусом `201 Created` и идентификатором:

	HTTP 201
	{
		"data": {
			"group_id": 1,
			"info": "Successfully created"
		}
	}



### 4. GET /api/groups

Возвращает информацию о всех группах в формате JSON

    HTTP 200 
    {
        "data": [
        {
            "title": "Test1",
            "level": "Test1",
            "direction": "Test3",
            "facultyId": 3
        },
        {   
            "title": "Test2",
            "level": "Test2",
            "direction": "Test5",
            "facultyId": 7
        }   
            ]
       
    }   
    

### 5. POST /api/faculties

Принимает информацию о факультете в формате JSON и добавляет в БД

Формат:

Поле | Тип | Значение
--- | --- | ---
*faculty_id* | int | Идентификатор факультета
*title* | string | Название факультета
*head* | string | Имя главы факультета

### 6. GET /api/faculties

Возвращает информацию о всех факультетах в формате JSON

    HTTP 200 
    {
        "data": [
        {
            "title": "Факультет Электротехники",
            "head": "Борисов Борис Борисович",
        },
        {   
            "title": "Факультет Робототехники",
            "head": "Иванов Иван Иванович",
        }   
            ]
       
    }   
