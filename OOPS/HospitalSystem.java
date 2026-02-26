/*Create an Abstract class -- HealthProfessional with concrete checkIn() and abstract perform Duty(). Create Doctor and Surgeon subclasses. In main(), store both a Health Professional Array and loop through calling both methods. Try instantiating Health Professional and try noting the Error. */

class HospitalSystem{
    public static void main(String args[]){
        HealthProfessional doc = new Doctor("Dr. Aaron", "General Medicine"); 
        HealthProfessional surg = new Surgeon("Dr. Foon", "Cardiography"); 
        doc.checkIn(); 
        doc.performDuty(); 
        surg.checkIn(); 
        surg.performDuty(); 
    }
}
abstract class HealthProfessional{
    protected String name; 
    protected String specialization; 

    public HealthProfessional(String name, String specialization){ 
        this.name = name; 
        this.specialization= specialization; 
    }
    // Abstract Method: Every professional performs a duty, but the details differ 
    public abstract void performDuty(); 
    // Concrete Method: Everyone follows a standard check-in Process 
    public void checkIn(){
        System.out.println("Professional "+this.name+" Has checked in"); 
    }
}

class Doctor extends HealthProfessional{
    public Doctor(String name, String specialization){ 
        super(name, specialization); 
    }
    @Override 
    public void performDuty(){
        System.out.println(name + " is conducting general ward rounds and checking vitals.");
    }
}

class Surgeon extends HealthProfessional{
    public Surgeon (String name, String specialization){ 
        super(name, specialization); 
    }
    @Override
    public void performDuty(){
        System.out.println(name + " is performing a scheduled surgery in the OR.");
    }
}