/*
* Owner class for SER 322 dummy data generator.
*
* @author Chris Rogers
* @version 2/12/2022
*
*/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

public class Owner {

    private String firstNamesList;
    private String lastNamesList;
    private String streetNamesList;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    public Owner(String pFirstNames, String pLastNames, String pStreetNames) {
        this.firstNamesList = pFirstNames;
        this.lastNamesList = pLastNames;
        this.streetNamesList = pStreetNames;
    }

    public void setFirstName() throws IOException {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 50);
        this.firstName = Files.readAllLines(Paths.get("src/" + this.firstNamesList)).get(randomNum);
    }

    public void setLastName() throws IOException {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 50);
        this.lastName = Files.readAllLines(Paths.get("src/" + this.lastNamesList)).get(randomNum);
    }

    public void setAddress() throws IOException {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 50);
        int streetNum = ThreadLocalRandom.current().nextInt(1, 9999);
        String streetName = Files.readAllLines(Paths.get("src/" + this.streetNamesList)).get(randomNum);
        this.address = streetNum + " " + streetName;
    }

    public void setPhone() {
        int randomNum1= ThreadLocalRandom.current().nextInt(201, 990);
        int randomNum2 = ThreadLocalRandom.current().nextInt(100, 999);
        int randomNum3 = ThreadLocalRandom.current().nextInt(1000, 9999);
        this.phone = randomNum1 + "" + randomNum2 + "" + randomNum3;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAddress() {
        return this.address;
    }
}
