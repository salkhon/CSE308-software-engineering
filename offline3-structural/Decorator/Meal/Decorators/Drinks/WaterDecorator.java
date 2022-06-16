package Meal.Decorators.Drinks;

import Meal.Meal;
import Meal.Decorators.MealDecorator;

public class WaterDecorator extends MealDecorator {
    private static final double PRICE = 5;

    public WaterDecorator(Meal wrappedMeal) {
        super(wrappedMeal, PRICE);
    }

    @Override
    public double getDecoratedPrice() {
        double price = super.getDecoratedPrice(); // wrapped meal price
        price += this.getPrice();
        return price;
    }
}