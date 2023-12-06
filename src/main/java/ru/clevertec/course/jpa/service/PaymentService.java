package ru.clevertec.course.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import ru.clevertec.course.jpa.exception.ResourceNotFoundException;
import ru.clevertec.course.jpa.exception.UpdateConflictException;
import ru.clevertec.course.jpa.mapper.PaymentMapper;
import ru.clevertec.course.jpa.model.domain.Payment;
import ru.clevertec.course.jpa.model.dto.request.PaymentRequest;
import ru.clevertec.course.jpa.model.dto.response.PaymentResponse;
import ru.clevertec.course.jpa.repository.PaymentRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaymentService {
    private final PaymentRepository repository;
    private final PaymentMapper mapper;

    @Transactional
    public PaymentResponse create(PaymentRequest paymentRequest) {
        Payment entity = mapper.toEntity(paymentRequest);
        return mapper.toDto(repository.save(entity));
    }


    public Page<PaymentResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }


    public PaymentResponse findById(Long id) {
        return repository.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Payment with id '%s' not found"
                        .formatted(id)));
    }

    @Transactional
    public void deleteById(Long id) {
        this.findById(id);
        repository.deleteById(id);
    }

    @Transactional
    public PaymentResponse update(PaymentRequest paymentRequest) {
        Payment payment = repository.findById(paymentRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Payment with id '%s' not found"
                        .formatted(paymentRequest.getId())));
        if (paymentRequest.getPaymentType() != payment.getPaymentType()){
            throw new UpdateConflictException("Payment has another type " + payment.getPaymentType());
        }
        Payment updated = mapper.toEntity(paymentRequest);
        repository.save(updated);
        return this.findById(updated.getId());
    }
}
