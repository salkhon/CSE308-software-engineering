package QueueManagement.DisplayUnit.DisplayUnitAbstractFactories;

import QueueManagement.DisplayUnit.DisplayUnit;
import QueueManagement.DisplayUnit.Controller.Controller;
import QueueManagement.DisplayUnit.Controller.ControllerFactories.ATMega32Factory;
import QueueManagement.DisplayUnit.Controller.ControllerFactories.ControllerFactory;
import QueueManagement.DisplayUnit.DisplaySystem.DisplaySystem;
import QueueManagement.DisplayUnit.DisplaySystem.DisplaySystemFactory;
import QueueManagement.DisplayUnit.DisplaySystem.DisplaySystemFactory.DisplaySystemType;

public class PoorDisplayUnitFactory extends DisplayUnitFactory {
    public PoorDisplayUnitFactory() {}

    @Override
    public DisplayUnit createDisplayUnit() {
        DisplaySystemFactory displaySystemFactory = new DisplaySystemFactory();
        DisplaySystem led = displaySystemFactory.createDisplaySystem(DisplaySystemType.LED);

        ControllerFactory atmega32Factory = new ATMega32Factory();
        Controller atmega32 = atmega32Factory.createController();

        DisplayUnit displayUnit = new DisplayUnit(led, atmega32);

        return displayUnit;
    }
}
