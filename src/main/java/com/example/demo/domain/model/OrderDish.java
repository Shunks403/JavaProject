package com.example.demo.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_dish")
public class OrderDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int orderDishId;

    @ManyToOne()
    @JoinColumn(name = "dishid")
    private Dish dish;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "orderid")
    private Order order;
}
