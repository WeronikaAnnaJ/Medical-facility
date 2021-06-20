package MASProjektZaliczeniowy;

import java.time.LocalDate;

public class Administrator extends Employee{


    Administrator(String name, String middleName, String maidenName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String emailAddress) throws Exception {
        super(name, middleName, maidenName, lastName, pesel, birthDate, phoneNumber, emailAddress);
    } //klasa dziedzicząca po klasie abstrakcyjnej PracownikNiemedyczny




}

