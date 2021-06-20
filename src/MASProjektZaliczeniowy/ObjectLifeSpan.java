package MASProjektZaliczeniowy;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public abstract class ObjectLifeSpan implements Serializable {

    private static Map<Class, List<ObjectLifeSpan>> allExtents = new Hashtable<>(); //atrybut klasowy

    /**
     * Konstruktor, którego wywowłanie spowoduje dodanie do ekstensji nowego obiektu
     * W przypadku braku odpowieniej ekstensji zostanie ona utworzona
     */

    public ObjectLifeSpan() {

        List extent = null;
        Class theClass = this.getClass();

        if (allExtents.containsKey(theClass)) {
            extent = allExtents.get(theClass);

        }else{
            extent = new ArrayList();
            allExtents.put(theClass, extent);
        }
        extent.add(this);

    }



    /**
     * Metoda klasowa
     * statyczna metoda pozwalająca dodac wybrany obiekt ObjectLifeSpan do ekstensji
     */

    public static void addObject(ObjectLifeSpan object){
        List extent = null;
        Class theClass = object.getClass();
        if (allExtents.containsKey(theClass)) {
            extent = allExtents.get(theClass);

        }else{
            extent = new ArrayList();
            allExtents.put(theClass, extent);
        }
        extent.add(object);

    }




    /**
     * Metoda klasowa
     * statyczna zwracająca ekstancje klasy, do której przynależy obiekt wprowadzony jako argument
     * @return
     */
    public static List<ObjectLifeSpan> getExtent(ObjectLifeSpan objectLifeSpan){


        if (allExtents.containsKey(objectLifeSpan.getClass())) {
            return allExtents.get(objectLifeSpan.getClass());

        }else{
            return null;//zmienic na wyrzycanie błędu
        }


    }




    /**
     * Metoda klasowa
     * Metoda statyczna zwracająca ekstancje klasy podanej jako argumnet
     * @return
     */

    public static List<ObjectLifeSpan> getExtentForClass(Class theClass){


        if (allExtents.containsKey(theClass)){
            return allExtents.get(theClass);
        }else{
            return null;//zmienic na wyrzycanie błędu
        }

    }




    /**
     * Metoda klasowa
     * Metoda statyczna pozwalająca zmienić dotychczasową ekstensję danej klasy na inną podaną jako argument
     * @return
     */

    public static void changeExtent(Class theClass,List<ObjectLifeSpan> list) throws Exception {
        List extent = null;
        List exExtent = null;

        if (allExtents.containsKey(theClass)) {

            exExtent = allExtents.get(theClass);
            extent = list;

            allExtents.replace(theClass,exExtent,extent);

        } else {
            throw new Exception("Unknown class " + theClass);
        }

        System.out.println("New extent of the class: " + theClass.getSimpleName());

        for (Object obj : extent) {
            System.out.println(obj);
        }

    }




    /**
     * Metoda klasowa
     * Metoda statyczna zapisująca wszystkie ekstensje
     */

    public static void writeExtents(ObjectOutputStream stream) throws IOException {
        stream.writeObject(allExtents);
    }




    /**
     * Metoda klasowa
     * Metoda statyczna odczytująca wszystkie ekstensje
     */

    public static void readExtents(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        allExtents = (Hashtable) stream.readObject();
    }





    /**
     * Metoda klasowa
     * Metoda pozwalająca na iteraację po ekstensji klasy
     */
    public static <T> Iterable<T> getExtent(Class<T> type) throws ClassNotFoundException {
        if(allExtents.containsKey(type)) {
            return (Iterable<T>) allExtents.get(type);
        }

        throw new ClassNotFoundException(String.format("%s. Stored extents: %s", type.toString(), allExtents.keySet()));
    }




    /**
     * Metoda klasowa
     * Metoda statyczna wypisująca ekstensje podanej w argumencie klasy
     */
    public static void showExtent(Class theClass) throws Exception {
        List extent = null;

        if(allExtents.containsKey(theClass)) {
            // Extent of this class already exist
            extent = allExtents.get(theClass);
        }
        else {
            throw new Exception("Unknown class " + theClass);
        }

        System.out.println("Extent of the class: " + theClass.getSimpleName());

        for(Object obj : extent) {
            System.out.println(obj);
        }
    }









}



