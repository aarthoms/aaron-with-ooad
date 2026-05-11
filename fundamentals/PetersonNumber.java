import java.util.Scanner; 
public class PetersonNumber {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter number: "); 
        String number = sc.next(); 
        checkPeterson(number); 
    }
    static void checkPeterson(String number){
        int result = 0; 
        int i = 0; 
        for(i =0; i<number.length(); i++){
            char num = number.charAt(i); 
            int numb = Character.getNumericValue(num); 
            result += factorial(numb); 
        }
        if(result == Integer.parseInt(number)) System.out.println("Number is Peterson"); 
        else System.out.println("Number is not Peterson"); 
    }
    static int factorial(int n){
        if(n <=1) return 1; 
        return n * factorial(n-1); 
    }
}
