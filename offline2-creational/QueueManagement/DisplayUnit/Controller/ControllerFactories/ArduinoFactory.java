package QueueManagement.DisplayUnit.Controller.ControllerFactories;

import QueueManagement.DisplayUnit.Controller.Arduino;
import QueueManagement.DisplayUnit.Controller.Controller;

public class ArduinoFactory extends ControllerFactory {
    public static final double PRICE = 800;

    public ArduinoFactory() {}

    @Override
    public Controller createController() {
        return new Arduino(PRICE);
    }
}
