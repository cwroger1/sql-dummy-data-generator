
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

public class Vehicle {

    private String carList;
    private String make;
    private String model;
    private String year;
    private String VIN;

    public Vehicle(String pCarList) {
        carList = pCarList;
    }

    public void createVehicle() throws IOException {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 50);
        String car = Files.readAllLines(Paths.get("src/" + this.carList)).get(randomNum);
        String[] strArray = car.split("\\s+");
        this.make = strArray[0];
        this.model = strArray[1];
        this.year = strArray[2];
    }

    public void createVIN() {
        String VIN = "";
        int firstUppercaseIndex = (int)'A';
        for (int i = 0; i < 6; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 26);
            char randomUppercase = (char) (firstUppercaseIndex + randomNum);
            VIN = VIN + randomUppercase;
            if (i == 5) {
                randomNum = ThreadLocalRandom.current().nextInt(0, 26);
                randomUppercase = (char) (firstUppercaseIndex + randomNum);
                VIN = VIN + randomUppercase;
            }
            randomNum = ThreadLocalRandom.current().nextInt(0, 9);
            VIN = VIN + randomNum;
        }
        for (int i = 0; i < 4; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 9);
            VIN = VIN + randomNum;
        }
        this.VIN = VIN;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public String getYear() {
        return this.year;
    }

    public String getVIN() {
        return this.VIN;
    }

}
