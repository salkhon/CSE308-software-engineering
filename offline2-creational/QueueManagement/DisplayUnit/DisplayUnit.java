package QueueManagement.DisplayUnit;

import QueueManagement.DisplayUnit.Controller.Controller;
import QueueManagement.DisplayUnit.DisplaySystem.DisplaySystem;

public class DisplayUnit {
    private DisplaySystem displaySystem;
    private Controller controller;

    public DisplayUnit(DisplaySystem displaySystem, Controller controller) {
        this.displaySystem = displaySystem;
        this.controller = controller;
    }

    public double getPurchaseCost() {
        return this.displaySystem.getPurchaseCost() + this.controller.getPurchaseCost();
    }

    @Override
    public String toString() {
        final String INDENT = "\t\t";
        String str = INDENT + "Display System: ";
        str += INDENT + this.displaySystem + "\n";
        str += INDENT + "Controller: ";
        str += INDENT + this.controller + "\n";
        return str;
    }
}
