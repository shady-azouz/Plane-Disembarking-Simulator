import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PortOfficer extends CheckPerformer implements portRole{


    public PortOfficer(List<String> acceptedPassengerNames) {
        super(acceptedPassengerNames);
    }

    @Override
    public boolean portCheck(String name, boolean pcrStatus, Optional<List<SpecialCondition>> specialConditions) {
        System.out.println(name + " reached (Port Officer)");
        System.out.println("Data Seen:");
        System.out.println("Name: " + name + ", PCR Status: " + pcrStatus);
        if(super.acceptedPassengerNames.contains((name))){
            if(!pcrStatus && specialConditions==null)
                return true;
            else if(!specialConditions.get().contains(SpecialCondition.CRITICAL_CONDITION))
                return true;
        }
        return false;
    }
}
