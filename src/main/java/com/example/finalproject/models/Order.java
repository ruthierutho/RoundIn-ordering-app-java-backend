package com.example.finalproject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venue_id", nullable = false)
    @JsonIgnoreProperties({"order"})
    private Venue venue;

    @ManyToMany
    @JoinTable(
            name = "order_foods",
            joinColumns = {
                    @JoinColumn (
                            name = "order_id",
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
    private List<Food> foods;

    @ManyToMany
    @JoinTable(
            name = "order_drinks",
            joinColumns = {
                    @JoinColumn (
                            name = "order_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn (
                            name = "drink_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Drink> drinks;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnoreProperties({"order"})
    Customer customer;

    public Order(String date, Customer customer, Venue venue) {
        this.drinks = new ArrayList<>();
        this.foods = new ArrayList<>();
        this.date = date;
        this.customer = customer;
        this.venue = venue;
    }

    public Order(){

    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean addFood(Food food) {
        return foods.add(food);
    }

    public boolean addDrink(Drink drink) {
        return drinks.add(drink);
    }

}
