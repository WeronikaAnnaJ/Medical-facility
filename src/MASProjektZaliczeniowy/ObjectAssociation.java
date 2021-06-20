package MASProjektZaliczeniowy;

import java.io.Serializable;
import java.util.*;

public abstract class ObjectAssociation extends ObjectLifeSpan implements Serializable { //klasa abstrakcyjna, dziedzicząca po klasie abstrakcyjnej ObjectLifeSpan, implementująca Serializable


    /** Kolekcja mapująca, kluczem jest rola asocjacji, a wartością mapa, która przechowuje jako klucz kwalifikator, a jako watość referencję do obiektu docelowego w sposób uporządkowany*/
    private Map<String, LinkedHashMap<Object, ObjectAssociation>> Conections = new LinkedHashMap <>();


    /** Kontener przecgowujący referencje do obiektów - części, połączonych z obiektem-całość */
    private static Set<ObjectAssociation> allParts = new HashSet<>();


    /** Kontener przecgowujący referencje do obiektów - części, połączonych z danym obiektem-całość w uporządkowanej kolejnośći */
    private static Map<ObjectAssociation,List<ObjectAssociation>> partsForWhole = new LinkedHashMap<>();




    public ObjectAssociation() { //kontruktor

        super(); //wywołanie konstruktora z nadklasy
    }







    /** Metoda sprawdzająca czy istnieje powiązanie obiektu do podanego obiektu w ramach danej roli*/
    public boolean isConnetion(String roleName, ObjectAssociation targetObject){

        Map<Object, ObjectAssociation> objectConnections; //kolekcja powiązań obiektu

        if(!Conections.containsKey(roleName)) { //sprawdzenie, czy rola występuje jako klucz w kolekcji zawierającej połączenia
           return false;
        }
        objectConnections= Conections.get(roleName);//przypsanie kolekcji
        return objectConnections.containsValue(targetObject); //zwrocenie infromacji czy istnieje asocjacja z danym obiektem

    }



    /** Metoda sprawdzająca czy istnieje powiązanie do podanego obiektu w ramach danej roli*/
    public boolean isConnetion(String roleName){
        if(!Conections.containsKey(roleName)) { //sprawdzenie, czy rola występuje jako klucz w kolekcji zawierającej połączenia
            return false;
        }
            return true;
    }




    /** Metoda publiczna pozwalająca na sprawdzenie ilości część w ramach kompozycji*/
    public  List<ObjectAssociation>  getParts() throws Exception {

        if (!partsForWhole.containsKey(this)) { //sprawdzenie czy obiekt-część już jest połączony z obiektem-cąłość
            throw new Exception("Nie ma żadnych części przypisanych do tego obiektu.");//wyrzucenie wyjątku
        }
        return partsForWhole.get(this);//zwrócenie listy części dla obiektu-całości na rzecz, którego została wywołana metoda
    }




    /** Metoda publiczna pozwalająca na wyświetlenie część w ramach kompozycji*/
    public  void showParts() throws Exception {

        if (!partsForWhole.containsKey(this)) { //sprawdzenie czy obiekt-część jest połączony z obiektem-cąłość
            throw  new Exception("Nie ma żadnych części przypisanych do tego obiektu.");//wyrzucenie wyjątku
        }
        List<ObjectAssociation> parts= partsForWhole.get(this);//przypisanie uporządkowanych częsci dla tego obiektu do listy

        for(ObjectAssociation part :parts){//dla każdego obiektu z listy
            System.out.println(part);//wyświetl na konsoli część
        }
    }




    /** Metoda publiczna dodająca część w ramach kompozycji i posegregować częsci do odopowenich obiektów*/
    public void addPart(String roleName, String reverseRoleName, ObjectAssociation partObject) throws Exception {

        if(allParts.contains(partObject)) { //sprawdzenie czy obiekt-część już jest połączony z obiektem-cąłość
            throw new Exception("Nie można dodać połączenia, część już połączona z obiektem-całością.");//wyrzucenie wyjśtku
        }
        addConnection(roleName, reverseRoleName, partObject);//dodanie połączenia
        allParts.add(partObject);//dodanie części do konera połączynych z całością części

        List<ObjectAssociation> partsFor= new ArrayList<>();//stworzenie listy częsci

        if(partsForWhole.containsKey(this)){//sprawdzenie czy kolekcja czesci dla konkretnej całosci zawiera klucz w postaci obiektu-całości
            partsFor=partsForWhole.get(this);//obrana jest lista częsci dla danej całosći
            partsForWhole.remove(this);//usuniety zostaje całość z kolekcji
        }
        partsFor.add(partObject);//częśc zostaje dodana do listy cześći
        partsForWhole.put(this,partsFor);//lista części wraz z obiektem-całością jako kluczem zostaje dodana do kolekcji

    }





