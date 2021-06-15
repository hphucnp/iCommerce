package com.phuc.icommerce.data.entity.user;

import com.phuc.icommerce.data.entity.composite.CartProduct;
import lombok.*;
import org.apache.commons.lang3.builder.HashCodeExclude;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(name = "cart")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @MapsId
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    @HashCodeExclude
    private User user;

    @OneToMany(mappedBy = "cart")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Set<CartProduct> cartProducts = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cart cart = (Cart) o;

        return Objects.equals(id, cart.id);
    }

    @Override
    public int hashCode() {
        return 1062157515;
    }
}