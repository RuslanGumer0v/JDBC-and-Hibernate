# JDBC-and-Hibernate
## Практическая задача на JDBC

В этом задании мы познакомимся с такими технологиями, как:
Maven  - https://www.apache-maven.ru/ <br />
JDBC - https://o7planning.org/ru/10167/java-jdbc-tutorial <br /> <br />
*Для выполнения задания необходимо:*
1. Клонировать/скачать заготовку по ссылке https://github.com/jm-program/CoreTaskTemplate.git
2. Установить на компьютер MySqlServer и Workbench. Создать подключение и схему через Workbench. Протестировать возможность соединения с базой через идею с помощью встроенной утилиты.

### Описание задачи:

Необходимо ознакомиться с заготовкой и доработать приложение, которое взаимодействует с базой оперируя пользователем ( класс User ) и проверить свои методы заранее написанными JUnit тестами. По итогу все тесты должны быть пройдены.

Для запуска теста необходимо найти класс в папке test и при нажатии на него правой кнопкой мыши запустить, выбрав Run "Имя класса" 

Класс UserHibernateDaoImpl в рамках этой задачи не затрагивается (остаётся пустой)

*__User__ представляет из себя сущность с полями:*
- Long id
- String name
- String lastName
- Byte age

Архитектура приложения создана с опорой на паттерн проектирования MVC ( частично, у нас не WEB приложение)

Ознакомиться с паттерном можно здесь https://pro-java.ru/patterny-proektirovaniya-java/chto-takoe-pattern-proektirovaniya-mvc-v-java/

### Требования к классам приложения:
1. Классы dao/service должны реализовывать соответствующие интерфейсы
2. Класс dao должен иметь конструктор пустой/по умолчанию
3. Все поля должны быть private
4. service переиспользует методы dao
5. Обработка всех исключений, связанных с работой с базой данных должна находиться в dao
6. Класс Util должен содержать логику настройки соединения с базой данных

### Необходимые операции:
1. Создание таблицы для User(ов) – не должно приводить к исключению, если такая таблица уже существует
2. Удаление таблицы User(ов) – не должно приводить к исключению, если таблицы не существует
3. Очистка содержания таблицы
4. Добавление User в таблицу
5. Удаление User из таблицы ( по id )
6. Получение всех User(ов) из таблицы

### Алгоритм работы приложения:

*В методе main класса Main должны происходить следующие операции:*
1. Создание таблицы User(ов)
2. Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
3. Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
4. Очистка таблицы User(ов)
5. Удаление таблицы

## Практическая задача на HIBERNATE

В этом задании мы познакомимся с фреймворком Hibernate и научимся взаимодействовать с помощью него с базой данных.

*Для выполнения задания необходимо:*
1. Ознакомиться с Hibernate. Подробнее узнать о Hibernate можно Здесь https://hibernate.org/orm/
2. Готовая прошлая задача ( работа будет происходить в этом же проекте )

### Описание задачи:

В прошлой задаче мы познакомились с Maven и JDBC, доработали приложение, взаимодействующее с базой данных.

На этот раз обратим внимание на класс UserHibernateDaoImpl, который реализует тот же интерефейс, что и UserDaoJdbcImpl.

В рамках этой задачи необходимо реализовать взаимодействие с базой данных с помощью Hibernate и дописать методы в классе UserHibernateDaoImpl, проверить свои методы заранее написанными JUnit тестами из заготовки.

### Требования к классам приложения:
1. UserHibernateDaoImpl должен реализовывать интерефейс UserDao
2. В класс Util должна быть добавлена конфигурация для Hibernate ( рядом с JDBC), без использования xml.
3. Service на этот раз использует реализацию dao через Hibernate
4. Методы создания и удаления таблицы пользователей в классе UserHibernateDaoImpl должны быть реализованы с помощью SQL.

### Необходимые операции:
1. Создание таблицы для User(ов) – не должно приводить к исключению, если такая таблица уже существует
2. Удаление таблицы User(ов) – не должно приводить к исключению, если таблицы не существует
3. Очистка содержания таблицы
4. Добавление User в таблицу
5. Удаление User из таблицы ( по id )
6. Получение всех User(ов) из таблицы

### Алгоритм работы приложения:
*В методе main класса Main должны происходить следующие операции:*
1. Создание таблицы User(ов)
2. Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
3. Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
4. Очистка таблицы User(ов)
5. Удаление таблицы
