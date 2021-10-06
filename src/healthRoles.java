import java.util.List;
import java.util.Optional;

public interface healthRoles {
    boolean healthCheck(
            String name,
            boolean pcrStatus,
            Optional<List<SpecialCondition>> specialConditions,
            String visitedPlace,
            boolean hasFever,
            boolean hasCough,
            Optional<List<MedicalAllergy>> medicalAllergies);
//    the name
//    PCR status
//    Special Conditions
//    Place visited in the last 14 days
//    has fever
//    has cough
//    Listed medicine allergies
}
