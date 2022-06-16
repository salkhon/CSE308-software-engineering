package Meal.Decorators.Appetizer;

import Meal.Meal;
import Meal.Decorators.MealDecorator;

public class OnionRingsDecorator extends MealDecorator {
    private static final double PRICE = 2;

    public OnionRingsDecorator(Meal wrappedMeal) {
        super(wrappedMeal, PRICE);
    }

    @Override
    public double getDecoratedPrice() {
        double price = super.getDecoratedPrice(); // wrapped meal price
        price += this.getPrice();
        return price;
    }
}