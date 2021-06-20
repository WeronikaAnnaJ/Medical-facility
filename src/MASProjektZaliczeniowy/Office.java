package MASProjektZaliczeniowy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Office extends  AssociationConstraint{
    private int number;
    private List<String> medicalEquioment= new ArrayList<>();
    private boolean isSanitized;

    private static Map<Invoice, Office> numbers=new LinkedHashMap<>();

    //czywolny
    //czy zarezerwownay w klasie rezerwacja gabinetu
    //zlecenie dezynfekcji po każdym wynajęciu


    Office(int number) throws Exception {
        super();
        isSanitized=false;
        if(numbers.containsKey(number)){
            throw new Exception("Office "+ number +" already exists.");
        }
        this.number=number;//niepowtarzalny
    }

    public void addMedicalEquioment(String medicalEquioment){
        this.medicalEquioment.add(medicalEquioment);

    }

    public void sanitizeOffice(){
        isSanitized=true;
    }

    public void setNeedForSanitize(){
        isSanitized=false;

    }
}
