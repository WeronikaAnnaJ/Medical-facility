package MASProjektZaliczeniowy;

enum Tenure{
    FullTime,
    ThreeQuarterTime,
    PartTime
};

//DATA ZATRUDNIENIA?
//DATA KONCA UMOWY
//ABY BYLY ROZNE MOZLIWE UMOWY PO KOLEI

public class EmploymentContract extends TypeOfEmployment{ //klasa dziedziczy po klasie abstrakcyjnej Rodzaj zatrudnienia

    private float salary;
    private  Tenure tenure;
    private static float [] minimalSalary={ 2800.0f, 2100.0f, 1400.0f};

    EmploymentContract(Tenure tenure){
        this.tenure=tenure;
    }

    public void setSalary(float salary)throws Exception {
        if(salary < minimalSalary[tenure.ordinal()]){
            throw new Exception("This salary " +  salary + " is too low. Set salary above " + minimalSalary[tenure.ordinal()] + " . ");
        }
        this.salary = salary;
    }

    @Override
    public float getIncome() {
        return salary;
    }

    @Override
    public String toString() {
        return "EmploymentContract{" +
                "salary=" + salary +
                ", tenure=" + tenure +
                '}';
    }
}
