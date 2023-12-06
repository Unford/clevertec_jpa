package ru.clevertec.course.jpa.model.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Data
@Accessors(chain = true)
public class SimplePageRequest {
    @Min(0)
    private int page = 0;
    @Min(0)
    @Max(20)
    private int size = 5;


    public Pageable toPageable() {
        return PageRequest.of(page, size);
    }
}
