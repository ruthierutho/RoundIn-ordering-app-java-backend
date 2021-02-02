package com.example.finalproject.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnoreProperties({"customer", "orders", "venue", "drinks", "foods"})
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<Order>();
    }

    public Customer(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}
