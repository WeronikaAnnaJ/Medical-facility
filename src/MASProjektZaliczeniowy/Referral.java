package MASProjektZaliczeniowy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Referral extends AssociationConstraint{
    private LocalDate dateOfIssuing;
    private LocalDate expiryDate;
    private String medicalExamination;//albo lista w zaleznosci ile badań new ArrayList<>();//albo inna nazwa
    private String PESEL;
    private String firstName;
    private String lastName;
    private Doctor orderingDoctor;


    Referral(LocalDate expiryDate, String medicalExamination, String PESEL, String firstName, String lastName, Doctor orderingDoctor )throws Exception{
        super();
        if( expiryDate == null || orderingDoctor==null || medicalExamination ==null ){
            throw new Exception("Expiry date, ordering doctor, medical Examination cannot be null.");
        }
        this.dateOfIssuing= LocalDate.now();
        this.expiryDate=expiryDate;
        this.medicalExamination=medicalExamination;
        this.PESEL=PESEL;
        this.firstName=firstName;
        this.lastName=lastName;
        this.orderingDoctor=orderingDoctor;

    }

    //get skierowania na daną usługę
    //wybierz pacjenta jakiego chcesz skierowanie
    //wybierz nazwe jaką chcesz wyszykać
    //pobierz wszytskei skietowania dla danego pacjenta
    //wybierz to skierowanie którego nazwa rowna się podana
    //sprawdź jegoo datę ważnosci
    //zwroc błąd jak nie ma takiego skierowania dla tej osoby lub nie ma takiego pacjenta
    // albo jak juz wygasło

    //sprawdz skeirowania wszytskke dla danego pacjenta



}
