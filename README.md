### Описание

___
Тестовое задание. Компания "Фабрика Решений"

### Реализовано

___

- авторизация в системе (регистрация не нужна)
- добавление/изменение/удаление опросов. Атрибуты опроса: название, дата старта, дата окончания, описание. После создания поле "дата старта" у опроса менять нельзя
- добавление/изменение/удаление вопросов в опросе. Атрибуты вопросов: текст вопроса, тип вопроса (ответ текстом, ответ с выбором одного варианта, ответ с выбором нескольких вариантов)
___
- ~~получение списка активных опросов~~
- прохождение опроса: опросы можно проходить анонимно, в качестве идентификатора пользователя в API передаётся числовой ID, по которому сохраняются ответы пользователя на вопросы; один пользователь может участвовать в любом количестве опросов
- получение пройденных пользователем опросов с детализацией по ответам (что выбрано) по ID уникальному пользователя
### Технологии и подход к разработке

___

- REST + Open API (swagger)
- ORM
- Service layer
- БД H2 для разработки
- Liquibase
- Spring MVC
- Spring Security
- Spring Data JPA

### Требования

___

* OpenJDK_17
* Gradle 7.3
* Make

### Запуск

___
Генерация миграций БД

```makefile
  make generate-migrations
  ```

Старт приложения

```makefile
  make start
```

Приложение будет запущено по адресу https://localhost:5000/


### Open-Api

___
Интерактивная документация (Swagger) после запуска приложения доступна по https://localhost:5000/swagger-ui.html

### Тестовые данные

___
Логин - пароль

- admin - admin_pass
- Alexis - 12345
- Sam - 12345