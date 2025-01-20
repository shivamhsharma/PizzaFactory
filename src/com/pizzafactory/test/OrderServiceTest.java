package com.pizzafactory.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.pizzafactory.model.Crust;
import com.pizzafactory.model.Order;
import com.pizzafactory.model.Pizza;
import com.pizzafactory.model.Topping;
import com.pizzafactory.service.OrderService;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

	@Test
   public void testValidateOrder() {

		OrderService orderService = new OrderService();
        
        // Valid Order: Vegetarian pizza with valid toppings
        Pizza pizza = new Pizza("Deluxe Veggie", "Medium", new Crust("Hand Tossed"),
                                Arrays.asList(new Topping("Black Olive", 20), new Topping("Capsicum", 25)), true);
        Order order = new Order(Arrays.asList(pizza), Arrays.asList("Cold Drink"));
        assertTrue(orderService.validateOrder(order), "Order should be valid!");

        // Invalid Order: Non-Veg Topping on Veg Pizza
        pizza = new Pizza("Deluxe Veggie", "Medium", new Crust("Hand Tossed"),
                          Arrays.asList(new Topping("Chicken Tikka", 35)), true); // Invalid topping
        order = new Order(Arrays.asList(pizza), Arrays.asList("Cold Drink"));
        assertFalse(orderService.validateOrder(order), "Order should be invalid due to non-veg topping!");

        // Invalid Order: Multiple Non-Veg Toppings on Non-Veg Pizza
        pizza = new Pizza("Chicken Tikka", "Medium", new Crust("Cheese Burst"),
                          Arrays.asList(new Topping("Chicken Tikka", 35), new Topping("Grilled Chicken", 40)), false);
        order = new Order(Arrays.asList(pizza), Arrays.asList("Mousse Cake"));
        assertFalse(orderService.validateOrder(order), "Order should be invalid due to multiple non-veg toppings!");
		
	}
}