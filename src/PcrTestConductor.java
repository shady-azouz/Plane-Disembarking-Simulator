import java.util.List;

public class PcrTestConductor implements pcrRole{
    @Override
    public boolean performPCR(String name, boolean hasFever, boolean hasCough) {
        System.out.println(name+" Reached PCR Test Performer");
        System.out.println("Data seen");
        if(hasFever && hasCough){
            System.out.println(name+" has Fever and Cough");
        } else if(hasFever){
            System.out.println(name+" has Fever but no Cough");
        } else if(hasCough){
            System.out.println(name+" has Cough and no Fever");
        } else {
            System.out.println(name+" has no Fever or Cough");
        }
        if(!hasFever && !hasCough)
            return false;
        return true;
    }
}
