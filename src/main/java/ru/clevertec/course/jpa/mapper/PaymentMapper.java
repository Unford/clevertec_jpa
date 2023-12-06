package ru.clevertec.course.jpa.mapper;

import org.mapstruct.*;
import ru.clevertec.course.jpa.model.domain.Payment;
import ru.clevertec.course.jpa.model.domain.PaymentByERIP;
import ru.clevertec.course.jpa.model.domain.PaymentByRequisite;
import ru.clevertec.course.jpa.model.dto.request.PaymentByEripRequest;
import ru.clevertec.course.jpa.model.dto.request.PaymentByRequisiteRequest;
import ru.clevertec.course.jpa.model.dto.request.PaymentRequest;
import ru.clevertec.course.jpa.model.dto.response.PaymentResponse;

@Mapper

public interface PaymentMapper {

    PaymentResponse toDto(Payment payment);

    @SubclassMapping(source = PaymentByEripRequest.class, target = PaymentByERIP.class)
    @SubclassMapping(source = PaymentByRequisiteRequest.class, target = PaymentByRequisite.class)
    Payment toEntity(PaymentRequest payment);


}
