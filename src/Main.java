/*
* Dummy SQL data generator for an automotive maintenance database.
*
* @author Chris Rogers
* @version 2/12/2022
*
*/
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writeOwners(writer);
            writeVehicles(writer);
            writeEmployees(writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error with file or filename.");
            System.exit(-1);
        }

    }

    public static void writeOwners(BufferedWriter writer) throws IOException{

        writer.write("INSERT INTO OWNER (ownerId, firstName, lastName, " +
                "address, phoneNumber) VALUES\n");

        int numOwners = 20;

        String firstNamesFile = "first_names.txt";
        String lastNamesFile = "last_names.txt";
        String streetNamesFile = "rand_street_names.txt";

        for (int i = 0; i < numOwners; i++) {
            Owner owner = new Owner(firstNamesFile, lastNamesFile, streetNamesFile);
            owner.setFirstName();
            owner.setLastName();
            owner.setAddress();
            owner.setPhone();

            int ownerID = 1000 + i;
            String fName = owner.getFirstName();
            String lName = owner.getLastName();
            String address = owner.getAddress();
            String phone = owner.getPhone();

            writer.write("('" + ownerID + "', " +
                    "'" + fName + "', " +
                    "'" + lName + "', " +
                    "'" + address + "', ");
            if (i == numOwners-1) {
                writer.write("'" + phone + "');\n");
            } else {
                writer.write("'" + phone + "'),\n");
            }

        }

    }

    public static void writeVehicles(BufferedWriter writer) throws IOException {
        writer.write("\nINSERT INTO VEHICLE (vinNumber, ownerId, year, " +
                "make, model) VALUES\n");

        int numVehicles = 20;

        String carsFile = "rand_cars.txt";

        for (int i = 0; i < numVehicles; i++) {
            Vehicle vehicle = new Vehicle(carsFile);
            vehicle.createVehicle();
            vehicle.createVIN();

            int ownerID = 1000 + i;
            String make = vehicle.getMake();
            String model = vehicle.getModel();
            String year = vehicle.getYear();
            String VIN = vehicle.getVIN();

            writer.write("('" + VIN + "', " +
                    "'" + ownerID + "', " +
                    "'" + year + "', " +
                    "'" + make + "', ");
            if (i == numVehicles-1) {
                writer.write("'" + model + "');\n");
            } else {
                writer.write("'" + model + "'),\n");
            }

        }

    }

    public static void writeEmployees(BufferedWriter writer) throws IOException {
        writer.write("\nINSERT INTO EMPLOYEE (employeeId, role, status, " +
                "firstName, lastName) VALUES\n");

        int numEmployees = 15;

        String firstNamesFile = "first_names.txt";
        String lastNamesFile = "last_names.txt";

        for (int i = 0; i < numEmployees; i++) {
            Employee employee;
            // write mechanics (active)
            if (i > 2 && i < 11) {
                employee = new Employee(firstNamesFile, lastNamesFile, "M", "A");
            } else if (i > 10 && i < 13) {
                // write mechanics (on leave)
                employee = new Employee(firstNamesFile, lastNamesFile, "M", "L");
            } else if (i > 12) {
                // write mechanics (terminated)
                employee = new Employee(firstNamesFile, lastNamesFile, "M", "T");
            } else {
                // write advisors
                employee = new Employee(firstNamesFile, lastNamesFile, "A", "A");
            }
            employee.setFirstName();
            employee.setLastName();

            int employeeId = 2000 + i;
            String fName = employee.getFirstName();
            String lName = employee.getLastName();
            String role = employee.getRole();
            String status = employee.getStatus();

            writer.write("('" + employeeId + "', " +
                    "'" + role + "', " +
                    "'" + status + "', " +
                    "'" + fName + "', ");

            if (i == numEmployees-1) {
                writer.write("'" + lName + "');\n");
            } else {
                writer.write("'" + lName + "'),\n");
            }

        }

    }

}