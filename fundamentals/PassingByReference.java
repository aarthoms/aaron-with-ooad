public class PassingByReference {
    int a = 10;
    void call(PassingByReference eg){
        eg.a = eg.a+10; 
    }
    public static void main(String args[]){
        PassingByReference  eg = new PassingByReference ();
        System.out.println("Before call-by-reference: "+ eg.a); 

        // Passing the object as a value using pass-by-refercne 
        eg.call(eg); 
        System.out.println("After call-by-reference: "+ eg.a); 
        // Three ways of Passing by refernce: 
        // 1: Global variable + modify it out. 
        // 2: Reassign the same variable as return 
        // 3: Single membered Array
    }
}
