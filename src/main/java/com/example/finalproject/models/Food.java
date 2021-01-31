package com.example.finalproject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "foods")
public class Food{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @ManyToMany
    @JoinTable(
            name = "menu_drinks",
            joinColumns = {
                    @JoinColumn (
                            name = "drink_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn (
                            name = "food_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Menu> menus;

    @ManyToMany
    @JoinTable(
            name = "order_drinks",
            joinColumns = {
                    @JoinColumn (
                            name = "drink_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn (
                            name = "order_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Order> orders;

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
        this.menus = new ArrayList<Menu>();
        this.orders = new ArrayList<Order>();
    }

    public Food(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public boolean addMenu(Menu menu) {
        return menus.add(menu);
    }

    public boolean addOrder(Order order) {
        return orders.add(order);
    }
}
