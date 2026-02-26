/*
Create an Employee class with name, baseSalary, and displayInfo(). Create a Manager subclass with bonus that overrides displayInfo() using super to retain Employee's output. Accept all three values as command-line arguments. Try overriding the final method and observe the compile error.
*/

class Employee { 
    protected String name; 
    protected double baseSalary; 
    // Parent Constructor
    public Employee(String name, double baseSalary){ 
        this.name = name; 
        this.baseSalary = baseSalary; 
    }
    public void displayInfo(){ 
        System.out.println("Employee: "+ name); 
        System.out.println("Base Salary: $"+baseSalary); 
    }
    public final void Cannot_override(){}
}

class Manager extends Employee{
    private double bonus; 
    public Manager(String name, double baseSalary, double bonus){ 
        super(name, baseSalary); 
        this.bonus = bonus; 
    }
    
    @Override 
    public void displayInfo(){
        super.displayInfo(); 
        System.out.println("Role: Manager"); 
        System.out.println("Bonus: $"+bonus); 
    }
    // // Trying to override a method declared as Final
    // @Override 
    // public void Cannot_override(){}
}


class ManagerExample{
    public static void main(String[] args){
        String mngr = args[0]; 
        double baseSal = Double.parseDouble(args[1]); 
        double bonus = Double.parseDouble(args[2]); 
        Manager mgr = new Manager(mngr, baseSal, bonus); 
        // Demonstrates runtime Polymorphism
        mgr.displayInfo(); 
    }
}