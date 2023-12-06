package ru.clevertec.course.jpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.course.jpa.model.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
