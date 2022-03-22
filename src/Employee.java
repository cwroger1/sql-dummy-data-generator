/*
* Employee class for dummy data generator.
*
* @author Chris Rogers
* @version 2/12/2022
*
*/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

public class Employee {

    private String firstNamesList;
    private String lastNamesList;
    private String firstName;
    private String lastName;
    private String status;
    private String role;

    public Employee(String pFirstNames, String pLastNames, String pRole, String pStatus) {
        this.firstNamesList = pFirstNames;
        this.lastNamesList = pLastNames;
        this.role = pRole;
        this.status = pStatus;
    }

    public void setFirstName() throws IOException {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 50);
        this.firstName = Files.readAllLines(Paths.get("src/" + this.firstNamesList)).get(randomNum);
    }

    public void setLastName() throws IOException {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 50);
        this.lastName = Files.readAllLines(Paths.get("src/" + this.lastNamesList)).get(randomNum);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getRole() {
        return this.role;
    }

    public String getStatus() {
        return this.status;
    }

}
