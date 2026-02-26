/*
    Design a Bicycle class with private cadence, gear, speed fields and a static numberOfBicycles counter. Write a Parameterized constructor that increments the counter and assigns the ID. Add all methods. In main(), create three BicycleObjects and print the count using the static method.
*/

class Bicycle{
    private int cadence, gear, speed; 
    private int id; 
    private static int numberOfBicycles=0; // This variable is shared with all instances 
    public Bicycle(int c, int s, int g){
        cadence = c; 
        speed = s; 
        gear = g; 
        id = ++numberOfBicycles; 
    }
    public void setCadence(int v){cadence=v;}
    public void applyBreak(int d){speed-=d;}
    public void speedUp(int i){speed+=i;}
    public static int getNumberOfBicycles(){return numberOfBicycles;}
    public void print(){
        System.out.println("Speed : "+ speed); 
        System.out.println("Cadance : "+ cadence); 
        System.out.println("Gear : "+ gear ); 
    }
}


class MakeBicycles{
    public static void main(String args[]){
        Bicycle bike1 = new Bicycle(60, 18, 3); 
        System.out.println("Total Number of Bicycles are: "+ bike1.getNumberOfBicycles()); 
        Bicycle bike2 = new Bicycle(75, 10, 1); 
        Bicycle bike3 = new Bicycle(95, 35, 6); 
        System.out.println("Total Number of Bicycles are: "+ bike3.getNumberOfBicycles()); 
        bike2.speedUp(3); 
        bike3.print(); 
    }
}