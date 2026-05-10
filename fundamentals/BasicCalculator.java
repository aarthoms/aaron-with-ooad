import java.util.*; 
public class BasicCalculator{
    public static void main(String args[]){
        // Addition Substraction Division and Multiplication
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter the Operation in Opcode: operator, op1, op2"); 
        String opcode = sc.next(); // opcode: operator, op1, op2
        String[] operation = opcode.split(","); 
        double result=0; 
        // Checking operator
        String opr = operation[0]; 
        int op1 = Integer.parseInt(operation[1]); 
        int op2 = Integer.parseInt(operation[2]); 
        switch(operation[0]){
            case "+": 
                result = op1 + op2; 
                break; 
            case "-": 
                result = op1 - op2; 
                break; 
            case "*": 
                result = op1 * op2; 
                break; 
            case "/": 
                result = op1/op2; 
                break; 
            default: 
                System.out.println("Invalid Operator"); 
        
        }
        System.out.println("Result = "+ result); 
    }
}