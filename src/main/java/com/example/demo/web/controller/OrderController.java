package com.example.demo.web.controller;

import com.example.demo.domain.model.Order;
import com.example.demo.domain.service.OrderService;
import com.example.demo.validation.OnCreate;
import com.example.demo.web.dto.OrderDTO;
import com.example.demo.web.mapper.DefualtOrderMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@Validated
public class OrderController {

    private final OrderService orderService;
    private final DefualtOrderMapper OrderMapper;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getOrders() {
        List<Order> Orders = orderService.findAll();
        return ResponseEntity.ok(
                Orders.stream()
                        .map(OrderMapper::toDto)
                        .toList()
        );
    }

    @PostMapping("/add")
    @Validated(OnCreate.class)

    public ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody OrderDTO OrderDTO) {

        Order order = orderService.save(OrderMapper.fromDto(OrderDTO));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(OrderMapper.toDto(order));
    }


}
