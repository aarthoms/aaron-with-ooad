class AcademicSystem{
    public static void main(String args[]){
        // Create a Regular Student
        Student s1 = new Student("Aaron", "AM005", "AIML"); 
        s1.recordAttendance(); 
        s1.performMainDuty(); 
        // Record a Professor: 
        Professor p1 = new Professor("Dr. Cheenku", "AM100", "AIML"); 
        p1.recordAttendance(); 
        p1.performMainDuty(); 
        p1.attendConference(); 
        // Polymorphism via Interface 
        // Ohk Here we are just creating a new reference, for our understanding
        Researcher researcherRole=p1; 
        researcherRole.publishPaper("Cloaca of Budgies -- a modern perspective"); 
        researcherRole.attendConference(); 
    }
}

// Interface defining a specialized academic role 
interface Researcher{
    void publishPaper(String title); 
    void attendConference(); 
}

// Abstract Superclass defining common academic identity
abstract class UniversityMember{
    protected String name; 
    protected String memberId; 
    public UniversityMember(String name, String memberId){
        this.name = name; 
        this.memberId = memberId; 
    }
    // Concrete method: Everyone must check in
    public void recordAttendance(){
        System.out.println(name + " (ID: " + memberId + ") checked in at the university portal.");
    }
    // Abstract method: Different members have different daily tasks
    public abstract void performMainDuty(); 
}

// Concrete Sub-Class: Student
class Student extends UniversityMember{
    private String major; 
    public Student(String name, String srn, String major){
        super(name, srn); 
        this.major = major; 
    }
    @Override 
    public void performMainDuty(){
        System.out.println(name + " is attending lectures for " + major + ".");
    }
}

// Concrete Sub Class: Professor. Inherits from University member and implements researcher 
class Professor extends UniversityMember implements Researcher{
    private String department; 
    public Professor(String name, String srn, String department){
        super(name, srn); 
        this.department = department; 
    }
    @Override
    public void performMainDuty(){
        System.out.println(name + " is delivering a lecture in the " + department + " department.");
    }
    @Override 
    public void publishPaper(String title){
         System.out.println(name + " is delivering a lecture in the " + department + " department.");
    }
    @Override 
    public void attendConference(){
        System.out.println(name + " is presenting research at the International Academic Summit.");
    }
}