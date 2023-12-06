package ru.clevertec.course.jpa.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "payment_by_erip")
public class PaymentByERIP extends Payment{

    private String fieldForInsertion;
    private String valueForInsertion;

    @PrePersist
    public void onPrePersist() {
        this.setPaymentType(PaymentType.ERIP);
    }

}
