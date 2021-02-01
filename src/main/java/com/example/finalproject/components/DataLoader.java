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

        Drink punkIpa = new Drink("Punk IPA", 4.49, DrinkCategory.BEER);
        Drink tennents = new Drink ("Tennents Lager", 3.79, DrinkCategory.BEER);
        Drink pinotGrigio = new Drink ("Pinot Grigio", 4.29, DrinkCategory.WINE);
        Drink merlot = new Drink ("Merlot", 4.49, DrinkCategory.WINE);
        Drink guinness = new Drink("Guinness", 4.50, DrinkCategory.BEER);
        Drink sanMiguel = new Drink("San Miguel", 4.00, DrinkCategory.BEER);
        Drink stellaArtois = new Drink("Stella Artois", 4.00, DrinkCategory.BEER);
        Drink strongbow = new Drink("Strongbow", 4.00, DrinkCategory.CIDER);
        Drink bulmers = new Drink("Bulmers", 4.50, DrinkCategory.CIDER);
        Drink kopparberg = new Drink("Kopparberg Mixed Fruit", 4.50, DrinkCategory.CIDER);
        Drink magners = new Drink("Magners", 4.50, DrinkCategory.CIDER);
        Drink oldMout = new Drink ("Old Mout", 4.50, DrinkCategory.CIDER);
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

        Food steakPie = new Food("Steak Pie", 8.99, FoodCategory.MAIN);
        Food fishAndChips = new Food("Fish & Chips", 7.89, FoodCategory.MAIN);
        Food chickenCurry = new Food("Chicken Curry", 9.99, FoodCategory.MAIN);
        Food lasagne = new Food("Lasagne", 6.99, FoodCategory.MAIN);
        Food chickenSupreme = new Food("Chicken Supreme", 8.99, FoodCategory.MAIN);
        Food scampi = new Food("Scampi", 8.99, FoodCategory.MAIN);
        Food burger = new Food("Burger", 8.99, FoodCategory.MAIN);
        Food chickenBurger = new Food("Chicken Burger", 8.99, FoodCategory.MAIN);
        Food prawnCocktail =  new Food("Prawn Cocktail", 4.99, FoodCategory.STARTER);
        Food iceCream = new Food("Ice Cream", 3.99, FoodCategory.DESSERT);
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

        Order order1 = new Order("01-02-2021 09:15",emily, venue1);
        orderRepository.save(order1);
        order1.addDrink(guinness);
        order1.addDrink(guinness);
        order1.addFood(scampi);
        order1.addFood(steakPie);
        orderRepository.save(order1);
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