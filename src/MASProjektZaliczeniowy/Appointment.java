package MASProjektZaliczeniowy;

import java.time.LocalDate;
import java.time.LocalTime;


enum Status{
    WAITING,
    UNDARWAY,
    CANCELED,
    CONDUCTED
};


public class Appointment extends AssociationConstraint {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    //oblicz czas trwania wizyty
    //REFUNDACJA

    private float cost;
    private String recommendations;
    private Status currentStatus;

    Appointment(LocalDate date, LocalTime startTime, float cost) throws Exception {
        super();
        if(date == null || startTime == null){
            throw new Exception("Date and start tima cannot be null.");
        }
        this.date=date;
        this.startTime=startTime;
        this.cost=cost;
        currentStatus=Status.WAITING;

    }

    public void setEndTime(LocalTime endTime){
        this.endTime=endTime;
        currentStatus=Status.CONDUCTED;
    }

    public void setRecommendations(String recommendations){

        this.recommendations=recommendations;
    }

    public void cancelAppointment(){
        currentStatus=Status.CANCELED;
    }
    public void registerStartingApoointment(){
        currentStatus=Status.UNDARWAY;
    }






}
