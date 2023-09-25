package com.flowerbooking.model;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int qty;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "flower_id")
    private Flower flower;
}
