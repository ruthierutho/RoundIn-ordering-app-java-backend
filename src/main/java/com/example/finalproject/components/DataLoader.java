package com.example.finalproject.components;

import com.example.finalproject.models.*;
import com.example.finalproject.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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

    private void orderGenerator(int no_of_orders) {
        List<Customer> customers = customerRepository.findAll();
        List<Drink> drinks = drinkRepository.findAll();
        List<Food> foods = foodRepository.findAll();
        List<Venue> venues = venueRepository.findAll();
        for (int i = 0; i < no_of_orders; i++){
            Random rand = new Random();
            Customer randomCustomer = customers.get(rand.nextInt(customers.size()));
            Drink randomDrink1 = drinks.get(rand.nextInt(drinks.size()));
            Drink randomDrink2 = drinks.get(rand.nextInt(drinks.size()));
            Food randomFood1 = foods.get(rand.nextInt(foods.size()));
            Food randomFood2 = foods.get(rand.nextInt(foods.size()));
            Venue randomVenue = venues.get(rand.nextInt(venues.size()));


            LocalDate from = LocalDate.of(2021, 2, 1);
            LocalDate to = LocalDate.of(2021, 2, 28);
            long days = from.until(to, ChronoUnit.DAYS);
            long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
            LocalDate randomDate = from.plusDays(randomDays);
            String date = (randomDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            final Random random = new Random();
            final int millisInDay = 24*60*60*1000;
            Time time = new Time((long)random.nextInt(millisInDay));

            Order order = new Order(date, time.toString(), randomCustomer, randomVenue);
            order.addFood(randomFood1);
            order.addFood(randomFood2);
            order.addDrink(randomDrink1);
            order.addDrink(randomDrink2);
            orderRepository.save(order);
        }
    };

    public DataLoader(){
        this.drinksArray = new ArrayList<>();
        this.foodsArray = new ArrayList<>();
        this.menusArray = new ArrayList<>();
    }

    public void run(ApplicationArguments args){

        Drink punkIpa = new Drink("Punk IPA", 450, DrinkCategory.BEER);
        Drink tennents = new Drink ("Tennents Lager", 380, DrinkCategory.BEER);
        Drink pinotGrigio = new Drink ("Pinot Grigio", 430, DrinkCategory.WINE);
        Drink merlot = new Drink ("Merlot", 450, DrinkCategory.WINE);
        Drink guinness = new Drink("Guinness", 450, DrinkCategory.BEER);
        Drink sanMiguel = new Drink("San Miguel", 400, DrinkCategory.BEER);
        Drink stellaArtois = new Drink("Stella Artois", 400, DrinkCategory.BEER);
        Drink strongbow = new Drink("Strongbow", 400, DrinkCategory.CIDER);
        Drink bulmers = new Drink("Bulmers", 450, DrinkCategory.CIDER);
        Drink kopparberg = new Drink("Kopparberg Mixed Fruit", 450, DrinkCategory.CIDER);
        Drink magners = new Drink("Magners", 450, DrinkCategory.CIDER);
        Drink oldMout = new Drink ("Old Mout", 450, DrinkCategory.CIDER);
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
        drinksArray.add(oldMout);

        for (Drink drink: drinksArray) {
            drinkRepository.save(drink);
        }

        Food steakPie = new Food("Steak Pie", 899, FoodCategory.MAIN);
        Food fishAndChips = new Food("Fish & Chips", 789, FoodCategory.MAIN);
        Food chickenCurry = new Food("Chicken Curry", 999, FoodCategory.MAIN);
        Food lasagne = new Food("Lasagne", 699, FoodCategory.MAIN);
        Food chickenSupreme = new Food("Chicken Supreme", 899, FoodCategory.MAIN);
        Food scampi = new Food("Scampi", 899, FoodCategory.MAIN);
        Food burger = new Food("Burger", 899, FoodCategory.MAIN);
        Food chickenBurger = new Food("Chicken Burger", 899, FoodCategory.MAIN);
        Food prawnCocktail =  new Food("Prawn Cocktail", 499, FoodCategory.STARTER);
        Food iceCream = new Food("Ice Cream", 399, FoodCategory.DESSERT);
        foodsArray.add(steakPie);
        foodsArray.add(fishAndChips);
        foodsArray.add(chickenCurry);
        foodsArray.add(lasagne);
        foodsArray.add(chickenSupreme);
        foodsArray.add(scampi);
        foodsArray.add(burger);
        foodsArray.add(chickenBurger);
        foodsArray.add(prawnCocktail);
        foodsArray.add(iceCream);

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

        orderGenerator(30);
    }
}

