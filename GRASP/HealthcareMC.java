/*
GRASP MATCHING
Controller -- HospitalSystem
Indirection  -- AppointmentManager 
Information Expert -- Patient, Doctor 
High Cohesion -- Appointment 
Low Coupling -- Billing 
Polymorphism -- Notification 
Pure fabrication -- ReportGenerator. 
Protectecd variation -- InsuranceProcessor | Notification 
*/


// Patient: Information Expert
// Stores demographic and insurance data about a hospital patient
class Patient{ 
    private String name; 
    private String dob; 
    private String insuranceinfo; 
    
    public Patient(String name, String dob, String insuranceInfo){
        this.name = name; 
        this.dob = dob; 
        this.insuranceinfo = insuranceInfo; 
    }
    public String getName() {return this.name;}
    public String getDOB() {return this.dob; }
    public String getInsuranceInfo() {return this.insuranceinfo; }
    // Calculates Patient's age from birth-year
    // GRASP -- Patient owns the dob so, age-calculation lives here, not in a manager or utility class 
    public int getAge(){
        int birthYear = Integer.parseInt(dob.substring(0, 4)); 
        return 2026-birthYear; 
    }
}

// Doctor: Represents physician with a name, specialization and basic availability check. 
// Information Expert

class Doctor{ 
    private String name; 
    private String specialization; 
    public Doctor(String name, String specialization){
        this.name = name; 
        this.specialization = specialization; 
    }
    public String getName(){return this.name; }
    public boolean isAvailable(String time){
        // Stubbed to always return true... 
        // If real logic -- query a calendar service
        return true; 
    }
}

// Appointment: High Cohesion | Represents a single appointment between patient and doctor
class Appointment{
    public enum Status{ SCHEDULED, RESCHEDULED, CANCELLED }
    private Status status; 
    
    public void schedule(){
        this.status = Status.SCHEDULED; 
        System.out.println("[Appointment] Status -> Scheduled"); 
    }
    public void reschedule(){
        this.status = Status.RESCHEDULED; 
        System.out.println("[Appointment] Status -> rescheduled"); 
    }
    public void cancell(){
        this.status = Status.CANCELLED;
        System.out.println("[Appointment] Status -> cancelled");  
    }
    public Status getStatus(){return status; }
}

// Appointment Manager: 
// Coordinates the workflow, checks doctor availability, creates appointment object and schedules it. 
// Grasp: Creator and Pure Fabrication 

class AppointmentManager{
    public Appointment scheduleAppointment(Patient patient, Doctor doctor, String time){
        if(!doctor.isAvailable(time)){
            System.out.println("[AppointmentManager] Dr. "+ doctor.getName() + " is not available at "+ time); 
            return null; 
        }
        // Creator AppointmentManager creates appointment it will manage: 
        Appointment appointment = new Appointment(); 
        appointment.schedule(); 
        System.out.println("[AppointmentManager] Confirmed: "+ patient.getName() +" --> Dr. "+ doctor.getName() + " @ "+ time);
        return appointment; 
    }
}

// Billing: Handles financial Operation
// GRASP: High Cohesion

class Billing{ 
    public void calculateCharges(Patient patient, String treatment){
        System.out.println("[Billing] Charges calculated for the pateint "+ patient.getName() + " for treatment -- "+ treatment); 
    }
    public void processPayment(){
        System.out.println("[Billing] Payment Processed Successfully"); 
    }
}

// Insurance Processor: Processes Insurance functionality 
// GRASP: High cohesion

class Insurance{
    public void verifyCoverage(Patient patient){
        System.out.println("[InsuranceProcessor] Claim Submitted for "+ patient.getName()); 
    }
    public void processClaim(Patient patient){ 
        System.out.println("[InsuranceProcessor] Claim submitted for "+ patient.getName()); 
    }
}
// Notifications:
interface Notification{ 
    void sendAlert(String message); 
}
class EmailNotification implements Notification { 
    @Override 
    public void sendAlert(String message){
        System.out.println("[Email Notification] "+ message); 
    }
}
class SMSNotification implements Notification { 
    @Override 
    public void sendAlert(String message){
        System.out.println("[SMS Notification] "+ message); 
    }
}

class PushNotification implements Notification { 
    @Override 
    public void sendAlert(String message){
        System.out.println("[Push Notification] "+ message); 
    }
}

// Report Generator: Generates patient-facing/internal reports
// Grasp Pure Fabrication
class ReportGenerator{
    public void generate(Patient patient){ 
        System.out.println("[Report Generator] Report generated for "+patient.getName()+ " (age: "+ patient.getAge()+ ")"); 
    }
}

// Controller - facade 
// GRASP: Controller, Low Coupling, 
class HospitalSystem{ 
    private final Notification notifier; 
    public HospitalSystem(Notification notifier){ 
        this.notifier = notifier ; 
    }
    public void login(String username, String password){ 
        System.out.println("[HospitalSystem] User logged in: "+ username); 
        notifier.sendAlert("Login detected for user: "+ username); 
    }
    public void bookAppointment(Patient patient, Doctor doctor, String time){ 
        // Delegate - Hospital System does not schedule, Appointment manager does
        AppointmentManager manager = new AppointmentManager(); 
        Appointment appt = manager.scheduleAppointment(patient, doctor, time); 
        if(appt != null){
            notifier.sendAlert("Appointment confirmed for "+ patient.getName() + "With Dr. "+ doctor.getName() + " at " + time); 
        }
    }
    public void generateBill(Patient patient, String treatment){
        Insurance insurance = new Insurance(); 
        insurance.verifyCoverage(patient); 
        insurance.processClaim(patient); 

        Billing billing = new Billing(); 
        billing.calculateCharges(patient, treatment); 
        billing.processPayment(); 

        notifier.sendAlert("Invoice generated for "+ patient.getName() + "\n Treatment: "+ treatment); 
    }
    
    public void generatePatientReport(Patient patient){
        ReportGenerator generator = new ReportGenerator(); 
        generator.generate(patient); 
        notifier.sendAlert("Your Report is Ready, " + patient.getName()); 
    }
}


public class HealthcareMC {
    public static void main(String args[]){
        // Build Domain Objects
        Patient cheenku = new Patient("Cheenkappa", "2004-04-05", "POL-8821"); 
        Doctor drAaron = new Doctor("Dr. Aaron Thomas", "Aviation vet"); 

        // Protected verification: 
        Notification channel = new EmailNotification(); 
        
        // Controller: 
        HospitalSystem hospital = new HospitalSystem(channel); 

        // Workflow
        System.out.println("==LOGIN=="); 
        hospital.login("aaronthomas", "s3cr3t"); 
        System.out.println("\n ==Book Appointment=="); 
        hospital.bookAppointment(cheenku, drAaron, "2026-06-10 9:00"); 
        System.out.println("\n==Generate Bill=="); 
        hospital.generateBill(cheenku, "Consultation"); 
        System.out.println("\n==Patient Report =="); 
        hospital.generatePatientReport(cheenku); 
    }
}
