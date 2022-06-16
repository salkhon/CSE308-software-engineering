package Meal;

public class Meal {
    private double price;

    public Meal(double price) {
        this.price = price;
    }

    protected double getPrice() {
        return this.price;
    }

    public double getDecoratedPrice() {
        return price;
    }
}