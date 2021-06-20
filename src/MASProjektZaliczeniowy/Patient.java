package MASProjektZaliczeniowy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient extends  Person{

    private LocalDate registrationDate;

    private List<String> diagnosedDiseases= new ArrayList<>();//sprawdzić jak to się dodaje
    private List<String> operations= new ArrayList<>();
    private List<String>familyHistoryOfDeseases= new ArrayList<>();


    Patient(String name, String middleName, String maidenName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String emailAddress) throws Exception {
        super(name, middleName, maidenName, lastName, pesel, birthDate, phoneNumber, emailAddress);
        registrationDate=LocalDate.now();
    }

    public void addDiagnosedDisease(String diagnosedDisease){
        if(diagnosedDisease.contains(diagnosedDisease)){
            System.out.println("List already contains " + diagnosedDisease);
        }else{
            diagnosedDiseases.add(diagnosedDisease);
        }
    }



    public void addOperations(String operation){
        if(operations.contains(operation)){
            System.out.println("List already contains " + operation);
        }else{
            operations.add(operation);
        }
    }


    public void addFamilyHistoryOfDeseases(String familyHistoryOfDesease){
        if(familyHistoryOfDeseases.contains(familyHistoryOfDesease)){
            System.out.println("List already contains " + familyHistoryOfDesease);
        }else{
            familyHistoryOfDeseases.add(familyHistoryOfDesease);
        }
    }





    public void showDiagnosedDisease(){
        if(diagnosedDiseases.isEmpty()){
            System.out.println("There is no diagnosed disease.");
        }else{
            System.out.println("Diagnosed diseases:");
            for(String disease : diagnosedDiseases){
                System.out.println(disease);
            }
        }
    }


    public void showOperations(){
        if(operations.isEmpty()){
            System.out.println("There is no operations.");
        }else{
            System.out.println("Operations:");
            for(String operation : operations){
                System.out.println(operation);
            }
        }
    }


    public void showFamilyHistoryOfDeseases(){
        if(familyHistoryOfDeseases.isEmpty()){
            System.out.println("There is no family history of deseases.");
        }else{
            System.out.println("Family history of deseases:");
            for(String disease : familyHistoryOfDeseases){
                System.out.println(disease);
            }
        }
    }


    @Override
    public String toString() {
        return "Patient{" +
                "registrationDate=" + registrationDate +
                '}';
    }
}
