package ru.clevertec.course.jpa.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class PaymentByEripRequest extends PaymentRequest {
    @NotNull
    @Size(max = 255)
    private String fieldForInsertion;
    @NotNull
    @Size(max = 255)
    private String valueForInsertion;

    @JsonProperty("args")
    public void setErip(Map<String, String> args) {
        super.setArgs(args);
        if (fieldForInsertion == null) {
            this.fieldForInsertion = args.get("fieldForInsertion");
        }
        if (valueForInsertion == null) {
            this.valueForInsertion = args.get("valueForInsertion");

        }
    }


}
