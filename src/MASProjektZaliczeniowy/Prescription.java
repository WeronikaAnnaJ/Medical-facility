package MASProjektZaliczeniowy;

import java.time.LocalDate;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Prescription extends AssociationConstraint{
    private int code;
    private String PESEL;
    private String firstName;
    private String lastName;
    //dane lekarza?
    //kod leku i ilosc sztuk
    private Map<Map<Integer,String>,Integer> medications=new Hashtable<>();
    private Map<Integer, String> medication=new Hashtable<>();
    private LocalDate expiryDate;

    Prescription(int code, String PESEL, String firstName, String lastName, Map<Map<Integer,String>,Integer> medications, LocalDate expiryDate)throws Exception{
        super();
        this.code=code;
        //pobrać mozw pesel i imiona i lekarza wystawiającego z połaćzeń
        if(expiryDate==null){
            throw new Exception("Expiry date cannot be null.");
            //cprawdzić czy data nie jest wczensijesza niż dzisiejszA?

        }
        this.expiryDate=expiryDate;
        this.medications=medications;

    }


    public int getCode(){
        return code;
    }

    //sprawdź datę wygaśięcia recepty metoda, sprawdzająca czy recepta jets aktualna


}
