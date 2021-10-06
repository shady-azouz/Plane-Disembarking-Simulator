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

        if(super.acceptedPassengerNames.contains((name)) && !hasFever && !hasCough){
            if(!pcrStatus && specialConditions.isEmpty()){
                if(medicalAllergies.isEmpty())
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
