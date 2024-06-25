package com.example.demo.domain.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tables")
public class OurTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tableid")
    private int tableID;
    @Column(name = "tablenumber")
    private int tableNumber;
    @Column(name = "seats")
    private int seats;

}