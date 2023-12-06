package ru.clevertec.course.jpa.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class PaymentByRequisiteRequest extends PaymentRequest {
    @NotNull
    @Size(max = 255)
    private String unp;
    @NotNull
    @Size(max = 255)
    private String receiver;
    @NotNull
    @Size(max = 255)
    private String destination;

    @JsonProperty("args")
    public void setRequisite(Map<String, String> args) {
        super.setArgs(args);
        if (unp == null){
            this.unp = args.get("unp");
        }
        if (receiver == null){
            this.receiver = args.get("receiver");
        }
        if (destination == null){
            this.destination = args.get("destination");


        }
    }
}
