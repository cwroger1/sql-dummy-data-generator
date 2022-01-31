
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

public class Vehicle {

    private String carList;
    private String make;
    private String model;
    private String year;

    public Vehicle(String pCarList) {
        carList = pCarList;
    }

    public void createCar() throws IOException {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 50);
        String car = Files.readAllLines(Paths.get("src/" + this.carList)).get(randomNum);
        String[] strArray = car.split("\\s+");
        this.make = strArray[0];
        this.model = strArray[1];
        this.year = strArray[2];
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

}
