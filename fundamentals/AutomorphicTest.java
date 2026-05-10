/*
Given a number, it's square should be present in the square of it's square
Eg -- 5 x 5 = 25
      25 x 25 = 625 
*/
import java.util.Scanner; 

public class AutomorphicTest{ 
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter the Number: "); 
        int number = sc.nextInt(); 
        boolean result = isAutomorphic(number); 
        if(result) System.out.println(number + " is Automorphic"); 
        else System.out.println(number + " is Not Automorphic"); 
        
    }
    public static boolean isAutomorphic(int number){
        int square = number*number; 
        int dsq = square * square; 
        String s1 = String.valueOf(square); 
        String s2 = String.valueOf(dsq); 
        return s2.endsWith(s1); 
    }
}