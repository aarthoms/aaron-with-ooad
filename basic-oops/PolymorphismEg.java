class Multiplier{
    static void Multiply(int a, int b){
        System.out.println("Integer Multiplication, Result = "+ a*b);
    }
    static void Multiply(double a , double b){
        System.out.println("Double Multiplication, Result = "+ a*b);
    }
    static void Multiply(double a, double b, double c){
        System.out.println("Three Parameters, double Multiplication, Result = "+ a*b*c);
    }
}

public class PolymorphismEg {
    public static void main(String args[]){
        Multiplier.Multiply(2,5); 
        Multiplier.Multiply(100, 0.4); 
        Multiplier.Multiply(100, 0.5, 0.4); 
    }
}
