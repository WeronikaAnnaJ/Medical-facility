package MASProjektZaliczeniowy;

import java.time.LocalDate;

public class Invoice extends AssociationConstraint{
    private LocalDate dateOfInvoicing;
    private float amount;
    //DAne wystawiającego stałe dla wszystkiego
    //usługa
    //dane osoby


    Invoice(LocalDate dateOfInvoicing, float amount){
        super();
        if(dateOfInvoicing==null){
            this.dateOfInvoicing=LocalDate.now();
        }else{
            this.dateOfInvoicing=dateOfInvoicing;
        }

        this.amount=amount;

    }
//oblicz sume faktur dla danej osoby metoda static



}
