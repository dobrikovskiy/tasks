Приложение To-Do List на Spring Boot
Простое приложение для управления списком задач, созданное с использованием Spring Boot, Thymeleaf и Spring Security. Это приложение позволяет пользователям создавать, просматривать, обновлять и удалять задачи в своем списке дел. Также включены функции создания учетной записи и входа в систему.

Возможности
CRUD-операции: Пользователи могут создавать, просматривать, обновлять и удалять задачи.

Создание учетной записи: Новые пользователи могут зарегистрироваться и создать свои учетные записи.

Аутентификация пользователей: Безопасный вход в систему с использованием Spring Security.

Хеширование паролей: Пароли пользователей надежно хешируются для хранения.

Шаблонизация Thymeleaf: Фронтенд-представления формируются с использованием шаблонов Thymeleaf.

Используемые технологии
Spring Boot: Фреймворк для создания автономных, производственных Spring-приложений.

Thymeleaf: Современный серверный Java-шаблонизатор для веб- и автономных сред.

Spring Security: Мощный и настраиваемый фреймворк для аутентификации и контроля доступа.

Spring Data JPA: Упрощает доступ к данным и их сохранение с использованием Java Persistence API.

Hibernate: Инструмент для объектно-реляционного отображения на языке Java.

MySQL/PostgreSQL/H2 Database: Выберите предпочитаемую реляционную базу данных для хранения.

Начало работы
Необходимые условия
Java JDK (8 или выше)
Maven
Предпочитаемая IDE (IntelliJ IDEA, Eclipse и т.д.)
MySQL/PostgreSQL/H2 Database (Убедитесь, что она установлена и запущена)

Установка
Клонируйте этот репозиторий:

bash
Copy
git clone git clone https://github.com/dobrikovskiy/tasks.git
Перейдите в директорию проекта:

bash
Copy
cd todo-list-app
Обновите файл application.properties с вашей конфигурацией базы данных:

properties
Copy
spring.datasource.url=jdbc:mysql://localhost:3306/db_todolist
spring.datasource.username=root
spring.datasource.password=root
Соберите проект:

bash
Copy
mvn clean package
Запустите приложение

Откройте браузер и перейдите по адресу http://localhost:8080, чтобы получить доступ к приложению.

Использование
Создание учетной записи: Нажмите на ссылку "Sign Up", чтобы зарегистрироваться и создать учетную запись.

Вход в систему: После создания учетной записи войдите в систему, используя свои учетные данные.

Управление задачами: Добавляйте, просматривайте, редактируйте, удаляйте задачи из своего списка дел через кнопки добавления, редактирования, удаления задач.
