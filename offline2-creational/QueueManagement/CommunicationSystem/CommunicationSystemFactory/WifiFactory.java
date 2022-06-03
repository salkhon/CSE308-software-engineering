package QueueManagement.CommunicationSystem.CommunicationSystemFactory;

import QueueManagement.CommunicationSystem.CommunicationSystem;
import QueueManagement.CommunicationSystem.Wifi;

public class WifiFactory extends CommFactory {
    private static final double PRICE = 2000;
    private static final double ANNUAL_COST = 200;

    public WifiFactory() {}

    @Override
    public CommunicationSystem createCommunicationSystem() {
        return new Wifi(PRICE, ANNUAL_COST);
    }
}
