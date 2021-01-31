package com.example.finalproject.components;

import com.example.finalproject.models.*;
import com.example.finalproject.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    VenueRepository venueRepository;

    @Autowired
    DrinkRepository drinkRepository;

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    MenuRepository menuRepository;

    ArrayList<Drink> drinksArray;

    ArrayList<Food> foodsArray;

    ArrayList<Menu> menusArray;

    public DataLoader(){
        this.drinksArray = new ArrayList<>();
        this.foodsArray = new ArrayList<>();
        this.menusArray = new ArrayList<>();
    }

    public void run(ApplicationArguments args){


        Drink punkIpa = new Drink("Punk IPA", 4.49);
        Drink tennents = new Drink ("Tennents Lager", 3.79);
        Drink pinotGrigio = new Drink ("Pinot Grigio", 4.29);
        Drink merlot = new Drink ("Merlot", 4.49);
        Drink guinness = new Drink("Guinness", 4.50);
        Drink sanMiguel = new Drink("San Miguel", 4.00);
        Drink stellaArtois = new Drink("Stella Artois", 4.00);
        Drink strongbow = new Drink("Strongbow", 4.00);
        Drink bulmers = new Drink("Bulmers", 4.50);
        Drink kopparberg = new Drink("Kopparberg Mixed Fruit", 4.50);
        Drink magners = new Drink("Magners", 4.50);
        Drink oldMoot = new Drink ("Old Moot", 4.50);
        drinksArray.add(punkIpa);
        drinksArray.add(tennents);
        drinksArray.add(pinotGrigio);
        drinksArray.add(merlot);
        drinksArray.add(guinness);
        drinksArray.add(sanMiguel);
        drinksArray.add(stellaArtois);
        drinksArray.add(strongbow);
        drinksArray.add(bulmers);
        drinksArray.add(kopparberg);
        drinksArray.add(magners);
        drinksArray.add(oldMoot);

        for (Drink drink: drinksArray) {
            drinkRepository.save(drink);
        }

        Food steakPie = new Food("Steak Pie", 8.99);
        Food fishAndChips = new Food("Fish & Chips", 7.89);
        Food chickenCurry = new Food("Chicken Curry", 9.99);
        Food lasagne = new Food("Lasagne", 6.99);
        Food chickenSupreme = new Food("Chicken Supreme", 8.99);
        Food scampi = new Food("Scampi", 8.99);
        Food burger = new Food("Burger", 8.99);
        Food chickenBurger = new Food("Chicken Burger", 8.99);
        foodsArray.add(steakPie);
        foodsArray.add(fishAndChips);
        foodsArray.add(chickenCurry);
        foodsArray.add(lasagne);
        foodsArray.add(chickenSupreme);
        foodsArray.add(scampi);
        foodsArray.add(burger);
        foodsArray.add(chickenBurger);

        for (Food food: foodsArray) {
            foodRepository.save(food);
        }

        Menu theGrosvenorMenu = new Menu("The Grosvenor - Menu");
        Menu theKiltedPigMenu = new Menu("The Kilted Pig - Menu");
        Menu theAthleticArmsMenu = new Menu("The Athletic Arms - Menu");
        Menu macNastysMenu = new Menu("MacNastys - Menu");
        Menu no10Menu = new Menu("No.10 - Menu");

        menusArray.add(theGrosvenorMenu);
        menusArray.add(theKiltedPigMenu);
        menusArray.add(theAthleticArmsMenu);
        menusArray.add(macNastysMenu);
        menusArray.add(no10Menu);

        for (Menu menu: menusArray) {
            menuRepository.save(menu);
        }

        for (Menu menu: menusArray) {
            for (Food food: foodsArray) {
                menu.addFood(food);
            }
            for (Drink drink: drinksArray) {
                menu.addDrink(drink);
            }
            menuRepository.save(menu);
        }

        Customer ruth = new Customer("Ruth");
        customerRepository.save(ruth);

        Customer neale = new Customer("Neale");
        customerRepository.save(neale);

        Customer chris = new Customer("Chris");
        customerRepository.save(chris);

        Customer mark = new Customer("Mark");
        customerRepository.save(mark);

        Customer john = new Customer("John");
        customerRepository.save(john);

        Customer roosa = new Customer("Roosa");
        customerRepository.save(roosa);

        Customer juan = new Customer("Juan");
        customerRepository.save(juan);

        Customer colin = new Customer("Colin");
        customerRepository.save(colin);

        Customer hannah = new Customer("Hannah");
        customerRepository.save(hannah);

        Customer zsolt = new Customer("Zsolt");
        customerRepository.save(zsolt);

        Customer ally = new Customer("Ally");
        customerRepository.save(ally);

        Customer stuart = new Customer("Stuart");
        customerRepository.save(stuart);

        Customer michael = new Customer("Michael");
        customerRepository.save(michael);

        Customer andy = new Customer("Andy");
        customerRepository.save(andy);

        Customer ruthI = new Customer("Ruth I");
        customerRepository.save(ruthI);

        Customer emma = new Customer("Emma");
        customerRepository.save(emma);

        Customer katie = new Customer("Katie");
        customerRepository.save(katie);

        Customer gavin = new Customer("Gavin");
        customerRepository.save(gavin);

        Customer max = new Customer("Max");
        customerRepository.save(max);

        Customer ian = new Customer("Ian");
        customerRepository.save(ian);

        Customer mateusz = new Customer("Mateusz");
        customerRepository.save(mateusz);

        Customer rob = new Customer("Rob");
        customerRepository.save(rob);

        Customer marc = new Customer("Marc");
        customerRepository.save(marc);

        Customer kenny = new Customer("Kenny");
        customerRepository.save(kenny);

        Customer emily = new Customer("Emily");
        customerRepository.save(emily);

        Venue venue1 = new Venue("The Grosvenor", theGrosvenorMenu);
        venueRepository.save(venue1);

        Venue venue2 = new Venue("The Kilted Pig", theKiltedPigMenu);
        venueRepository.save(venue2);

        Venue venue3 = new Venue("The Athletic Arms", theAthleticArmsMenu);
        venueRepository.save(venue3);

        Venue venue4 = new Venue("MacNastys", macNastysMenu);
        venueRepository.save(venue4);

        Venue venue5 = new Venue("No.10", no10Menu);
        venueRepository.save(venue5);

        Order order1 = new Order("01-02-2021 09:15",emily, venue1);
        orderRepository.save(order1);
        order1.addDrink(guinness);
        order1.addDrink(guinness);
        order1.addFood(scampi);
        order1.addFood(steakPie);
        orderRepository.save(order1);
    }
}
