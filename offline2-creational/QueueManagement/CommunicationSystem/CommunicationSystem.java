package QueueManagement.CommunicationSystem;

public abstract class CommunicationSystem {
    private double price;
    private double annualCost;

    public CommunicationSystem(double price, double annualCost) {
        this.price = price;
        this.annualCost = annualCost;
    }

    public double getPurchaseCost() {
        return this.price;
    }

    public double getAnnualCost() {
        return this.annualCost;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
