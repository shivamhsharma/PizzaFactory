package com.pizzafactory.model;

import java.util.List;

public class Order {

	 private List<Pizza> pizzas;
	    private List<String> sides;

	    public Order(List<Pizza> pizzas, List<String> sides) {
	        this.pizzas = pizzas;
	        this.sides = sides;
	    }

	    public List<Pizza> getPizzas() {
	        return pizzas;
	    }

	    public List<String> getSides() {
	        return sides;
	    }

}
