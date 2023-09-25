package com.flowerbooking.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "flowers")
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private double price;

    @Lob
    private byte[] image;

    /*@OneToMany(mappedBy = "flower")
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "flower")
    private List<OrderItem> orderItems;*/

    public Flower() {
    }

    public Flower(int id, String name, String description, double price, byte[] image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
