package MASProjektZaliczeniowy;

import java.util.LinkedList;
import java.util.List;


public class AssociationConstraint extends ObjectAssociation{//klasa AssociationConstraint dziedzicząca po klasie ObjectAssociation

    private  List<String> rolesXOR = new LinkedList<>();//lista ról dla ograniczenia XOR




    AssociationConstraint(){//konstruktor

        super();//wywołanie konstruktora z andklasy
    }


    /** Metoda pozwalająca dodać rolę do ról objętych ograniczeniem XOR **/
    public void addXORRole(String roleName) {
        rolesXOR.add(roleName);//dodanie roli do listy
    }



    /** Metoda pozwalająca wyświetlić na konsoli wszytskie role objęte ograniczeniem XOR**/
    public void showXORRoles(){
        System.out.println("XOR Roles");
        for( String role: rolesXOR){//dla każdej roli na liście
            System.out.println(role);//wypisz rolę na konsoli
        }
    }


    /** Ograniczenie {XOR}**/
    /** Metoda pozwalająca dodać powiązanie z ograniczeniem XOR*/
    public void addXORConnection(String roleName, String reverseRoleName, AssociationConstraint targetObject) throws Exception {
        if(rolesXOR.contains(roleName)) {//sprawdzenie, czy dana rola zawiera się w liście ról objętych ograniczeniem XOR
            for (String role : rolesXOR) {// dla każdej z tych ról
                if (isConnetion(role)) {//sprawdzenei czy istnieje powiązanie dla tej roli
                    throw new Exception("Istnieje już połączenie dla tej roli.");//wyrzucenie wyjątku
                }
            }
        }
        addConnection(roleName, reverseRoleName, targetObject);//dodanei powiązania
    }



    /** Ograniczenie własne**/
    /** Metoda pozwalająća dodać członka do część do obiekty całosci, sprawdzając czy nie przekroczy to maxymalnej liczby części */
    public void addPartWithConstraint(String roleName, String reverseRoleName, AssociationConstraint partObject, int maxNumberOfParts) throws Exception {
        int numberOfparts;//liczba części

        try {
            List<ObjectAssociation> parts= this.getParts();//lista częsci, dla obiektu całosci
            numberOfparts=parts.size();//liczba czesci
        } catch (Exception e) {
            numberOfparts=0;//jeśli nie ma dodanej części dla obiektu liczba czesci zosaje uznana za 0
        }

        if(numberOfparts < maxNumberOfParts){//sprawdzenei czy liczba częsci do danego pbiektu całosci jest mniejsza niż maksymalna liczba częsci mogąca być przypisana do tego obiektu
            this.addPart(roleName,reverseRoleName,partObject);//dodaj czesc do obeiktu
        }else{
            throw new Exception("Nie można dodać kolejnej częsci do całości, przez limit częsci.");//wyrzuć wyjątek
        }
    }



    /** Ograniczenie {Subset}**/
    /** Metoda pozwalająća dodanie powiązania z ograniczeniem Subset */
    public void addConnectionSubset(String roleName, String reverseRoleName, String superiorRoleName, ObjectAssociation targetObject) throws Exception {
      if(isConnetion(superiorRoleName,targetObject)){//sprawdzenei czy isntieje powiązanie o danej roli między obeiktami
            addConnection(roleName,reverseRoleName,targetObject);//jeśli połączenie istniej możliwe jest utworzenia nowego połączenia
        }else{
            throw  new Exception("Nie można utworzyć. Brak powizania w ramach roli nadrzednej");//wyrzucenie wyjątku w przypadku, gdy nie istnieje połączenie nadrzędne
        }
    }






}
