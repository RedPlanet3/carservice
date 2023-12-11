# carservice

<br>

Сервис по сбору автомобиля - 
бэк-сервис, в котором есть REST API,
позволяющее собрать автомобиль из существующих частей.

**ПО:**
-   Java 17
-   Maven
-   Spring boot 3.2.0
-   Hibernate
-   REST API
-   Docker-compose
-   БД PostgreSQL


Части из которых собирается автомобиль:<br>
Корпус (2 типа: хэтчбек и седан, при желании можно добавить еще какие-то
параметры) — должны уже присутствовать в БД (базе данных)<br>
Колесо (3 размера R16/R15/R17, при желании можно добавить еще какие-то
параметры) - должны уже присутствовать в БД (базе данных)


### Реализован API
**GET /bodies**<br> *getAllCarBody*
возвращает информацию обо всех существующих корпусах (id,
type…)
<br>**GET /weels**<br> *getAllCarWheels* возвращает информацию обо всех существующих колесах (id,
size…)
<br>**POST /cars**<br> *createCar* (на вход подается JSON содержащий id нужных частей и количество
колес, крутое название)

#### Пример структуры JSON
<code>{
"name": "Москвич",
"body": {
"name": "sedan"
},
"weel": {
"name": "R15"
},
"numOfWeel": 10
}
</code><br>
Предусмотрена проверка наличия корпуса, колес не менее 2х для создания
автомобиля.

Созданный автомобиль сохраняется в базе данных и возвращается в ответе.

**GET /cars/{id}**<br> *getCarById* возвращает полную информацию о существующем автомобиле
<br>**GET /cars**<br> *getCars* возвращается список автомобилей с
  пагинацией


### Запуск

1. Клонировать репозиторий
   ```sh
   git clone git@github.com:RedPlanet3/carservice.git
   ```
3. Убедитесь что докер [docker](https://www.docker.com/) установлен и запущен
4. В папке проекта запустить команду
      ```sh
      docker-compose build
      docker-compose up
      ```

<!-- USAGE -->
## Использование

После запуска проекта перейти по адресу
`https://localhost:8081` + соответствующий point