package MASProjektZaliczeniowy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WardClerk extends Employee{

    List<String>languages= new ArrayList<>();// conajmniej 2 języki


    WardClerk(String name, String middleName, String maidenName, String lastName, String pesel, LocalDate birthDate, String phoneNumber, String emailAddress,
             List<String> languages) throws Exception {
        super(name, middleName, maidenName, lastName, pesel, birthDate, phoneNumber, emailAddress);
        if(languages.size()<2){
            throw new Exception("Cannot hire ward clark who knows less than 2 languages.");
        }
        this.languages=languages;
    }

    public void addLanguage(String language){
        if(!languages.contains(language)){
            languages.add(language);
        }else{
            System.out.println(" List already contains " + language);
        }
    }


    public void showLanguages(){
        System.out.println("Languages: ");
        for(String language : languages){
            System.out.println(language);
        }
    }


    @Override
    public String toString() {
        return "WardClerk{" +super.toString()+
                '}';
    }
}
