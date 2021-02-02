package com.example.finalproject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
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

    @Column(name = "collectionDate")
    private LocalDate collectionDate;

    @Column(name = "collectionTime")
    private LocalTime collectionTime;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnoreProperties({"orders"})
    private Customer customer;

    @Column(name="collected")
    private boolean collected;

    public Order(LocalDate collectionDate, LocalTime collectionTime, Customer customer, Venue venue) {
        this.collectionDate = collectionDate;
        this.collectionTime = collectionTime;
        this.customer = customer;
        this.venue = venue;
        this.drinks = new ArrayList<>();
        this.foods = new ArrayList<>();
        this.collected = false;
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

    public LocalDate getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(LocalDate date) {
        this.collectionDate = date;
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

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public LocalTime getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(LocalTime collectionTime) {
        this.collectionTime = collectionTime;
    }
}
