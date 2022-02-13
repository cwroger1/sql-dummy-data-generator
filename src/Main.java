/*
* Dummy data generator for SER 322 team project.
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

        writer.write("INSERT INTO 'OWNER' ('ownerId', 'firstName', 'lastName', " +
                "'address', 'phoneNumber') VALUES\n");

        for (int i = 0; i < 20; i++) {
            Owner owner = new Owner("first_names.txt", "last_names.txt", "rand_street_names.txt");
            owner.setFirstName();
            owner.setLastName();
            owner.setAddress();
            owner.setPhone();

            int ownerID = 1000 + i;
            String fName = owner.getFirstName();
            String lName = owner.getLastName();
            String address = owner.getAddress();
            String phone = owner.getPhone();

            String line = "('" + ownerID + "', " +
                    "'" + fName + "', " +
                    "'" + lName + "', " +
                    "'" + address + "', " +
                    "'" + phone + "'),\n";

            writer.write(line);
        }

    }

    public static void writeVehicles(BufferedWriter writer) throws IOException {
        writer.write("\nINSERT INTO 'VEHICLE' ('vinNumber', 'ownerId', 'year', " +
                "'make', 'model') VALUES\n");

        for (int i = 0; i < 20; i++) {
            Vehicle vehicle = new Vehicle("rand_cars.txt");
            vehicle.createVehicle();
            vehicle.createVIN();

            int ownerID = 1000 + i;
            String make = vehicle.getMake();
            String model = vehicle.getModel();
            String year = vehicle.getYear();
            String VIN = vehicle.getVIN();

            String line = "('" + VIN + "', " +
                    "'" + ownerID + "', " +
                    "'" + year + "', " +
                    "'" + make + "', " +
                    "'" + model + "'),\n";

            writer.write(line);
        }

    }

    public static void writeEmployees(BufferedWriter writer) throws IOException {
        writer.write("\nINSERT INTO 'EMPLOYEE' ('employeeId', 'role', 'status', " +
                "'firstName', 'lastName') VALUES\n");

        for (int i = 0; i < 15; i++) {
            Employee employee;
            // write mechanics (active)
            if (i > 2 && i < 11) {
                employee = new Employee("first_names.txt", "last_names.txt", "M", "A");
            } else if (i > 10 && i < 13) {
                // write mechanics (on leave)
                employee = new Employee("first_names.txt", "last_names.txt", "M", "L");
            } else if (i > 12) {
                // write mechanics (terminated)
                employee = new Employee("first_names.txt", "last_names.txt", "M", "T");
            } else {
                // write advisors
                employee = new Employee("first_names.txt", "last_names.txt", "A", "A");
            }
            employee.setFirstName();
            employee.setLastName();

            int employeeId = 2000 + i;
            String fName = employee.getFirstName();
            String lName = employee.getLastName();
            String role = employee.getRole();
            String status = employee.getStatus();

            String line = "('" + employeeId + "', " +
                    "'" + role + "', " +
                    "'" + status + "', " +
                    "'" + fName + "', " +
                    "'" + lName + "'),\n";

            writer.write(line);
        }

    }

}