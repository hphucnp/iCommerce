package com.phuc.icommerce.data.entity.user;

import lombok.Data;

import javax.persistence.*;

@Table(name = "USER")
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Cart cart;
}