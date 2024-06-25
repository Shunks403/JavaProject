package com.example.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;



@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private int orderId;
    @Column(name = "orderdate")
    private LocalDateTime orderDateTime;

    @OneToOne
    @JoinColumn(name = "tableid")
    private OurTable OurTable;

    @OneToOne
    @JoinColumn(name = "userid")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("order")
    private List<OrderDish> orderDishes;

    @Column(name="totalamount")
    private double totalAmount;

}
