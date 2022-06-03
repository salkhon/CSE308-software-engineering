package QueueManagement.DisplayUnit.DisplaySystem;

import QueueManagement.QMSException.QMSException;

/**
 * Factory Method
 */
public class DisplaySystemFactory {
    private static final int LCD_PRICE = 3000;
    private static final int LED_PRICE = 500;

    public DisplaySystemFactory() {}

    public DisplaySystem createDisplaySystem(DisplaySystemType displaySystemType) {
        if (displaySystemType == DisplaySystemType.LCD) {
            return new LCD(LCD_PRICE);
        } else if (displaySystemType == DisplaySystemType.LED) {
            return new LED(LED_PRICE);
        } else {
            throw new QMSException("Not a valid display system type");
        }
    }
    
    public static enum DisplaySystemType {
        LCD, LED;
    }
}