    /** Metoda pozwalajaca dodać nowe powiązanie między obiektami, używana w innych metodach tej klasy */
    private void addConnection(String roleName, String reverseRoleName, ObjectAssociation targetObject, Object qualifier, int counter) {

        LinkedHashMap<Object, ObjectAssociation> objectConnections; //klekcja powiązań obiektu

        if(counter < 1) { //zabezpieczenie przed zapętleniem się wywołań metody
            return;
        }

        if(Conections.containsKey(roleName)) { //sprawdzenie, czy rola występuje jako klucz w kolekcji zawierającej połączenia
            objectConnections = Conections.get(roleName); //przypisana zostaje kolekcja połączeń
        }
        else {
            objectConnections = new LinkedHashMap<>(); //zostaje utworzona nowa kolekcja
            Conections.put(roleName, objectConnections); // kolekcja zostaje wstawiona do głównej kolekcji mapującej, gdzie jako klucz jest rola asocjacji
        }

        if(!objectConnections.containsKey(qualifier)) { //sprawdzenie czy w kolekcji zawiera się identyfikator
            objectConnections.put(qualifier, targetObject); //dodanie informacji o nowym powiązaniu

            targetObject.addConnection(reverseRoleName, roleName, this, this, counter --);//tworzenie połączenia zwrotnego
        }
    }


    /** Metoda publiczna dodająca powiązanie w ramach asocjacji kwalifikowanej */
    public void addConnectionWithQualifier(String roleName, String reverseRoleName, ObjectAssociation targetObject, Object qualifier) {
        addConnection(roleName, reverseRoleName, targetObject, qualifier,2); //wywołanie metody prywatnej z tej klasy
    }



    /** Metoda publiczna pozwalajaca dodać powiązanie*/
    public void addConnection(String roleName, String reverseRoleName, ObjectAssociation targetObject) { //metoda pozwalajaca dodać asocjację binarną
        addConnection(roleName, reverseRoleName, targetObject, targetObject,2);//wywołanie metody prywatnej z tej klasy
    }




    /** Metoda publiczna pozwalajaca utworzuć powiązanie w ramach asocjacji z atrybutem*/
    public void addConnectionWithAttribute(String roleName, String reverseRoleName, ObjectAssociation targetObject,  ObjectAssociation  attribute) throws Exception {

        addConnection(roleName, reverseRoleName, attribute); //dodanie połączenia między klasą na rzecz, której została wywołana metoda  a klasą -atrybutem asocjacji

        targetObject.addConnection(reverseRoleName, roleName,attribute); //połączenie miedzy opiektem, po drógiej stronie asocjacji , a klasą-atrybutem asocjacji

    }


    /** Metoda wyświetlająca powiązania  w ramach asocjacji z atrybutem dla podanej roli*/
    public void showConnectionWithAttribute(String roleName) throws Exception { //metoda pozwalająca wyświetlić powiązane obiekty i atrybuty asocjacji

        Map<Object, ObjectAssociation> objectConnections; //kolekcja powiązań obiektu


        if(!Conections.containsKey(roleName)) { //sprawdzenie czy kolekcji zawarta jest rola

            throw new Exception("Nie odnaleziono połączeń dla tej roli.");
        }

        objectConnections = Conections.get(roleName); //pozyskiwana kolekcja dla roli

        Collection collection = objectConnections.values(); //pozyskujemy powiązań jako wartość

        System.out.println("\nRole: "+roleName + " For: "+this.getClass().getSimpleName()+"\n"+ this+"\n" );


        int counter = 1; //licznik obiektów

        for(Object obj : collection) { //dla każdego obiektu znajdującego się w kolekcji
            ObjectAssociation objectAssociation= (ObjectAssociation)obj; //rzutowanie
            ObjectAssociation [] reverseObject=objectAssociation.getConnections(roleName); //zapisanie połąceń obiektu do tabeli

            System.out.println( counter +"." + reverseObject[0] +"\n"+  obj); //wypisanie infromacji o obiekcie
            counter ++;
        }

        System.out.println();
    }





