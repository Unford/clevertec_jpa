package ru.clevertec.course.jpa.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class PaymentByRequisite extends Payment {

    private String unp;
    private String receiver;
    private String destination;

    @PrePersist
    public void onPrePersist() {
        this.setPaymentType(PaymentType.REQUISITE);
    }

}
