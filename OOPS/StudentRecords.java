/*
Design a StudentRecords class with three instance variables: name (public), division (default), and age (private). Use a constructor to initialize name and setters for the rest. Create an object in main(), set all values, and print them. Explain why age cannot be accessed directly from outside the class.
*/
class StudentRecords{
    public static void main(String args[]){ 
        Student stud1 = new Student("Cheenku"); 
        stud1.setAge(6); 
        stud1.setDiv('c'); 
        stud1.printDetails(); 
    }
}
class Student{
    public String name;  // Public Access 
    char division;  // Default Access 
    private int age; // Private Access
    public Student(String sname){ 
        name = sname; 
    }
    public void setAge(int vays){ age = vays;}
    public void setDiv(char div){ division = div;}
    public void printDetails(){
        System.out.println("Name: " + name); 
        System.out.println("Age: " + age); 
        System.out.println("Division: "+ division); 
    }

}