package QueueManagement;

import java.util.Scanner;

import QueueManagement.CommunicationSystem.CommunicationSystemFactory.CommFactory.CommType;
import QueueManagement.QueueManagementSystem.DeluxeQMSBuilder;
import QueueManagement.QueueManagementSystem.OptimalQMSBuilder;
import QueueManagement.QueueManagementSystem.PoorQMSBuilder;
import QueueManagement.QueueManagementSystem.QMS;
import QueueManagement.QueueManagementSystem.QMSBuilder;

class Main {
    public static void main(String[] args) {
        System.out.print("Number of display units: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int numberOfDisplayUnits = Integer.parseInt(input);

        System.out.print("Type of QMS: ");
        input = scanner.nextLine();

        QMSBuilder qmsBuilder = null;
        if (input.equalsIgnoreCase("deluxe")) {
            qmsBuilder = new DeluxeQMSBuilder(numberOfDisplayUnits);
        } else if (input.equalsIgnoreCase("optimal")) {
            qmsBuilder = new OptimalQMSBuilder(numberOfDisplayUnits);
        } else if (input.equalsIgnoreCase("poor")) {
            qmsBuilder = new PoorQMSBuilder(numberOfDisplayUnits);
        }

        if (qmsBuilder != null) {
            qmsBuilder.buildDisplayUnit();
            System.out.print("Type of communication system: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("wifi")) {
                qmsBuilder.buildCommunicationSystem(CommType.WIFI);
            } else if (input.equalsIgnoreCase("sim")) {
                qmsBuilder.buildCommunicationSystem(CommType.SIM);
            }

            QMS qms = qmsBuilder.getQMS();

            System.out.println();
            System.out.println(qms);

            System.out.println("Purchase cost: " + qms.getPurchaseCost());
            System.out.println("Annual cost: " + qms.getAnnualCost());
        }

        scanner.close();
    }
}