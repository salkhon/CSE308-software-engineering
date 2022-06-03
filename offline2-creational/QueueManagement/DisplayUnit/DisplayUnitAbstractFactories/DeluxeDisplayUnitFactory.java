package QueueManagement.DisplayUnit.DisplayUnitAbstractFactories;

import QueueManagement.DisplayUnit.DisplayUnit;
import QueueManagement.DisplayUnit.Controller.Controller;
import QueueManagement.DisplayUnit.Controller.ControllerFactories.ControllerFactory;
import QueueManagement.DisplayUnit.Controller.ControllerFactories.RaspberryPiFactory;
import QueueManagement.DisplayUnit.DisplaySystem.DisplaySystem;
import QueueManagement.DisplayUnit.DisplaySystem.DisplaySystemFactory;
import QueueManagement.DisplayUnit.DisplaySystem.DisplaySystemFactory.DisplaySystemType;

public class DeluxeDisplayUnitFactory extends DisplayUnitFactory {
    public DeluxeDisplayUnitFactory() {}

    @Override
    public DisplayUnit createDisplayUnit() {
        DisplaySystemFactory displaySystemFactory = new DisplaySystemFactory();
        DisplaySystem lcd = displaySystemFactory.createDisplaySystem(DisplaySystemType.LCD);

        ControllerFactory raspberryPiFactory = new RaspberryPiFactory();
        Controller raspberryPi = raspberryPiFactory.createController();

        DisplayUnit displayUnit = new DisplayUnit(lcd, raspberryPi);

        return displayUnit;
    }
}
