public class PassingByValue {
    public static void main(String args[]){
        // passing values: 
        int a, b; 
        a = 2; b = 3; 
        add1(a, b); 
        System.out.println("[Method1] The value of result from main: "+ (a+b)); 

        // passing by an array
        Integer[] array = new Integer[2]; 
        array[0] = 2 ; 
        array[1] = 3 ; 
        add2(array); 
        System.out.println("[Method2] The value of result from main: "+ (array[0] + array[1]));

        // passing by an Object
        Integer a1 = new Integer(2); 
        Integer b1 = new Integer(3); 
        add3(a1,b1); 
        System.out.println("[Method3] The value of result from main: "+ (a+b));
    }
    
    private static void add1(int a, int b){
        a = 10; 
        System.out.println("The value of result from method 1 : "+ (a+b)); 
    }
    private static void add2(Integer[] array){
        array[0] = 10; 
        System.out.println("The value of result from method 2 : "+ (array[0] + array[1])); 
    }
    private static void add3(Integer a1, Integer a2){
        a1 = new Integer(10); 
        System.out.println("The value of result from method 2 : "+ (a1+a2)); 
    }
}
