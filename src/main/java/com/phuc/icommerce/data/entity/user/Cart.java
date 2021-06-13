package com.phuc.icommerce.data.entity.user;

import com.phuc.icommerce.data.entity.composite.CartProduct;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Table(name = "cart")
@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart")
    Set<CartProduct> cartProducts;
}