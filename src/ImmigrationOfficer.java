import java.util.List;
import java.util.Optional;

public class ImmigrationOfficer extends CheckPerformer implements immigrationRole{
    List<String> unAcceptedPlaces;


    public ImmigrationOfficer(List<String> acceptedPassengerNames, List<String> unAcceptedPlaces) {
        super(acceptedPassengerNames);
        this.unAcceptedPlaces = unAcceptedPlaces;
    }

    @Override
    public boolean immigrationCheck(String name, boolean pcrStatus, Optional<List<SpecialCondition>> specialConditions, String visitedPlace) {
        System.out.println(name + " reached (Immigration Officer)");
        System.out.println("Data Seen:");
        System.out.println("Name: " + name + ", PCR Status: " + pcrStatus+", Visited Place: "+visitedPlace);
        if(super.acceptedPassengerNames.contains((name)) && !this.unAcceptedPlaces.contains(visitedPlace)){
            if(!pcrStatus && specialConditions==null)
                return true;
            else if(!specialConditions.get().contains(SpecialCondition.CRITICAL_CONDITION))
                return true;
        }
        return false;
    }
}
