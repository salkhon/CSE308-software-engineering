package QueueManagement.QueueManagementSystem;

import java.util.List;

import QueueManagement.CommunicationSystem.CommunicationSystem;
import QueueManagement.DisplayUnit.DisplayUnit;

public class QMS {
    private List<DisplayUnit> displayUnits;
    private CommunicationSystem commSystem;

    public QMS() {
    }

    protected void setDisplayUnits(List<DisplayUnit> displayUnits) {
        this.displayUnits = displayUnits;
    }

    protected void setCommunicationSystem(CommunicationSystem commSystem) {
        this.commSystem = commSystem;
    }

    public double getPurchaseCost() {
        double totalCost = 0;
        for (DisplayUnit displayUnit : this.displayUnits) {
            totalCost += displayUnit.getPurchaseCost();
        }
        totalCost += commSystem.getPurchaseCost();
        return totalCost;
    }

    public double getAnnualCost() {
        return this.commSystem.getAnnualCost();
    }

    @Override
    public String toString() {
        final String INDENT = "\t";
        StringBuilder stringBuilder = new StringBuilder("QMS:\n");
        
        stringBuilder.append(INDENT + "Display Unit(s):\n");
        for (int i = 0; i < this.displayUnits.size(); i++) {
            stringBuilder.append(INDENT + INDENT + (i + 1) + "\n");
            stringBuilder.append(this.displayUnits.get(i));
        }
        stringBuilder.append("\n");

        stringBuilder.append(INDENT + "Communication System:\n");
        stringBuilder.append(INDENT + INDENT + INDENT + this.commSystem);
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
}
