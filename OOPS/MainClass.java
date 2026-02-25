/*
    Create a class with attribute x=5 set in a no-arg construct. Ovveridde finalize to print a message when garbage collected. In main() --> Create, print x, set it to null and system.gc(). Explain why finalize is deprecated in Java
*/

class MainClass{
    public static void main(String args[]){
        SampleClass samp = new SampleClass(); 
        System.out.println("X is " + samp.x); 
        // Remove Reference 
        samp = null; 
        System.gc(); // Garbage Collection
    }
}
class SampleClass{
    public int x; 
    public SampleClass(){
        // No Arg Constructor
        x = 5; 
    }
}