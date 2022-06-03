package QueueManagement.DisplayUnit.DisplayUnitAbstractFactories;

import QueueManagement.DisplayUnit.DisplayUnit;
import QueueManagement.DisplayUnit.Controller.Controller;
import QueueManagement.DisplayUnit.Controller.ControllerFactories.ArduinoFactory;
import QueueManagement.DisplayUnit.Controller.ControllerFactories.ControllerFactory;
import QueueManagement.DisplayUnit.DisplaySystem.DisplaySystem;
import QueueManagement.DisplayUnit.DisplaySystem.DisplaySystemFactory;
import QueueManagement.DisplayUnit.DisplaySystem.DisplaySystemFactory.DisplaySystemType;

public class OptimalDisplayUnitFactory extends DisplayUnitFactory {
    public OptimalDisplayUnitFactory() {}

    @Override
    public DisplayUnit createDisplayUnit() {
        DisplaySystemFactory displaySystemFactory = new DisplaySystemFactory();
        DisplaySystem led = displaySystemFactory.createDisplaySystem(DisplaySystemType.LED);

        ControllerFactory arduinoFactory = new ArduinoFactory();
        Controller arduino = arduinoFactory.createController();

        DisplayUnit displayUnit = new DisplayUnit(led, arduino);

        return displayUnit;
    }
}
