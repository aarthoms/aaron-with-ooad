/*
Basic understanding of creation of Classes and their constructors. 
*/

public class Bicycle{
    // Three fields -- attributes
    public int cadence; 
    public int gear; 
    public int speed; 
    // Constructor that takes parameters
    public Bicycle(int startCadence, int startSpeed, int startGear){
        this.cadence = startCadence; 
        this.gear = startGear; 
        this.speed = startSpeed; 
    }
    // Methods -- the functionality of the class: 
    public void setGear(int newValue){
        gear = newValue; 
    }
    public void setSpeed(int newValue){
        speed = newValue; 
    }
    public void setCadence(int newValue){
        cadence = newValue; 
    }
    public void applyBreak(int decrement){speed -= decrement; }
    public void speedUp(int increment){speed += increment; }
}

// Making a copy 

/* 
    A Copy Constructor is used to make a copy of the object. 
    You can also make copies using the clone() method. 

    Copy --> Deep Copy 
    Clone --> Shallow Copy. 
*/

class BikeCopy{ 
    String modelName; // Instance Variable 
    // Parameterized constructor
    BikeCopy(String model){
        modelName = model; 
    }
    // Copy Constructor
    BikeCopy(BikeCopy otherbike){
        modelName = otherbike.modelName; 
    }
    
    public static void main1(String args[]){
        // Imagine this is the main function -- 
        BikeCopy myBike = new BikeCopy("Mountain Bike"); 
        System.out.println("Bike Object Created! Model: "+ myBike.modelName); 

        // Create a copy of the boke 
        BikeCopy copiedBike = new BikeCopy(myBike); 
        System.out.println("Bike Object Created! Model: "+ copiedBike.modelName);
    }
}

/*
    Using the Return keyword in Constructors:
        To exit the constructor early, not to return a value 
*/
class BikeReturn{
    Bicycle bike; 
    public BikeReturn (int speed, int cadence, int gear){
        Bicycle bike = new Bicycle(speed, cadence, gear); 
        this.bike = bike; 
        return ; 
        // bike.speed += 10; // This like will not work because of the early return clause. 
    }
}

// The correct way to implement that.

class BikeRight{
    // Constructor with a condition to skip early 
    public BikeRight(boolean skip){
        if (skip){
            System.out.println("Constructor Exited early"); 
            return; 
        }
        System.out.println("Constructor continues..."); 
        System.out.println("Bike object initialized successfully"); 
    }
}