package com.example.demo.web.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderDishDTO {
    private Integer orderDishId;

    @NotNull(message = "Dish cannot be null")
    private Integer dishId;

    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    //@NotNull(message = "Order cannot be null")
    private Integer orderId;
}
