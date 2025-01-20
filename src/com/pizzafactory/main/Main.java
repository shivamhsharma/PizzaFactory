package com.pizzafactory.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.pizzafactory.model.Crust;
import com.pizzafactory.model.Order;
import com.pizzafactory.model.Pizza;
import com.pizzafactory.model.Topping;
import com.pizzafactory.service.MenuService;
import com.pizzafactory.service.OrderService;

public class Main {

	public static void main(String[] args) {

        MenuService menuService = new MenuService();
        OrderService orderService = new OrderService();

        // Sample menu items
        List<Pizza> menu = menuService.getPizzaMenu();
        List<String> sides = menuService.getSidesMenu();

        System.out.println("Menu items:");
        for (Pizza pizza : menu) {
            System.out.println(pizza.getName() + " - " + pizza.getSize());
        }

        // Scenario 1: Valid Order creation with valid toppings
        System.out.println("\nScenario 1: Valid Order Creation");
        Pizza selectedPizza = menu.get(0);  // Select first pizza
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Topping("Black Olive", 20));
        toppings.add(new Topping("Capsicum", 25));

        Pizza pizza = new Pizza("Deluxe Veggie", "Medium", new Crust("Hand Tossed"), toppings, true);
        Order order = new Order(Arrays.asList(pizza), Arrays.asList("Cold Drink"));

        System.out.println("Placing order for: " + pizza.getName());
        orderService.placeOrder(order);

        // Scenario 2: Invalid Order with Non-Vegetarian Topping on a Vegetarian Pizza
        System.out.println("\nScenario 2: Invalid Order - Non-Veg Topping on Veg Pizza");
        toppings = new ArrayList<>();
        toppings.add(new Topping("Chicken Tikka", 35));

        pizza = new Pizza("Deluxe Veggie", "Medium", new Crust("Hand Tossed"), toppings, true);
        order = new Order(Arrays.asList(pizza), Arrays.asList("Cold Drink"));

        System.out.println("Placing order for: " + pizza.getName());
        orderService.placeOrder(order);

        // Scenario 3: Invalid Order with Multiple Non-Veg Toppings on a Non-Vegetarian Pizza
        System.out.println("\nScenario 3: Invalid Order - Multiple Non-Veg Toppings on Non-Veg Pizza");
        pizza = new Pizza("Chicken Tikka", "Medium", new Crust("Cheese Burst"),
                          Arrays.asList(new Topping("Chicken Tikka", 35), new Topping("Grilled Chicken", 40)), false);
        order = new Order(Arrays.asList(pizza), Arrays.asList("Mousse Cake"));

        System.out.println("Placing order for: " + pizza.getName());
        orderService.placeOrder(order);

        // Scenario 4: Valid Order with Large Pizza and No Extra Toppings
        System.out.println("\nScenario 4: Valid Order - Large Pizza");
        pizza = new Pizza("Non-Veg Supreme", "Large", new Crust("Fresh Pan Pizza"),
                          Arrays.asList(new Topping("Black Olive", 20), new Topping("Grilled Chicken", 40)), false);
        order = new Order(Arrays.asList(pizza), Arrays.asList("Mousse Cake"));

        System.out.println("Placing order for: " + pizza.getName());
        orderService.placeOrder(order);

	}
}
