import java.util.List;
import java.util.Optional;

public class HealthOffice extends CheckPerformer implements healthRoles{

    public HealthOffice(List<String> acceptedPassengerNames) {
        super(acceptedPassengerNames);
    }

    @Override
    public boolean healthCheck(
            String name,
            boolean pcrStatus,
            Optional<List<SpecialCondition>> specialConditions,
            String visitedPlace,
            boolean hasFever,
            boolean hasCough,
            Optional<List<MedicalAllergy>> medicalAllergies) {
        System.out.println(name + " reached (Health Officer)");
        System.out.println("Data Seen:");
        if(hasFever && hasCough)
            System.out.println(
                    "Name: " + name +
                    "PCR Status: " + pcrStatus+
                    "Has Fever & Cough");
        else if(hasFever){
            System.out.println(
                    "Name: " + name +
                            "PCR Status: " + pcrStatus+
                            "Has Fever & no Cough");
        } else if(hasCough){
            System.out.println(
                    "Name: " + name +
                            "PCR Status: " + pcrStatus+
                            "Has Cough & no Fever");
        } else {
            System.out.println(
                    "Name: " + name +
                            "PCR Status: " + pcrStatus+
                            "Doesn't have Fever or Cough");
        }



        if(super.acceptedPassengerNames.contains((name)) && !hasFever && !hasCough){
            if(!pcrStatus && specialConditions==null){
                if(medicalAllergies==null)
                    return true;
                else if(!medicalAllergies.get().contains(MedicalAllergy.CRITICAL_ALLERGY))
                    return true;
            }
            else if(!specialConditions.get().contains(SpecialCondition.CRITICAL_CONDITION))
                return true;
        }
        return false;

    }
}
