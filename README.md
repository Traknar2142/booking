# Тестовое задание Prime

### Описание
Тестовое задание Prime:

Необходимо реализовать программу для отображения и бронирования доступных лотов в агентстве недвижимости.
Сущность лота (обязательные поля): Название лота, город(строка), адрес, площадь, этаж, кол-во комнат.

1)  Требуется реализовать endpoint для просмотра доступных лотов и предусмотреть в нем возможность фильтрации: по названию (вхождение), мин-макс этаж, адрес (вхождение), мин-макс площадь, мин-макс кол-во комнат, город.

2)  Реализовать endpoint для бронирования лота
    На уровне БД также предусмотреть сущность брони (обязательные поля): ФИО клиента, время брони, идентификатор лота, контактный телефон
    Используемые технологии: Spring(любые библиотеки), Postgres, JPA.




### Запуск

Запустить приложение можно из IDE
Отдельно БД можно запустить через compose файл через 
```
docker-compose up
```
При старте запустится миграция liquibase с созданием таблиц и загрузкой данных с лотами.

Доступ к API приложения осуществляется через порт 8080 хост-машины.\
Доступ из swagger осуществляется по ссылке: http://localhost:8080/swagger-ui.html/

## Набор методов
## GET /api/booking/find-all

Находит лоты по предоставленному фильтру\

Пример запроса:

lotEntityFilter
```
{
  "name": "Royal",
  "minFloor": 2
}
```

pageable
```
{
  "page": 0,
  "size": 9,
  "sort": [
    "name"
  ]
}
```

Пример ответа:

```
{
  "totalPages": 1,
  "totalElements": 2,
  "size": 9,
  "content": [
    {
      "name": "Royal Bridge Suite",
      "city": "Dubai",
      "address": "Crescent Rd — The Palm Jumeirah",
      "sq": "924",
      "floor": "2",
      "countOfRooms": "5"
    },
    {
      "name": "Royal Suite",
      "city": "Dubai",
      "address": "Jumeirah Road — Umm Suqeim 3",
      "sq": "780",
      "floor": "2",
      "countOfRooms": "4"
    }
  ],
  "number": 0,
  "sort": {
    "empty": false,
    "sorted": true,
    "unsorted": false
  },
  "first": true,
  "last": true,
  "numberOfElements": 2,
  "pageable": {
    "pageNumber": 0,
    "pageSize": 9,
    "sort": {
      "empty": false,
      "sorted": true,
      "unsorted": false
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "empty": false
}
```

## POST /api/booking/make-reservation
Резервирует лот за клиентом
Пример запроса:
```
{
  "fio": "Попов Петр Александрович",
  "reservationDateTime": "2024-07-08T09:58:55.667Z",
  "lotId": 0,
  "phoneNumber": 79525487456
}
```

Пример ответа:
```
{
  "fio": "Попов Петр Александрович",
  "reservationDateTime": "2024-07-08T09:58:55.667",
  "lotId": "0",
  "phoneNumber": "79525487456"
}
```