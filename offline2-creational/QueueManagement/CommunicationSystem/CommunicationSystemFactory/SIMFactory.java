package QueueManagement.CommunicationSystem.CommunicationSystemFactory;

import QueueManagement.CommunicationSystem.CommunicationSystem;
import QueueManagement.CommunicationSystem.SIM;

public class SIMFactory extends CommFactory {
    private static final double PRICE = 200;
    private static final double ANNUAL_COST = 2000;

    public SIMFactory() {}

    @Override
    public CommunicationSystem createCommunicationSystem() {
        return new SIM(PRICE, ANNUAL_COST);
    }
}