    /** Metoda zwracająca obiekt docelowy dla podanej roli*/
    public ObjectAssociation[] getConnections(String roleName) throws Exception { //poztskanie powiązanuch obiektów identyfikowanych przez rolę asocjacji
        Map<Object, ObjectAssociation> objectConnections;  //kolekcja powiązań obiektu

        if(!Conections.containsKey(roleName)) {//sprawdzenie czy istnieją połączenia dla tej roli
            throw new Exception("Nie odnaleziono połączeń dla tej roli."); //wyrzucenie wyjątku
        }
        objectConnections = Conections.get(roleName);

        return (ObjectAssociation[]) objectConnections.values().toArray(new ObjectAssociation[0]); //zwrócenie tablicy
    }




    /** Metoda wyświetlająca powiązania dla podanej roli*/
    public void showConnections(String roleName) throws Exception { //wyświetlenie powiązanych obiektów dla podanej roli

        Map<Object, ObjectAssociation> objectConnections; //kolekcja powiązań obiektu

        if(!Conections.containsKey(roleName)) {//sprawdzenie czy istnieją połączenia dla tej roli
            throw new Exception("Nie odnaleziono połączeń dla tej roli."); //wyrzucenie wyjątku
        }

        objectConnections = Conections.get(roleName); //odzyskanie powiązań dla roli

        Collection collection = objectConnections.values();//pobranie powiązań jako wartość

        System.out.println("\nRole: "+roleName + " For: "+this.getClass().getSimpleName()+"\n"+ this+"\n" );//wyświetlenie nazwy roli, klasy i obiektu, na rzecz, którego metoda została wywołana

        int counter = 1;

        for(Object obj : collection) { //dla każdego obiektu z kolekcji
            System.out.println( counter +"." +obj);
            counter ++;
        }

        System.out.println();
    }



    /** Metoda wzwracająca obiekt na podstawie kwalifikatora*/
    public ObjectAssociation getConnectedObject(String roleName, Object qualifier) throws Exception { //metoda zwracająca obiekty na podstawie kwalifikatora
        Map<Object, ObjectAssociation> objectConnections; //kolekcja powiązań obiektu

        if(!Conections.containsKey(roleName)) { //sprawdzenie czy istnieją połączenia dla tej roli
            throw new Exception("Nie odnaleziono połączeń dla tej roli."); //wyrzucenie wyjątku
        }
        objectConnections = Conections.get(roleName); //odzyskanie powiązań dla roli

        if(!objectConnections.containsKey(qualifier)) { //sprawdzenie mapa zawiera podany kwalifikator
            throw new Exception("Nie ma połączeń dla kwalifikatora : " + qualifier); //wyrzucenie wyjątku
        }
        return objectConnections.get(qualifier);//zwrócenie obiektu na podstawie klucza, którym jest kwalifikator
    }




    /** Metoda wyświetlająca powiązany obiekt dla podanej roli w przypadku asocjacji kwalifikowanej*/
    public void showConnedtedObjectWithQualifier(String roleName, Object qualifier) throws Exception{ //metoda wyswietlająca obiekty na podstawie kwalifikatora
        Map<Object, ObjectAssociation> objectConnections; //kolekcja powiązań obiektu
        if(!Conections.containsKey(roleName)){
            throw new Exception("Nie odnaleziono połączeń dla tej roli.");
        }

        objectConnections=Conections.get(roleName);//odzyskanie powiązań dla roli

        if(!objectConnections.containsKey(qualifier)){ //sprawdzenie mapa zawiera podany kwalifikator

            throw new Exception("Nie ma połączeń dla kwalifikatora : " + qualifier);//wyrzucenie wyjątku
        }

        System.out.println( "\n"+ roleName + " for "  +this+ "\n"+objectConnections.get(qualifier)); //wyswietlenie obiektu na rzecz, którego wywołano metodę i obiektu połączonego, zidentyfikownego przez kwalifikator

    }
}