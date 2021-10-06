import java.util.List;
import java.util.Optional;

public class Passenger {
    int id;
    String name;
    String visitedPlace;
    boolean hasFever;
    boolean hasCough;
    boolean pcrStatus;
    Optional<List<SpecialCondition>> specialConditions;
    Optional<List<MedicalAllergy>> medicalAllergies;

    public Passenger(int id, String name, String visitedPlace, boolean hasFever, boolean hasCough, boolean pcrStatus) {
        this.id = id;
        this.name = name;
        this.visitedPlace = visitedPlace;
        this.hasFever = hasFever;
        this.hasCough = hasCough;
        this.pcrStatus = pcrStatus;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVisitedPlace() {
        return visitedPlace;
    }

    public boolean isHasFever() {
        return hasFever;
    }

    public boolean isHasCough() {
        return hasCough;
    }

    public boolean isPcrStatus() {
        return pcrStatus;
    }

    public Optional<List<SpecialCondition>> getSpecialConditions() {
        return specialConditions;
    }

    public Optional<List<MedicalAllergy>> getMedicalAllergies() {
        return medicalAllergies;
    }

    public void setPcrStatus(boolean pcrStatus) {
        this.pcrStatus = pcrStatus;
    }
}
