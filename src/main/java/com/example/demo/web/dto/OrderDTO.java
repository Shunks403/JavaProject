package com.example.demo.web.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderDTO {

    private Integer orderId;


    private LocalDateTime orderDateTime;

    @NotNull(message = "Table cannot be null")
    private Integer tableId;

    @NotNull(message = "User cannot be null")
    private Long userId;

    @NotNull(message = "Order dishes cannot be null")
    private List<OrderDishDTO> orderDishes;

    @Min(value = 0, message = "Total amount must be at least 0")
    private double totalAmount;
}
