package Meal.Decorators;

import Meal.Meal;

public class MealDecorator extends Meal {
    private Meal wrappedMeal;

    public MealDecorator(Meal wrappedMeal, double price) {
        super(price);
        this.wrappedMeal = wrappedMeal;
    }

    @Override
    public double getDecoratedPrice() {
        return this.wrappedMeal.getDecoratedPrice();
    }
}