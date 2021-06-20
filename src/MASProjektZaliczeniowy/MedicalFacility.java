package MASProjektZaliczeniowy;

import java.time.LocalTime;
import java.util.List;
import java.util.ListIterator;

public class MedicalFacility extends AssociationConstraint{

    //ADRES MOZE JAKO KL
    private String address;
    private String name;
    private String email;
    private static String URLAddress="www.centrumMedyczne";
    private List<String> cooperatingFacilities;
    private LocalTime openingHours;
    private LocalTime closingHours;
    //dni otwarcia format?
    private String openOn;


    MedicalFacility( String address, String name){
        super();
        this.address=address;
        this.name=name;
    }

    public void setEmail(String email) {
        this.email=email;
    }



    public void setOpenOn(String days){
        openOn=days;
    }

    public void setClosingHours(LocalTime closingHours){
        this.closingHours=closingHours;
    }

    public void setOpeningHours(LocalTime openingHours){
        this.openingHours=openingHours;
    }


    @Override
    public String toString() {
        return "MedicalFacility{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", URLAddress='" + URLAddress + '\'' +
                ", cooperatingFacilities=" + cooperatingFacilities +
                ", openingHours=" + openingHours +
                ", closingHours=" + closingHours +
                ", openOn='" + openOn + '\'' +
                '}';
    }


    //zwróc zatrudnionych lekarzy
}
