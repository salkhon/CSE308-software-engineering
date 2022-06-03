package QueueManagement.DisplayUnit.Controller;

public abstract class Controller {
    private double price;

    public Controller(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPurchaseCost() {
        return this.price;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
