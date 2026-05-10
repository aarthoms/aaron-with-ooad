import java.util.Scanner; 

public class CheckPalindrome{
    public static void main(String args[]){ 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Input String: "); 
        String input = sc.next(); 
        // String array + two-pointer
        boolean isPallindrome = true; 
        int right, left; 
        left = 0; right = input.length() -1 ; 
        while(left < right){
            if(input.charAt(left) != input.charAt(right)){
                isPallindrome = false; 
                break; 

            }
            left ++ ; 
            right --; 
        }
        if(isPallindrome) System.out.println("Given word is pallindrome"); 
        else System.out.println("Given word is Not Palindrome"); 
    }
}