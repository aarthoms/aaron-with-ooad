class VehicleInterface{
    public static void main(String args[]){
        Vehicle theCar = new Car(); 
        theCar.start(); 
        theCar.stop(); 
        theCar.honk(); 
    }
}

interface Vehicle{
    void start(); 
    void stop(); 
    default void honk(){
        // Optional to override. 
        System.out.println("Beep Beep"); 
    }
}
class Car implements Vehicle{
    @Override public void start() {System.out.println("Car Started");}
    @Override public void stop() {System.out.println("Car Stopped");}
    // Honk() Inherited from Vehicle Interface
}