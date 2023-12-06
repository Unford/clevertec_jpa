package ru.clevertec.course.jpa.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PaymentType {

    PHONE,

    ACCOUNT,
    CARD,
    REQUISITE,
    ERIP
}
