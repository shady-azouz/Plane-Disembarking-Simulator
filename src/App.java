import javax.sound.sampled.Port;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Passenger> passengers = Arrays.asList(
                new Passenger(1, "Shady Azouz", "Egypt", false, false, false),
                new Passenger(1, "Youssef Refaat", "USA", true, false, false),
                new Passenger(1, "Mohamed Adel", "UK", false, true, false),
                new Passenger(1, "Mohamed Kadry", "USA", false, false, false)
        );

        List<String> unacceptedPlaces = Arrays.asList(
                "Egypt",
                "India",
                "China"
        );

        List<String> acceptedNames = Arrays.asList(
                "Shady Azouz",
                "Youssef Refaat",
                "Mohamed Kadry"
        );

        PcrTestConductor pcrTestConductor = new PcrTestConductor();
        PortOfficer portOfficer = new PortOfficer(acceptedNames);
        ImmigrationOfficer immigrationOfficer = new ImmigrationOfficer(acceptedNames, unacceptedPlaces);
        HealthOffice healthOffice = new HealthOffice(acceptedNames);
    }
}
