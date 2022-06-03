package QueueManagement.DisplayUnit.Controller.ControllerFactories;

import QueueManagement.DisplayUnit.Controller.Controller;
import QueueManagement.DisplayUnit.Controller.RaspberryPi;

public class RaspberryPiFactory extends ControllerFactory {
    public static final double PRICE = 5000;

    public RaspberryPiFactory() {}

    @Override
    public Controller createController() {
        return new RaspberryPi(PRICE);
    }
}
