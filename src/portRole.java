import java.util.List;
import java.util.Optional;

public interface portRole {
    boolean portCheck(String name, boolean pcrStatus, Optional<List<SpecialCondition>> specialConditions);
}
