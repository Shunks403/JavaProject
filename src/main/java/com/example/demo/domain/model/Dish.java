package com.example.demo.domain.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Table;

import java.math.BigDecimal;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dishid")
    private int dishId;
    @Column(name = "dishname")
    private String dishName;
    private String description;
    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;


}