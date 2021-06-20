package MASProjektZaliczeniowy;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Person extends AssociationConstraint{ //klasa abstrakcyjna

    private String name;
    private String middleName;
    private String maidenName;
    private String lastName;
    private String pesel;
    private LocalDate birthDate;
    //adres
    private String phoneNumber;
    private String emailAddress;

    private static Map<String, Person> allPESELS=new LinkedHashMap<>();

    Person (String name, String middleName, String maidenName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String emailAddress) throws Exception { //konstruktor dla klasy Osoba

        if(name == null || lastName == null || pesel == null || birthDate == null || phoneNumber == null){
            throw new Exception("Name, lastName, pasel, pirthDate, phoneNumber value cannot be null. ");
        }
        /** Ograniczenie {Unique}  **/
        if(allPESELS.containsKey(pesel)){ //sprawdzenie, czy podany PESEL już istnieje i jest zapisany
            throw  new Exception("Pesel " + pesel +" is no longer available."  );//wyrzucenie wyjątku, blokującego utworzenie kolejnego pracownika z tym samym peselem
        }

        allPESELS.put(pesel, this);//dodanie peselu i obiektu do mapy
        this.pesel=pesel;

        this.name=name;
        this.middleName=middleName;
        this.maidenName=maidenName;
        this.lastName=lastName;
        this.birthDate=birthDate;
        this.phoneNumber=phoneNumber;
        this.emailAddress=emailAddress;

    }

    public int getAge(){
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", maidenName='" + maidenName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}

