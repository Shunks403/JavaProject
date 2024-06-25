package com.example.demo.web.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OurTableDTO {
    private Integer tableID;

    @NotNull(message = "Table number cannot be null")
    @Min(value = 1, message = "Table number must be at least 1")
    private Integer tableNumber;

    @NotNull(message = "Seats cannot be null")
    @Min(value = 1, message = "Seats must be at least 1")
    private Integer seats;
}
