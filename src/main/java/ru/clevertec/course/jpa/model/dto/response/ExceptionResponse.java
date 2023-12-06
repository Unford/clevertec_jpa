package ru.clevertec.course.jpa.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class ExceptionResponse {
    private Integer code;
    private String message;
}
