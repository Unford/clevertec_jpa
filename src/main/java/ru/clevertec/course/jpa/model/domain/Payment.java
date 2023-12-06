package ru.clevertec.course.jpa.model.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Map;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentFrom;
    private String paymentTo;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Transient
    private Map<String, Object> args;

}
