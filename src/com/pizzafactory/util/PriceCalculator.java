package com.pizzafactory.util;

import com.pizzafactory.model.Pizza;
import com.pizzafactory.model.Topping;

public class PriceCalculator {

	public static double calculatePizzaPrice(Pizza pizza) {
        double price = 0;

        // Calculate the pizza base price
        switch (pizza.getSize()) {
            case "Regular":
                price = 150;
                break;
            case "Medium":
                price = 200;
                break;
            case "Large":
                price = 325;
                break;
        }

        // Add extra topping prices
        for (Topping topping : pizza.getToppings()) {
            price += topping.getPrice();
        }

        return price;
    }
}
