package ru.clevertec.course.jpa.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.course.jpa.model.dto.request.PaymentRequest;
import ru.clevertec.course.jpa.model.dto.response.PaymentResponse;
import ru.clevertec.course.jpa.model.dto.request.SimplePageRequest;
import ru.clevertec.course.jpa.service.PaymentService;

@RestController
@RequestMapping("api/v1/payments")
@RequiredArgsConstructor
@Validated
public class PaymentController {
    private final PaymentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse createPayment(@RequestBody @Validated PaymentRequest paymentRequest) {
        return service.create(paymentRequest);
    }

    @PutMapping("/{id}")
    public PaymentResponse updatePayment(@PathVariable @Positive Long id,
                                         @RequestBody @Validated PaymentRequest paymentRequest) {
        return service.update(paymentRequest.setId(id));
    }


    @GetMapping("/{id}")
    public PaymentResponse getById(@PathVariable @Positive Long id) {
        return service.findById(id);
    }

    @GetMapping
    public Page<PaymentResponse> getAll(@Valid SimplePageRequest pageRequest) {
        return service.findAll(pageRequest.toPageable());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable @Positive Long id) {
        service.deleteById(id);
    }


}
