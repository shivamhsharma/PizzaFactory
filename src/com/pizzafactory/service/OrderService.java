package com.pizzafactory.service;

import com.pizzafactory.model.Order;
import com.pizzafactory.model.Pizza;
import com.pizzafactory.model.Topping;

public class OrderService {

	 public boolean validateOrder(Order order) {
	        for (Pizza pizza : order.getPizzas()) {
	            if (pizza.isVegetarian()) {
	                for (Topping topping : pizza.getToppings()) {
	                    if (!topping.getName().equals("Black Olive") && !topping.getName().equals("Capsicum")) {
	                        return false; // Invalid topping for vegetarian pizza
	                    }
	                }
	            } else {
	                if (pizza.getToppings().size() > 1) {
	                    return false; // Only one non-veg topping allowed
	                }
	            }
	        }
	        return true;
	    }

	    public double calculateTotal(Order order) {
	        double total = 0;
	        for (Pizza pizza : order.getPizzas()) {
	            total += pizza.getSize().equals("Large") ? 0 : pizza.getToppings().stream().mapToDouble(Topping::getPrice).sum();
	        }
	        for (String side : order.getSides()) {
	            if (side.equals("Cold Drink")) total += 55;
	            else if (side.equals("Mousse Cake")) total += 90;
	        }
	        return total;
	    }

	    public void placeOrder(Order order) {
	        if (validateOrder(order)) {
	            double total = calculateTotal(order);
	            System.out.println("Order placed successfully. Total amount: Rs. " + total);
	        } else {
	            System.out.println("Order validation failed.");
	        }
	    }
}
