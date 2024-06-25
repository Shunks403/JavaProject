package com.example.demo.domain.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;


import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryID;
    @Column(name = "categoryname")
    private String categoryName;


}
