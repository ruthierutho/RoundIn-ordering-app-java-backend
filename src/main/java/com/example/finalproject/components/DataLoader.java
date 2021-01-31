package com.example.finalproject.components;

import com.example.finalproject.models.*;
import com.example.finalproject.repositories.CustomerRepository;
import com.example.finalproject.repositories.OrderRepository;
import com.example.finalproject.repositories.VenueRepository;
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

    ArrayList<Drink> drinksArray;

    ArrayList<Food> foodsArray;



    public DataLoader(){

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


        Menu theGrosvenorDrink = new Menu("The Grosvenor - Menu");
        Menu theKiltedPigDrink = new Menu("The Kilted Pig - Menu");
        Menu theAthleticArmsFood = new Menu("The Athletic Arms - Menu");
        Menu macNastysDrink = new Menu("MacNastys - Menu");
        Menu no10Food = new Menu("No.10 - Menu");



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

        Venue venue1 = new Venue("The Grosvenor", theGrosvenorDrink);
        venueRepository.save(venue1);

        Venue venue2 = new Venue("The Kilted Pig", theKiltedPigDrink);
        venueRepository.save(venue2);

        Venue venue3 = new Venue("The Athletic Arms", theAthleticArmsFood);
        venueRepository.save(venue3);

        Venue venue4 = new Venue("MacNastys", macNastysDrink);
        venueRepository.save(venue4);

        Venue venue5 = new Venue("No.10", no10Food);
        venueRepository.save(venue5);
    }
}
