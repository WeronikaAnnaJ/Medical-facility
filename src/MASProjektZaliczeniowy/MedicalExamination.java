package MASProjektZaliczeniowy;

import java.time.LocalDate;
import java.util.List;

public class MedicalExamination extends AssociationConstraint {

    private String name;
    private LocalDate date;
    private String interpretation;
    private String description;
    private String result;
    private String norm;

    MedicalExamination(String name, LocalDate date) {
        super();
        this.name = name;
        this.date = date;

    }

    public void setInterpretation(String interpretation) throws Exception {
        if (description == null || result == null) {
            throw new Exception("Cannot set interpretation when description or result is null.");
        }
        this.interpretation = interpretation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void serResult(String result, String norm) {
        this.result = result;
        this.norm = norm;
    }

    //POBIERZ NAJNOWSZE BADANIA
    //POBIERZ REZULTATY BADAIA

    public String getResult() {
        return result;
    }

    public static MedicalExamination getLatestExamination() {

        //pobierz wszytkie badania tego pacjenta
        //wybierz te ktore ma najmniejsza date
        //zwróc to badanie

        return null;
    }

    public static List<String> getExaminations(String name) {

        //pobierz wszytkie badania tego rodzajju po kolei
        //zwróc to badanie po kolei połącz w stringa result norme i date

        return null;
    }










}






