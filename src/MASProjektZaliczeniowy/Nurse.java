package MASProjektZaliczeniowy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;




public class Nurse extends Medic{


    private List<String> specialistCourse= new ArrayList<>();
    //egzamin z jezyka ang conajmniej B2
    //stopień ukończonych studiów pielęgniarskich
    //godziny praktyk
    //czy w trakcie kształcenia



    Nurse(String name, String middleName, String maidenName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String emailAddress) throws Exception {
        super(name, middleName, maidenName, lastName, pesel, birthDate, phoneNumber, emailAddress);
    } //klasa Lekarz dziedzicząca po klasie Pracownik Medyczny



}
