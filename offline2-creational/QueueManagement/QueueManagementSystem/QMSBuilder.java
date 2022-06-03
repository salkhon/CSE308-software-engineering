package QueueManagement.QueueManagementSystem;

import QueueManagement.CommunicationSystem.CommunicationSystem;
import QueueManagement.CommunicationSystem.CommunicationSystemFactory.CommFactory;
import QueueManagement.CommunicationSystem.CommunicationSystemFactory.CommFactory.CommType;
import QueueManagement.CommunicationSystem.CommunicationSystemFactory.SIMFactory;
import QueueManagement.CommunicationSystem.CommunicationSystemFactory.WifiFactory;
import QueueManagement.QMSException.QMSException;

public abstract class QMSBuilder {
    private QMS qms;
    private int numDisplayUnits;

    public QMSBuilder(int numDisplayUnits) {
        this.qms = new QMS();
        this.numDisplayUnits = numDisplayUnits;
    }

    public abstract void buildDisplayUnit();

    public void buildCommunicationSystem(CommType commType) {
        CommFactory commFactory;
        if (commType == CommType.WIFI) {
            commFactory = new WifiFactory();
        } else if (commType == CommType.SIM) {
            commFactory = new SIMFactory();
        } else {
            throw new QMSException("Not a valiud comm type");
        }

        CommunicationSystem commSystem = commFactory.createCommunicationSystem();
        qms.setCommunicationSystem(commSystem);
    }

    public int getNumDisplayUnits() {
        return numDisplayUnits;
    }

    public QMS getQMS() {
        return this.qms;
    }

    public void reset() {
        this.qms = new QMS();
    }
}
