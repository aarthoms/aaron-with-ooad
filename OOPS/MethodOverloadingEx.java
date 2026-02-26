class MethodOverloadingEx{
    // Overloading=> Same class, same Method name, different parameters
    public static void main(String[] args){ 
        // Compiler picks the best one based on parameters
        System.out.println("Add() with 2 parameters"); 
        add(4, 6); 
        System.out.println("Add() with 3 parameters"); 
        add(4, 6, 7); 
    }
    static void add(int n1, int n2){
        System.out.println("Sum => "+ (n1 + n2)); 
    }
    static void add(int n1, int n2, int n3){
        System.out.println("Sum => "+ (n1+n2+n3));
    }
}