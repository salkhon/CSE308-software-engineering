package Meal.Decorators.Appetizer;

import Meal.Meal;
import Meal.Decorators.MealDecorator;

public class FrenchFriesDecorator extends MealDecorator {
    private static final double PRICE = 3;

    public FrenchFriesDecorator(Meal wrappedMeal) {
        super(wrappedMeal, PRICE);
    }

    @Override
    public double getDecoratedPrice() {
        double price = super.getDecoratedPrice(); // wrapped meal price
        price += this.getPrice();
        return price;
    }
}