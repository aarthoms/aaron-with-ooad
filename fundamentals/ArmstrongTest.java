/* 
    Check whether a given number is Amstrong number or not
    Eg -- Sum of cubes of digits == number 
*/
import java.util.Scanner; 
class ArmstrongTest{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter the Number to check"); 
        int number = sc.nextInt(); 
        boolean result = isArmstrong(number); 
        if(result) System.out.println(number + " is an Armstrong Number"); 
        else System.out.println(number + " is not an Armstrong Number"); 
    }
    public static boolean isArmstrong(int number){
        int result = 0; 
        int orig = number; 
        while(number != 0){
            int remainder = number%10; 
            int cube = remainder * remainder * remainder; 
            result += cube; 
            number = number/10; 
        }
        if(orig == result) return true; 
        return false; 
    }
}