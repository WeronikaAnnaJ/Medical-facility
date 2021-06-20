package MASProjektZaliczeniowy;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) {


        try {
            Employee employee = new Employee("Karol", "Wojciech", null, "Karolak", "1", LocalDate.of(1990, 12, 12), "111-111-111", "karol.wojciech.karolak@wp.pl");
            employee.setEmploymentDate(LocalDate.of(2020,6,1));
            System.out.println(employee);
            System.out.println(employee.getPeriodOfEmployment());

            EmploymentContract employmentContract= new EmploymentContract(Tenure.FullTime);
            employmentContract.setSalary(3000);

            //połaczenie z zatrudnieniem 1 do 1 czy jak
            employee.addConnection("employed under","apply to", employmentContract);
            employee.showConnections("employed under");

        } catch (Exception e) {
            e.printStackTrace();
        }

        //rejestratorki
        try {
            List<String> languages0=new ArrayList<>();
            languages0.add("Polish");
            languages0.add("English");

            WardClerk wardClerk0=new WardClerk("Karol", "Wojciech", null, "Karolak", "2", LocalDate.of(1990, 12, 12), "111-111-111", "karol.wojciech.karolak@wp.pl",languages0);
            wardClerk0.setEmploymentDate(LocalDate.of(2020,6,1));
            System.out.println(wardClerk0);
            System.out.println(wardClerk0.getPeriodOfEmployment());

            EmploymentContract employmentContract0= new EmploymentContract(Tenure.FullTime);
            employmentContract0.setSalary(3000);

            //połaczenie z zatrudnieniem 1 do 1 czy jak
            wardClerk0.addConnection("employed under","apply to", employmentContract0);
            wardClerk0.showConnections("employed under");

        } catch (Exception e) {
            e.printStackTrace();
        }



        try {
            List<String> languages1=new ArrayList<>();
            languages1.add("Polish");
            languages1.add("English");

            WardClerk wardClerk1=new WardClerk("Karol", "Wojciech", null, "Karolak", "3", LocalDate.of(1990, 12, 12), "111-111-111", "karol.wojciech.karolak@wp.pl", languages1);
            wardClerk1.setEmploymentDate(LocalDate.of(2020,6,1));
            System.out.println(wardClerk1);
            System.out.println(wardClerk1.getPeriodOfEmployment());

            EmploymentContract employmentContract1= new EmploymentContract(Tenure.FullTime);
            employmentContract1.setSalary(3000);

            //połaczenie z zatrudnieniem 1 do 1 czy jak
            wardClerk1.addConnection("employed under","apply to", employmentContract1);
            wardClerk1.showConnections("employed under");
        } catch (Exception e) {
            e.printStackTrace();
        }



        try {
            List<String> languages2=new ArrayList<>();
            languages2.add("Polish");
            languages2.add("English");

            WardClerk wardClerk2=new WardClerk("Karol", "Wojciech", null, "Karolak", "4", LocalDate.of(1990, 12, 12), "111-111-111", "karol.wojciech.karolak@wp.pl",languages2);
            wardClerk2.setEmploymentDate(LocalDate.of(2020,6,1));
            System.out.println(wardClerk2);
            System.out.println(wardClerk2.getPeriodOfEmployment());
            wardClerk2.addLanguage("Italian");
            wardClerk2.showLanguages();

            EmploymentContract employmentContract2= new EmploymentContract(Tenure.FullTime);
            employmentContract2.setSalary(3000);


            //połaczenie z zatrudnieniem 1 do 1 czy jak
            wardClerk2.addConnection("employed under","apply to", employmentContract2);
            wardClerk2.showConnections("employed under");
        } catch (Exception e) {
            e.printStackTrace();
        }



        try {
            List<String> languages3=new ArrayList<>();
            languages3.add("Polish");
            languages3.add("English");

            WardClerk wardClerk3=new WardClerk("Karol", "Wojciech", null, "Karolak", "5", LocalDate.of(1990, 12, 12), "111-111-111", "karol.wojciech.karolak@wp.pl",languages3);
            wardClerk3.setEmploymentDate(LocalDate.of(2020,6,1));
            System.out.println(wardClerk3);
            System.out.println(wardClerk3.getPeriodOfEmployment());
            wardClerk3.addLanguage("Japanese");
            wardClerk3.showLanguages();


            EmploymentContract employmentContract3= new EmploymentContract(Tenure.FullTime);
            employmentContract3.setSalary(3000);

            //połaczenie z zatrudnieniem 1 do 1 czy jak
            wardClerk3.addConnection("employed under","apply to", employmentContract3);
            wardClerk3.showConnections("employed under");

        } catch (Exception e) {
            e.printStackTrace();
        }


        //utwózz lekarza dodaj go do lekarzy

        //moze zmienić ze zamiast klasy dane medyczne i pacjent połączyć to w jedna klase pacjent



        //stworzyc pacjenta
        try {
          //  Patient patient= new Patient("Karol", "Wojciech", null, "Karolak", "5", LocalDate.of(1990, 12, 12), "111-111-111", "karol.wojciech.karolak@wp.pl");
            //PRZEJRZEC LEKARZY ZATRUDNIONYCH I WYBRAC LEKARZA Prowadzacego
            //metoda dla lekarza wybierz lekarzy static

        } catch (Exception e) {
            e.printStackTrace();
        }

        //stworzyc dokumentacje medyczna
        //dodac lekarza prowadzacego

        //tworzyc recepte
        //lekarz zleca recepte

        //sprawdz to zeby pozyskiwac info z połaczenia
        //zobacz recepte dla tego pacjenta




        //Stworzyć placówkę medyczną

        MedicalFacility medicalFacility= new MedicalFacility("Medyczna 5 Warszawa 15-876", "Centrum Medyczne");
        medicalFacility.setEmail("centrum_medyczne@gmail.com");
        medicalFacility.setOpeningHours(LocalTime.of(7,30));
        medicalFacility.setClosingHours(LocalTime.of(20,00));
        medicalFacility.setOpenOn("Pon - Pt");

        System.out.println(medicalFacility);

        //utworzyć lekarzy 4
        try{
            Doctor doctor= new Doctor("Karol", "Wojciech", null, "Karolak", "7", LocalDate.of(1990, 12, 12), "111-111-111", "karol.wojciech.karolak@wp.pl","1", MedicalSpecialist.Dermatologist);
            doctor.addSpecialization(MedicalSpecialist.FamilyDoctor);
            System.out.println(doctor);
            doctor.showSpecializations();

            //zatrudnienie w placówce

            doctor.addConnection("employed","employ",medicalFacility);

            doctor.addAvaliableDate(LocalDateTime.of(2021,6,6,8,15) );
            doctor.addAvaliableDate(LocalDateTime.of(2021,6,9,10,15) );
            doctor.addAvaliableDate(LocalDateTime.of(2021,6,9,11,15) );
            doctor.addAvaliableDate(LocalDateTime.of(2021,6,10,15,0) );
            doctor.addAvaliableDate(LocalDateTime.of(2021,6,10,8,0) );

            doctor.showDates();

        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            Doctor doctor1= new Doctor("Karol", "Wojciech", null, "Karolak", "8", LocalDate.of(1990, 12, 12), "111-111-111", "karol.wojciech.karolak@wp.pl","2", MedicalSpecialist.Internist);
            doctor1.addSpecialization(MedicalSpecialist.Gynaecologist);
            System.out.println(doctor1);
            doctor1.showSpecializations();

            //zatrudnienie w placówce

            doctor1.addConnection("employed","employ",medicalFacility);

            doctor1.addAvaliableDate(LocalDateTime.of(2021,6,6,8,15) );
            doctor1.addAvaliableDate(LocalDateTime.of(2021,6,6,10,15) );
            doctor1.addAvaliableDate(LocalDateTime.of(2021,6,6,11,15) );
            doctor1.addAvaliableDate(LocalDateTime.of(2021,6,11,15,0) );
            doctor1.addAvaliableDate(LocalDateTime.of(2021,6,11,8,0) );

            doctor1.changeDateAvailability(LocalDateTime.of(2021,6,6,8,15), false);
            doctor1.changeDateAvailability(LocalDateTime.of(2021,6,11,15,0), false);
            doctor1.changeDateAvailability(LocalDateTime.of(2021,6,11,8,0), false);

            System.out.println("\nAvailable dates for " + doctor1);
            Map<LocalDateTime, Boolean> availableDates= doctor1.getDatesWhere(true);
            availableDates.forEach((key, value)->{
                System.out.println("Time : "+ key.format( DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + " - "+ value);

            });
            doctor1.showDates();
        }catch(Exception e){
            e.printStackTrace();
        }



        try{
            Doctor doctor2= new Doctor("Karol", "Wojciech", null, "Karolak", "9", LocalDate.of(1990, 12, 12), "111-111-111", "karol.wojciech.karolak@wp.pl","3", MedicalSpecialist.Neurologist);
            doctor2.addSpecialization(MedicalSpecialist.FamilyDoctor);
            System.out.println(doctor2);
            doctor2.showSpecializations();


            doctor2.addAvaliableDate(LocalDateTime.of(2021,6,8,8,15) );
            doctor2.addAvaliableDate(LocalDateTime.of(2021,6,9,8,15) );
            doctor2.addAvaliableDate(LocalDateTime.of(2021,6,10,8,15) );
            doctor2.addAvaliableDate(LocalDateTime.of(2021,6,11,8,0) );
            doctor2.addAvaliableDate(LocalDateTime.of(2021,6,12,8,0) );

            doctor2.showDates();

            //zatrudnienie w placówce

            doctor2.addConnection("employed","employ",medicalFacility);
        }catch(Exception e){
            e.printStackTrace();
        }



        try{
            Doctor doctor3= new Doctor("Karol", "Wojciech", null, "Karolak", "10", LocalDate.of(1990, 12, 12), "111-111-111", "karol.wojciech.karolak@wp.pl","3", MedicalSpecialist.FamilyDoctor);
            doctor3.addSpecialization(MedicalSpecialist.Cardiologist);
            System.out.println(doctor3);
            doctor3.showSpecializations();

            //zatrudnienie w placówce

            doctor3.addConnection("employed","employ",medicalFacility);

/*
            doctor3.addAvaliableDate(LocalDateTime.of(2021,6,8,8,15) );
            doctor3.addAvaliableDate(LocalDateTime.of(2021,6,9,8,15) );
            doctor3.addAvaliableDate(LocalDateTime.of(2021,6,10,8,15) );
            doctor3.addAvaliableDate(LocalDateTime.of(2021,6,11,8,0) );
            doctor3.addAvaliableDate(LocalDateTime.of(2021,6,12,8,0) );
*/
            doctor3.showDates();

        }catch(Exception e){
            e.printStackTrace();
        }

        //wyświtl wszystkich lekarzy z placówek
        try {
            medicalFacility.showConnections("employ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //przyłączyć lekarzy do placówki medycznej


        //sprawdzenie metody getAllDoctors
        try {
            List<Doctor> doctors= Doctor.getDoctorsEmployedIn(medicalFacility);
            for(Doctor doctor : doctors){
                System.out.println(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Object Life Span");
        //stwórz pacjentów 5 i dodaj im lekarza prowadzącego, a co jak pacjent nie ma lekarza prowadzącego
        //sprawdz czy sa dodanie ich kolekcja do zapisywania
        List<ObjectLifeSpan> ob= ObjectLifeSpan.getExtentForClass(WardClerk.class);
        for(ObjectLifeSpan o: ob){
            System.out.println(o);
        }

        JFrame frame=new setAppointment("My Appointment");
        frame.setVisible(true);
        List<String> doctorsForApoointment=new ArrayList<>();
        doctorsForApoointment.add("Cardiologist");
        doctorsForApoointment.add("Dermatologist");
        doctorsForApoointment.add("Gynaecologist");
        doctorsForApoointment.add("Internist");
        doctorsForApoointment.add("Neurologist");
        doctorsForApoointment.add("Orthopaedist");
        doctorsForApoointment.add("FamilyDoctor");


        JFrame frame1=new appointmentChoice("Appointment choice", doctorsForApoointment, medicalFacility );
        frame1.setVisible(true);



        //pobranie dat dla wszytskich lekarzy i ich wyświtlenie
        try {
            Doctor.showDatesForAllDoctors(medicalFacility);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //sprawdzam czy działa pobeiranie danego lekarza o danej specjalizacji

        try {
            List<Doctor> doctors= Doctor.getDoctors(MedicalSpecialist.FamilyDoctor, medicalFacility);
            int i=1;
            System.out.println("Family doctors in medical facility");
            for (Doctor d:doctors) {
                System.out.println(i +".  "+ d);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //sprawdzenie metoda zwracania wartości enum na podstawie strinha
        try {
            System.out.println(Doctor.getMedicalSpecialistFor("FamilyDoctor").toString());
            System.out.println(Doctor.getMedicalSpecialistFor("Internist").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
