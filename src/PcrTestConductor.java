import java.util.List;

public class PcrTestConductor implements pcrRole{
    @Override
    public boolean performPCR(boolean hasFever, boolean hasCough) {
        if(!hasFever && !hasCough)
            return false;
        return true;
    }
}
