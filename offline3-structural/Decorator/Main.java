import java.util.Scanner;

import Meal.Meal;
import Meal.Decorators.Appetizer.FrenchFriesDecorator;
import Meal.Decorators.Appetizer.OnionRingsDecorator;
import Meal.Decorators.Burger.BeefBurgerDecorator;
import Meal.Decorators.Burger.VeggiBurgerDecorator;
import Meal.Decorators.Cheese.CheeseDecorator;
import Meal.Decorators.Drinks.CoffeeDecorator;
import Meal.Decorators.Drinks.CokeDecorator;
import Meal.Decorators.Drinks.WaterDecorator;

public class Main {
    private static Meal makeOrder(int orderId) {
        Meal decoratedMealStack = null;

        // factory here perhaps
        if (orderId == 1) {
            decoratedMealStack = new Meal(0);
            decoratedMealStack = new BeefBurgerDecorator(decoratedMealStack);
            decoratedMealStack = new FrenchFriesDecorator(decoratedMealStack);
            decoratedMealStack = new CheeseDecorator(decoratedMealStack);
        } else if (orderId == 2) {
            decoratedMealStack = new Meal(0);
            decoratedMealStack = new VeggiBurgerDecorator(decoratedMealStack);
            decoratedMealStack = new OnionRingsDecorator(decoratedMealStack);
            decoratedMealStack = new WaterDecorator(decoratedMealStack);
        } else if (orderId == 3) {
            decoratedMealStack = new Meal(0);
            decoratedMealStack = new VeggiBurgerDecorator(decoratedMealStack);
            decoratedMealStack = new FrenchFriesDecorator(decoratedMealStack);
            decoratedMealStack = new CokeDecorator(decoratedMealStack);
        } else if (orderId == 4) {
            decoratedMealStack = new Meal(0);
            decoratedMealStack = new VeggiBurgerDecorator(decoratedMealStack);
            decoratedMealStack = new OnionRingsDecorator(decoratedMealStack);
            decoratedMealStack = new CoffeeDecorator(decoratedMealStack);
            decoratedMealStack = new WaterDecorator(decoratedMealStack);
        } else if (orderId == 5) {
            decoratedMealStack = new Meal(0);
            decoratedMealStack = new BeefBurgerDecorator(decoratedMealStack);
        }

        return decoratedMealStack;
    }

    public static void main(String[] args) {
        System.out.print("Enter order id: ");        
        Scanner scanner = new Scanner(System.in);
        int orderId = scanner.nextInt();

        Meal decoratedMeal = makeOrder(orderId);

        System.out.println(decoratedMeal.getDecoratedPrice());

        scanner.close();
    }
}