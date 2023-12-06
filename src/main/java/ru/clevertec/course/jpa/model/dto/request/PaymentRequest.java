package ru.clevertec.course.jpa.model.dto.request;


import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;
import ru.clevertec.course.jpa.model.domain.PaymentType;

import java.util.HashMap;
import java.util.Map;

@Data
@Accessors(chain = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        visible = true,
        property = "paymentType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PaymentRequest.class, name = "ACCOUNT"),
        @JsonSubTypes.Type(value = PaymentRequest.class, name = "CARD"),
        @JsonSubTypes.Type(value = PaymentRequest.class, name = "PHONE"),

        @JsonSubTypes.Type(value = PaymentByEripRequest.class, name = "ERIP"),
        @JsonSubTypes.Type(value = PaymentByRequisiteRequest.class, name = "REQUISITE")
})
public class PaymentRequest {
    @JsonIgnore
    private Long id;
    @NotNull
    @Size(max = 255)
    private String paymentFrom;
    @NotNull
    @Size(max = 255)
    private String paymentTo;
    @NotNull
    private PaymentType paymentType;

    private Map<String, String> args = new HashMap<>();

}
