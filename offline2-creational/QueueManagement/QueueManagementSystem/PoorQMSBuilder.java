package QueueManagement.QueueManagementSystem;

import java.util.ArrayList;
import java.util.List;

import QueueManagement.DisplayUnit.DisplayUnit;
import QueueManagement.DisplayUnit.DisplayUnitAbstractFactories.DisplayUnitFactory;
import QueueManagement.DisplayUnit.DisplayUnitAbstractFactories.PoorDisplayUnitFactory;

public class PoorQMSBuilder extends QMSBuilder {
    public PoorQMSBuilder(int numDisplayUnits) {
        super(numDisplayUnits);
    }

    @Override
    public void buildDisplayUnit() {
        List<DisplayUnit> displayUnits = new ArrayList<>();
        DisplayUnitFactory displayUnitFactory = new PoorDisplayUnitFactory();
        for (int i = 0; i < super.getNumDisplayUnits(); i++) {
            displayUnits.add(displayUnitFactory.createDisplayUnit());
        }
        super.getQMS().setDisplayUnits(displayUnits);
    }
}
