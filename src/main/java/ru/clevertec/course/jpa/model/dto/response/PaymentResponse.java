package ru.clevertec.course.jpa.model.dto.response;



import ru.clevertec.course.jpa.model.domain.PaymentType;

import java.util.Map;

public record PaymentResponse(Long id,
                              String paymentFrom,
                              String paymentTo,
                              PaymentType paymentType,
                              Map<String, Object> args) {


}
