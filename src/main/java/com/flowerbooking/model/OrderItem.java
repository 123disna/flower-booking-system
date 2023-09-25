package com.flowerbooking.model;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "flower_id")
    private Flower flower;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private int qty;

    public OrderItem() {
    }

    public OrderItem(int id, Flower flower, Order order, int qty) {
        this.id = id;
        this.flower = flower;
        this.order = order;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
