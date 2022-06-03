package QueueManagement.CommunicationSystem.CommunicationSystemFactory;

import QueueManagement.CommunicationSystem.CommunicationSystem;

public abstract class CommFactory {
    public CommFactory() {}

    public abstract CommunicationSystem createCommunicationSystem();

    public static enum CommType {
        WIFI, SIM;
    }
}
