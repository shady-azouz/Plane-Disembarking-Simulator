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

        for(Passenger passenger : passengers){
            if(pcrTestConductor.performPCR(passenger.getName(), passenger.isHasFever(), passenger.isHasCough())){
                System.out.println(passenger.getName()+" got a positive PCR Result");
                passenger.setPcrStatus(true);
            } else if(!portOfficer.portCheck(passenger.getName(), passenger.isPcrStatus(), passenger.getSpecialConditions())){
                System.out.println(passenger.getName()+" Didn't pass Port Check");
            } else if(!immigrationOfficer.immigrationCheck(passenger.getName(), passenger.isPcrStatus(), passenger.getSpecialConditions(), passenger.getVisitedPlace())){
                System.out.println(passenger.getName()+" didn't pass Immigration Check");
            } else if(!healthOffice.healthCheck(passenger.getName(), passenger.isPcrStatus(), passenger.getSpecialConditions(), passenger.getVisitedPlace(), passenger.isHasFever(), passenger.isHasCough(), passenger.getMedicalAllergies())){
                System.out.println(passenger.getName()+" didn't pass Health Check");
            }
            System.out.println('\n'+"------------------"+'\n');
        }
    }
}
