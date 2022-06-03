package QueueManagement.DisplayUnit.Controller.ControllerFactories;

import QueueManagement.DisplayUnit.Controller.ATMega32;
import QueueManagement.DisplayUnit.Controller.Controller;

public class ATMega32Factory extends ControllerFactory {
    public static final double PRICE = 200;

    public ATMega32Factory() {}

    @Override
    public Controller createController() {
        return new ATMega32(PRICE);
    }
}
