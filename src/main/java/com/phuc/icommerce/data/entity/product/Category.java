package com.phuc.icommerce.data.entity.product;

import lombok.Data;

import javax.persistence.*;

@Table(name = "CATEGORY")
@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}