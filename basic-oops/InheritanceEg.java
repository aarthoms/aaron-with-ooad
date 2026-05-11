/* Case of Single Inheritance */
class SuperClass{
    void superMethod(){
        System.out.println("I am a superclass method"); 
    }
}
class Subclass extends SuperClass{
    void subMethod(){
        System.out.println("I am a subclass method"); 
    }
}

/* Multilevel Inheritance */
class Bird{
    void fly(){ 
        System.out.println("This bird is flying"); 
    }
}
class Budgie extends Bird{
    void whichColor(){
        System.out.println("I am Voilet and Blue!"); 
    }
}
class SingingBudgie extends Budgie{
    void sing(){
        System.out.println("I can Sing!"); 
    }
}

/* Hierarchial inheritence */
class Calopsita extends Bird{
    void whichColor(){
        System.out.println("I am Lutino!"); 
    }
}

public class InheritanceEg {
    public static void main(String args[]){
        // Single Inheritance: 
        Subclass obj = new Subclass(); 
        obj.superMethod(); 
        obj.subMethod(); 

        // Multi Inheritance
        SingingBudgie neeles = new SingingBudgie(); 
        neeles.sing(); 
        neeles.whichColor(); 
        neeles.fly(); 

        // Hierarchial Inheritance
        Calopsita peeles = new Calopsita(); 
        peeles.fly(); 
        peeles.whichColor(); 
    }
}
