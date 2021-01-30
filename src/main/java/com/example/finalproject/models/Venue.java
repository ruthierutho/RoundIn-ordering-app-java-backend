package com.example.finalproject.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "venues")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    @JsonIgnoreProperties({"venue"})
    private Menu menu;

    @JsonIgnoreProperties({"venue"})
    @OneToMany(mappedBy ="venue", fetch = FetchType.LAZY)
    private List<Order> orders;

    public Venue(String name, Menu menu) {
        this.name = name;
        this.menu = menu;
        this.orders = new ArrayList<Order>();
    }

    public Venue(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public boolean add(Order order) {
        return orders.add(order);
    }
}
