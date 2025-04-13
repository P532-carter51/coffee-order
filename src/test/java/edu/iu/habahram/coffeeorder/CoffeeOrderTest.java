package edu.iu.habahram.coffeeorder;

import edu.iu.habahram.coffeeorder.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeOrderTest {

    // Dark Roast
    @Test
    void testDarkRoast() {
        Beverage beverage = new DarkRoast();
        assertEquals("Dark roast", beverage.getDescription());
        assertEquals(1.99, beverage.cost(), 0.01);
    }

    @Test
    void testDarkRoastWithMilkAndMocha() {
        Beverage beverage = new DarkRoast();
        beverage = new Milk(beverage);
        beverage = new Mocha(beverage);
        assertEquals("Dark roast, Milk, Mocha", beverage.getDescription());
        assertEquals(1.99 + 0.4 + 0.3, beverage.cost(), 0.01);
    }

    @Test
    void testDarkRoastWithWhipAndSoy() {
        Beverage beverage = new DarkRoast();
        beverage = new Whip(beverage);
        beverage = new Soy(beverage);
        assertEquals("Dark roast, Whip, Soy", beverage.getDescription());
        assertEquals(1.99 + 0.25 + 0.27, beverage.cost(), 0.01);
    }

    @Test
    void testDarkRoastWithMochaAndWhip() {
        Beverage beverage = new DarkRoast();
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        assertEquals("Dark roast, Mocha, Whip", beverage.getDescription());
        assertEquals(1.99 + 0.3 + 0.25, beverage.cost(), 0.01);
    }

    // Decaf
    @Test
    void testDecaf() {
        Beverage beverage = new Decaf();
        assertEquals("Decaf", beverage.getDescription());
        assertEquals(1.28, beverage.cost(), 0.01);
    }

    @Test
    void testDecafWithSoyAndWhip() {
        Beverage beverage = new Decaf();
        beverage = new Soy(beverage);
        beverage = new Whip(beverage);
        assertEquals("Decaf, Soy, Whip", beverage.getDescription());
        assertEquals(1.28 + 0.27 + 0.25, beverage.cost(), 0.01);
    }

    @Test
    void testDecafWithMilkAndMocha() {
        Beverage beverage = new Decaf();
        beverage = new Milk(beverage);
        beverage = new Mocha(beverage);
        assertEquals("Decaf, Milk, Mocha", beverage.getDescription());
        assertEquals(1.28 + 0.4 + 0.3, beverage.cost(), 0.01);
    }

    @Test
    void testDecafWithSoyAndMocha() {
        Beverage beverage = new Decaf();
        beverage = new Soy(beverage);
        beverage = new Mocha(beverage);
        assertEquals("Decaf, Soy, Mocha", beverage.getDescription());
        assertEquals(1.28 + 0.27 + 0.3, beverage.cost(), 0.01);
    }

    // Espresso
    @Test
    void testEspresso() {
        Beverage beverage = new Espresso();
        assertEquals("Espresso", beverage.getDescription());
        assertEquals(1.34, beverage.cost(), 0.01);
    }

    @Test
    void testEspressoWithMocha() {
        Beverage beverage = new Espresso();
        beverage = new Mocha(beverage);
        assertEquals("Espresso, Mocha", beverage.getDescription());
        assertEquals(1.34 + 0.3, beverage.cost(), 0.01);
    }

    @Test
    void testEspressoWithMilkAndWhip() {
        Beverage beverage = new Espresso();
        beverage = new Milk(beverage);
        beverage = new Whip(beverage);
        assertEquals("Espresso, Milk, Whip", beverage.getDescription());
        assertEquals(1.34 + 0.4 + 0.25, beverage.cost(), 0.01);
    }

    @Test
    void testEspressoWithMochaAndWhip() {
        Beverage beverage = new Espresso();
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        assertEquals("Espresso, Mocha, Whip", beverage.getDescription());
        assertEquals(1.34 + 0.3 + 0.25, beverage.cost(), 0.01);
    }

    // HouseBlend
    @Test
    void testHouseBlend() {
        Beverage beverage = new HouseBlend();
        assertEquals("House blend", beverage.getDescription());
        assertEquals(1.65, beverage.cost(), 0.01);
    }

    @Test
    void testHouseBlendWithMilkAndWhip() {
        Beverage beverage = new HouseBlend();
        beverage = new Milk(beverage);
        beverage = new Whip(beverage);
        assertEquals("House blend, Milk, Whip", beverage.getDescription());
        assertEquals(1.65 + 0.4 + 0.25, beverage.cost(), 0.01);
    }

    @Test
    void testHouseBlendWithSoyAndMocha() {
        Beverage beverage = new HouseBlend();
        beverage = new Soy(beverage);
        beverage = new Mocha(beverage);
        assertEquals("House blend, Soy, Mocha", beverage.getDescription());
        assertEquals(1.65 + 0.27 + 0.3, beverage.cost(), 0.01);
    }

    @Test
    void testHouseBlendWithWhipAndMocha() {
        Beverage beverage = new HouseBlend();
        beverage = new Whip(beverage);
        beverage = new Mocha(beverage);
        assertEquals("House blend, Whip, Mocha", beverage.getDescription());
        assertEquals(1.65 + 0.25 + 0.3, beverage.cost(), 0.01);
    }
}
