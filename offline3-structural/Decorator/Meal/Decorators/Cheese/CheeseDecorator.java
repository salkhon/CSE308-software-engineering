package Meal.Decorators.Cheese;

import Meal.Meal;
import Meal.Decorators.MealDecorator;

public class CheeseDecorator extends MealDecorator {
    private static final double PRICE = 5;

    public CheeseDecorator(Meal wrappedMeal) {
        super(wrappedMeal, PRICE);
    }

    @Override
    public double getDecoratedPrice() {
        double price = super.getDecoratedPrice(); // wrapped meal price
        price += this.getPrice();
        return price;
    }
}