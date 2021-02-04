package com.example.finalproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private int price;

    @ManyToMany
    @JoinTable(
            name = "menu_foods",
            joinColumns = {
                    @JoinColumn (
                            name = "food_id",
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
    @JsonIgnore
    private List<Menu> menus;

    @ManyToMany
    @JoinTable(
            name = "order_foods",
            joinColumns = {
                    @JoinColumn (
                            name = "food_id",
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
    @JsonIgnore
    private List<Order> orders;

    @Enumerated(EnumType.STRING)
    private FoodCategory foodCategory;

    public Food(String name, int price, FoodCategory foodCategory) {
        this.name = name;
        this.price = price;
        this.menus = new ArrayList<Menu>();
        this.orders = new ArrayList<Order>();
        this.foodCategory =  foodCategory;
    }

    public Food(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }
}
