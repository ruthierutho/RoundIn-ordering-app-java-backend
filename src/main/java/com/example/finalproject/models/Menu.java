package com.example.finalproject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "menu_drinks",
            joinColumns = {
                    @JoinColumn (
                        name = "menu_id",
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
    @JsonIgnoreProperties("menu")
    private List<Drink> drinks;

    @ManyToMany
    @JoinTable(
            name = "menu_foods",
            joinColumns = {
                    @JoinColumn (
                            name = "menu_id",
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
    @JsonIgnoreProperties("menu")
    private List<Food> foods;

    @JsonIgnoreProperties({"menu"})
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private List<Venue> venues;

    public Menu(String name) {
        this.name = name;
        this.drinks = new ArrayList<Drink>();
        this.foods = new ArrayList<Food>();
        this.venues = new ArrayList<Venue>();
    }

    public Menu(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }

    public void addFood(Food food) {
        this.foods.add(food);
    }

    public void addVenue(Venue venue) {
        this.venues.add(venue);
    }
}
