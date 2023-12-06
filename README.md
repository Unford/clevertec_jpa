# Clevertec jpa

## Приложение для обработки платежей

### Класс Payment

#### Поля

- **id**: Уникальный идентификатор каждого платежа
- **paymentFrom**: Отправитель платежа
- **paymentTo**: Получатель платежа
- **paymentType**: Тип платежа (PaymentType)
- **args**: Дополнительные аргументы платежа в виде карты (Map<String, Object>)

### Класс PaymentByERIP

#### Дополнительные поля

- **fieldForInsertion**: Поле для вставки данных
- **valueForInsertion**: Значение для вставки данных

#### Методы

- **onPrePersist**: Метод, вызываемый перед сохранением в базу данных. Устанавливает тип платежа в **PaymentType.ERIP**.

### Класс PaymentByRequisite

#### Дополнительные поля

- **unp**: Уникальный номер плательщика
- **receiver**: Получатель платежа
- **destination**: Назначение платежа

#### Методы

- **onPrePersist**: Метод, вызываемый перед сохранением в базу данных. Устанавливает тип платежа в **PaymentType.REQUISITE**.

### Пример JSON

```json
{
    "id": 1,
    "paymentFrom": "Иванов Иван",
    "paymentTo": "ООО Рога и Копыта",
    "paymentType": "REQUISITE",
    "args": {
        "receiver": "Петров Петр",
        "unp": "123456789",
        "destination": "Оплата за услуги"
    }
}
```
Или

```json
{
    "id": 1,
    "paymentFrom": "Иванов Иван",
    "paymentTo": "ООО Рога и Копыта",
    "paymentType": "REQUISITE",
    "receiver": "Петров Петр",
    "unp": "123456789",
    "destination": "Оплата за услуги"
}
```

Для записи доп полей в args используется [POST LOAD слушатель](src%2Fmain%2Fjava%2Fru%2Fclevertec%2Fcourse%2Fjpa%2Frepository%2Flistener%2FPostLoadPaymentEventListener.java)