package QueueManagement.DisplayUnit.Controller.ControllerFactories;
import QueueManagement.DisplayUnit.Controller.Controller;

/**
 * Factory
 */
public abstract class ControllerFactory {
    public ControllerFactory() {}

    public abstract Controller createController();
}
