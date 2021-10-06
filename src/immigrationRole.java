import java.util.List;
import java.util.Optional;

public interface immigrationRole {
    boolean immigrationCheck(String name, boolean pcrStatus, Optional<List<SpecialCondition>> specialConditions, String visitedPlace);
}
