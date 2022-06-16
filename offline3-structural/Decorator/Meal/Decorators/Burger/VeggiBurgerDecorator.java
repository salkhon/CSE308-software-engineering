package Meal.Decorators.Burger;

import Meal.Meal;
import Meal.Decorators.MealDecorator;

public class VeggiBurgerDecorator extends MealDecorator {
    private static final double PRICE = 8;

    public VeggiBurgerDecorator(Meal wrappedMeal) {
        super(wrappedMeal, PRICE);
    }

    @Override
    public double getDecoratedPrice() {
        double price = super.getDecoratedPrice(); // wrapped meal price
        price += this.getPrice();
        return price;
    }
}