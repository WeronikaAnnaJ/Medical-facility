package MASProjektZaliczeniowy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class appointmentChoice extends JFrame {
    private JPanel jPanelAppointment;
    private JComboBox comboBoxSpecializations;
    private JComboBox comboBoxDates;
    private JButton wybierzTerminWizytyButton;
    private JPanel jPanelDates;
    private List<String> availableSpecializations;

    private  Object selectedItem;
    private  Object selectedData;

    private String selectedSpecialization;
    private String selectedAppointmentTime;

    List<String> informationsForComboBox= new LinkedList<>();


    Map<Doctor, Map<LocalDateTime, Boolean> > visitsInformation= new TreeMap<>();

    appointmentChoice(String title,List<String>availableSpecializations, MedicalFacility medicalFacility){
            super(title);
            this.availableSpecializations=availableSpecializations;

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(jPanelAppointment);
            this.pack();
            comboBoxDates.addItem("--");
            informationsForComboBox.add("--");




        comboBoxSpecializations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedItem = comboBoxSpecializations.getSelectedItem();

                selectedSpecialization=selectedItem.toString();

                System.out.println(selectedSpecialization);
                try {

                    List<Doctor> doctors= Doctor.getDoctors(Doctor.getMedicalSpecialistFor(selectedSpecialization),medicalFacility);
                    for(Doctor doctor : doctors){
                        System.out.println("Doctor " + doctor.getName() +" " + doctor.getLastName());
                    }
                    //teraz najlepiej zeby posegregować wizyty
                    //stworzyć nowego boxa który wyświetli wizyty


                    informationsForComboBox= new LinkedList<>();

                    for (Doctor doctor : doctors) {
                        String doctorName= doctor.getName() + " " + doctor.getLastName();
                        System.out.println("Doctor " + doctor.getName() + " " + doctor.getLastName());

                        Map<LocalDateTime, Boolean> availableDates= doctor.getDatesWhere(true);

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd   HH:mm");

                        availableDates.forEach((key, value)->{
                            String rowForComboBox = key.format(formatter) + "     " + doctorName;
                            informationsForComboBox.add(rowForComboBox);
                        });
                        //  Doctor.showMap(availableDates);
                        // visitsInformation.put(doctor, availableDates);


                        System.out.println("Information for Combo box");

                    }

                    for (String s : informationsForComboBox){
                        System.out.println(s);
                    }
                    //POUKŁADAĆ JE W ODPOWIEDNIEJ KOLEJNOŚCI ŻEBY SIE WYŚWIETLĄŁY

                    //SPRAWDZIĆ SKIEROWANIE / ALBO WYPEŁNIĆ ANKIETĘ

                    System.out.println("Informatio for combo box is it empty ? " +  informationsForComboBox.isEmpty());


                    //teraz najlepiej zeby posegregować wizyty
                    //stworzyć nowego boxa który wyświetli wizyty
                    //metoda dodająca do comboBox dane i moze je segregujaca?
                    if(informationsForComboBox!=null){
                        comboBoxDates.removeAllItems();
                    }


                    for (String s : informationsForComboBox){
                        comboBoxDates.addItem(s);
                    }





                } catch (Exception exception) {
                    //co tu zrobic w razie błędu zdecydować
                    // chyba poinformować ze nie ma terminów
                    // czy zwracać moze same available=true?
                    System.out.println("No dates available. ");
                    exception.printStackTrace();
                }
            }

        });
     /*   comboBoxDates.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selectedItem != null){
                    String selectedSpecialization=selectedItem.toString();
                    System.out.println("AAAAA");


                    try {
                        //albo stworzZć metoda w klasie która znajduje wszystkich lekarzy danego typu
                        //metoda która zwrata tylko wizyty aktywne
                        //moze metoda ktra zmienia stringa i zwraca odpowieni enum
                        List<Doctor> doctors= Doctor.getDoctors(Doctor.getMedicalSpecialistFor(selectedSpecialization),medicalFacility);
                        for(Doctor doctor : doctors){
                            System.out.println("Doctor " + doctor.getName() +" " + doctor.getLastName());
                           Map<LocalDateTime, Boolean> availableDates= doctor.getDatesWhere(true);
                           Doctor.showMap(availableDates);
                           visitsInformation.put(doctor, availableDates);
                        }
                        //teraz najlepiej zeby posegregować wizyty
                        //stworzyć nowego boxa który wyświetli wizyty






                    } catch (Exception exception) {
                        //co tu zrobic w razie błędu zdecydować
                        // chyba poinformować ze nie ma terminów
                        // czy zwracać moze same available=true?
                        System.out.println("No dates available. ");
                        exception.printStackTrace();
                    }
                    //pobierz Obiekt jako string
                    //pobierz wszytkich lekarzy
                    //zgromadz lekarzy o specjalizacji w tym obiekcie




                }else{
                    //ma się pojawiać jako wskazówka?
                    System.out.println("Please, choose type of doctor you looking for.");
                }

            }
        });


    }/*


      */

        wybierzTerminWizytyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedItem != null) {

                    System.out.println("Nie jest == null");
                  //  jPanelDates.setVisible(true);
                    //wybierz wizyty dla danego lekarza
                    selectedSpecialization = selectedItem.toString();
                    try {

                        List<String> informationsForComboBox= new LinkedList<>();
                        List<Doctor> doctors = Doctor.getDoctors(Doctor.getMedicalSpecialistFor(selectedSpecialization), medicalFacility);


                        for (Doctor doctor : doctors) {
                            String doctorName= doctor.getName() + " " + doctor.getLastName();
                            System.out.println("Doctor " + doctor.getName() + " " + doctor.getLastName());

                            Map<LocalDateTime, Boolean> availableDates= doctor.getDatesWhere(true);

                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd   HH:mm");

                            availableDates.forEach((key, value)->{
                               String rowForComboBox = key.format(formatter) + "     " + doctorName;
                               informationsForComboBox.add(rowForComboBox);
                            });
                          //  Doctor.showMap(availableDates);
                           // visitsInformation.put(doctor, availableDates);


                            System.out.println("Information for Combo box");

                        }

                        for (String s : informationsForComboBox){
                            System.out.println(s);
                        }
                        //POUKŁADAĆ JE W ODPOWIEDNIEJ KOLEJNOŚCI ŻEBY SIE WYŚWIETLĄŁY

                        //SPRAWDZIĆ SKIEROWANIE / ALBO WYPEŁNIĆ ANKIETĘ


                        //teraz najlepiej zeby posegregować wizyty
                        //stworzyć nowego boxa który wyświetli wizyty
                        //metoda dodająca do comboBox dane i moze je segregujaca?
                   //    comboBoxDates.removeAllItems();
                        for (String s : informationsForComboBox){
                            comboBoxDates.addItem(s);
                        }


                    } catch (Exception exception) {
                        //co tu zrobic w razie błędu zdecydować
                        // chyba poinformować ze nie ma terminów
                        // czy zwracać moze same available=true?
                        System.out.println("No dates available. ");
                        exception.printStackTrace();

                    }
                } else {
                    //komunikat co jak jest null napisać
                    System.out.println("Jest == null");
                }

            }
        });


        comboBoxDates.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedData = comboBoxDates.getSelectedItem();
                System.out.println("Selected data" + selectedData);
             //   selectedAppointmentTime=selectedData.toString();
              //  System.out.println("Selected" + selectedAppointmentTime);


                //co zrobić gdy ktoś spowrotem kliknie na specjaliste
            }
        });



    }

    public String getSelectedAppointmentTime(){
        return selectedAppointmentTime;
    }
    public String getSelectedSpecialization(){
        return  selectedSpecialization;
    }


}