package com.example.finalproject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @JsonIgnoreProperties({"orders"})
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
    @JsonIgnoreProperties({"orders"})
    Customer customer;

//    REMOVED FROM CONSTRUCTOR - List<Food> foods, List<Drink> drinks,
    public Order(String date, Customer customer, Venue venue) {
        this.date = date;
        this.customer = customer;
        this.venue = venue;
        this.drinks = new ArrayList<>();
        this.foods = new ArrayList<>();
    }

    public Order(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
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
