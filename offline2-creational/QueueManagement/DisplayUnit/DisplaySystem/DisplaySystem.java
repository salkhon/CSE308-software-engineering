package QueueManagement.DisplayUnit.DisplaySystem;

public abstract class DisplaySystem {
    private double price;

    public DisplaySystem(double price) {
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
