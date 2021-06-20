package MASProjektZaliczeniowy;

import java.time.LocalDate;

public abstract class Medic extends Employee{


    Medic(String name, String middleName, String maidenName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String emailAddress) throws Exception {
        super(name, middleName, maidenName, lastName, pesel, birthDate, phoneNumber, emailAddress);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
