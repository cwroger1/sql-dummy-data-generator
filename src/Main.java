import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        for (int i = 0; i < 20; i++) {

            Owner owner = null;

            owner = new Owner("first_names.txt", "last_names.txt", "rand_street_names.txt");

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

        String emptyLine = "\n";
        writer.write(emptyLine);

        for (int i = 0; i < 20; i++) {
            Vehicle vehicle = null;
            vehicle = new Vehicle("rand_cars.txt");
            vehicle.createCar();

            int ownerID = 1000 + i;
            String make = vehicle.getMake();
            String model = vehicle.getModel();
            String year = vehicle.getYear();

            String line = "('" + ownerID + "', " +
                    "'" + make + "', " +
                    "'" + model + "', " +
                    "'" + year + "'),\n";

            writer.write(line);
        }

        writer.close();

    }

}
