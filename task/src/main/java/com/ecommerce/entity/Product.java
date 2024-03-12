package com.ecommerce.entity;
import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @Column(name="id")
    private int id; // Changed type from String to int to match the SQL table definition
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description; // Added description field
    @Column(name="price")
    private double price;
    @Column(name="quantity")
    private int quantity;
    @Column(name="category")
    private String category; // Added category field

    public Product(int id, String name, String description, double price, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Product() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    /*@Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                '}';
    }*/
}