//        Customer john = new Customer("John");
//        customerRepository.save(john);
//
//        Customer roosa = new Customer("Roosa");
//        customerRepository.save(roosa);
//
//        Customer juan = new Customer("Juan");
//        customerRepository.save(juan);
//
//        Customer colin = new Customer("Colin");
//        customerRepository.save(colin);
//
//        Customer hannah = new Customer("Hannah");
//        customerRepository.save(hannah);
//
//        Customer zsolt = new Customer("Zsolt");
//        customerRepository.save(zsolt);
//
//        Customer ally = new Customer("Ally");
//        customerRepository.save(ally);
//
//        Customer stuart = new Customer("Stuart");
//        customerRepository.save(stuart);
//
//        Customer michael = new Customer("Michael");
//        customerRepository.save(michael);
//
//        Customer andy = new Customer("Andy");
//        customerRepository.save(andy);
//
//        Customer ruthI = new Customer("Ruth I");
//        customerRepository.save(ruthI);
//
//        Customer emma = new Customer("Emma");
//        customerRepository.save(emma);
//
//        Customer katie = new Customer("Katie");
//        customerRepository.save(katie);
//
//        Customer gavin = new Customer("Gavin");
//        customerRepository.save(gavin);
//
//        Customer max = new Customer("Max");
//        customerRepository.save(max);
//
//        Customer ian = new Customer("Ian");
//        customerRepository.save(ian);
//
//        Customer mateusz = new Customer("Mateusz");
//        customerRepository.save(mateusz);
//
//        Customer rob = new Customer("Rob");
//        customerRepository.save(rob);
//
//        Customer marc = new Customer("Marc");
//        customerRepository.save(marc);
//
//        Customer kenny = new Customer("Kenny");
//        customerRepository.save(kenny);
//
//        Customer emily = new Customer("Emily");
//        customerRepository.save(emily);



//        Order order5 = new Order("Thursday Feb 4th", john, venue1);
//        orderRepository.save(order5);
//
//        Order order6 = new Order("Thursday Feb 4th", roosa, venue2);
//        orderRepository.save(order6);
//
//        Order order7 = new Order("Thursday Feb 4th", juan, venue3);
//        orderRepository.save(order7);
//
//        Order order8 = new Order("Thursday Feb 4th", colin, venue4);
//        orderRepository.save(order8);
//
//        Order order9 = new Order("Thursday Feb 4th", hannah, venue1);
//        orderRepository.save(order9);
//
//        Order order10 = new Order("Thursday Feb 4th", zsolt, venue2);
//        orderRepository.save(order10);
//
//        Order order11 = new Order("Thursday Feb 4th", ally, venue3);
//        orderRepository.save(order11);
//
//        Order order12 = new Order("Thursday Feb 4th", stuart, venue4);
//        orderRepository.save(order12);
//
//        Order order13 = new Order("Thursday Feb 4th", michael, venue1);
//        orderRepository.save(order13);
//
//        Order order14 = new Order("Thursday Feb 4th", andy, venue2);
//        orderRepository.save(order14);
//
//        Order order15 = new Order("Thursday Feb 4th", ruthI, venue3);
//        orderRepository.save(order15);
//
//        Order order16 = new Order("Thursday Feb 4th", emma, venue4);
//        orderRepository.save(order16);
//
//        Order order17 = new Order("Thursday Feb 4th", katie, venue1);
//        orderRepository.save(order17);
//
//        Order order18 = new Order("Thursday Feb 4th", gavin, venue2);
//        orderRepository.save(order18);
//
//        Order order19 = new Order("Thursday Feb 4th", max, venue3);
//        orderRepository.save(order19);
//
//        Order order20 = new Order("Thursday Feb 4th", ian, venue4);
//        orderRepository.save(order20);
//
//        Order order21 = new Order("Thursday Feb 4th", mateusz, venue1);
//        orderRepository.save(order21);
//
//        Order order22 = new Order("Thursday Feb 4th", rob, venue2);
//        orderRepository.save(order22);
//
//        Order order23 = new Order("Thursday Feb 4th", marc, venue3);
//        orderRepository.save(order23);
//
//        Order order24 = new Order("Thursday Feb 4th", kenny, venue4);
//        orderRepository.save(order24);
//
//        Order order25 = new Order("Thursday Feb 4th", emily, venue1);
//        orderRepository.save(order25);


//    Drink bulmers = new Drink("Bulmers", 4.50);
//    Drink oldMoot = new Drink ("Old Moot", 4.50);
//    Drink punkIpa = new Drink("Punk IPA", 4.49);
//    Drink sanMiguel = new Drink("San Miguel", 4.00);
//    Drink stellaArtois = new Drink("Stella Artois", 4.00);
//    Drink strongbow = new Drink("Strongbow", 4.00);
//    Drink kopparberg = new Drink("Kopparberg Mixed Fruit", 4.50);
//    Drink magners = new Drink("Magners", 4.50);
//
//    Food scampi = new Food("Scampi", 8.99);
//    Food chickenBurger = new Food("Chicken Burger", 8.99);
//    Food chickenCurry = new Food("Chicken Curry", 9.99);
//    Food chickenSupreme = new Food("Chicken Supreme", 8.99);
//    Food chips = new Food("Chips", 3.50);