/*Constructor Chaining*/
class Parent{
    int var = 100; 
    Parent(){System.out.println("Parent Constructor Executed"); }
    public void test() {System.out.println("Parent Test Method");}
}
class Child extends Parent{
    int var = 50; 
    Child(){
        super(); 
        System.out.println("Child Constructor Executes"); 
    }
    public void displayVariables(){
        // Variable Shadowing
        System.out.println("Child's var => " + var); 
        System.out.println("Parent's var => " + super.var); 
    } 
    public void test(){
        System.out.println("Child Test Method");
    }
    public void displayMethods(){
        this.test(); 
        super.test(); 
    }
}

class SuperInheritance{
    public static void main(String args[]){ 
        Parent parentObj = new Parent(); 
        Child childObj = new Child(); 
        System.out.println("Child Var: " + childObj.var); 
        System.out.println("Parent Var: " + parentObj.var); 
        parentObj.test(); 
        childObj.test(); 
        childObj.displayVariables(); 
    }
}