package com.phuc.icommerce.data.entity.product;

import lombok.Data;

import javax.persistence.*;

@Table(name = "Brand")
@Data
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}