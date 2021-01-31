package com.example.finalproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnoreProperties({"order"})
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<Food> foods;

    @JsonIgnoreProperties({"order"})
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<Drink> drinks;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnoreProperties({"order"})
    Customer customer;

    public Order(List<Food> foods, List<Drink> drinks, String date, Customer customer, Venue venue) {
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

    public void addFood(Food food) {
        this.foods.add(food);
    }

    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }

}
