package com.pizzafactory.service;

import java.util.Arrays;
import java.util.List;

import com.pizzafactory.model.Crust;
import com.pizzafactory.model.Pizza;
import com.pizzafactory.model.Topping;

public class MenuService {

	public static List<Pizza> getPizzaMenu() {
        Crust handTossed = new Crust("Hand Tossed");
        Crust wheatCrust = new Crust("Wheat Thin Crust");
        Crust cheeseBurst = new Crust("Cheese Burst");

        Topping olive = new Topping("Black Olive", 20);
        Topping capsicum = new Topping("Capsicum", 25);
        Topping paneer = new Topping("Paneer", 35);

        Pizza deluxeVeggie = new Pizza("Deluxe Veggie", "Regular", handTossed, Arrays.asList(olive, capsicum), true);
        Pizza cheeseCorn = new Pizza("Cheese & Corn", "Medium", wheatCrust, Arrays.asList(olive, paneer), true);

        return Arrays.asList(deluxeVeggie, cheeseCorn);
    }

    public static List<String> getSidesMenu() {
        return Arrays.asList("Cold Drink", "Mousse Cake");
    }
}
