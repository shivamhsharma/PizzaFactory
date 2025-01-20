package com.pizzafactory.model;

import java.util.List;

public class Pizza {

	private String name;
    private String size;
    private Crust crust;
    private List<Topping> toppings;
    private boolean isVegetarian;

    public Pizza(String name, String size, Crust crust, List<Topping> toppings, boolean isVegetarian) {
        this.name = name;
        this.size = size;
        this.crust = crust;
        this.toppings = toppings;
        this.isVegetarian = isVegetarian;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public Crust getCrust() {
        return crust;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }
}
