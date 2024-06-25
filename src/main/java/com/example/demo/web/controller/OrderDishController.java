package com.example.demo.web.controller;

import com.example.demo.domain.model.OrderDish;
import com.example.demo.domain.service.OrderDishService;
import com.example.demo.validation.OnCreate;
import com.example.demo.web.dto.OrderDishDTO;
import com.example.demo.web.dto.UserDTO;
import com.example.demo.web.mapper.DefualtOrderDishMapper;
import com.example.demo.web.mapper.DefualtOrderMapper;
import com.example.demo.web.mapper.OrderDishMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orderdishes")
@Validated
public class OrderDishController {


    private final OrderDishService orderDishService;
    private final DefualtOrderDishMapper OrderDishMapper;

    @GetMapping
    public ResponseEntity<List<OrderDishDTO>> getOrderDishes() {
        List<OrderDish> OrderDishes = orderDishService.findAll();
        return ResponseEntity.ok(
                OrderDishes.stream()
                        .map(OrderDishMapper::toDto)
                        .toList()
        );
    }


    @PostMapping
    @Validated(OnCreate.class)

    public ResponseEntity<OrderDishDTO> addOrderDish(@Valid @RequestBody OrderDishDTO OrderDishDTO) {

        OrderDish OrderDish = orderDishService.save(OrderDishMapper.fromDto(OrderDishDTO));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(OrderDishMapper.toDto(OrderDish));
    }

}
