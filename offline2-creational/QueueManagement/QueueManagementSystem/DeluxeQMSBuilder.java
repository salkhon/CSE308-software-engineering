package QueueManagement.QueueManagementSystem;

import java.util.ArrayList;
import java.util.List;

import QueueManagement.DisplayUnit.DisplayUnit;
import QueueManagement.DisplayUnit.DisplayUnitAbstractFactories.DeluxeDisplayUnitFactory;
import QueueManagement.DisplayUnit.DisplayUnitAbstractFactories.DisplayUnitFactory;

public class DeluxeQMSBuilder extends QMSBuilder {
    public DeluxeQMSBuilder(int numDisplayUnits) {
        super(numDisplayUnits);
    }

    @Override
    public void buildDisplayUnit() {
        List<DisplayUnit> displayUnits = new ArrayList<>();
        DisplayUnitFactory displayUnitFactory = new DeluxeDisplayUnitFactory();
        for (int i = 0; i < super.getNumDisplayUnits(); i++) {
            displayUnits.add(displayUnitFactory.createDisplayUnit());
        }
        super.getQMS().setDisplayUnits(displayUnits);
    }
}
