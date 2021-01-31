package com.example.finalproject.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drinks")
public class Drink{

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
                            name = "menu_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Menu> menu;

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
    private List<Order> order;

    public Drink(String name, double price) {
        this.name = name;
        this.price = price;
        this.menu = new ArrayList<Menu>();
        this.order = new ArrayList<Order>();
    }

    public Drink(){

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

    public boolean addMenu(Menu menu) {
        return this.menu.add(menu);
    }

    public boolean addOrder(Order order) {
        return this.order.add(order);
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
}
