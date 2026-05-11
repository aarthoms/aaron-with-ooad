/*
Fundamentals Assignment: 
Write a full-fledged Java program to check whether a given set of
strings (passed as arguments to main) are valid passwords:
1. Password should be between 8 and 16 characters in size
2. Should be a combination of upper case and lower case
characters.
3. Should not contain spaces.
4. Should contain at least 1 digit.
5. Should contain at most one special character (from the set “@,
#, $, !).
The program should consist of 2 separate classes one containing
main and the other containing the required functionality.
The classes should contain relevant constructors and also make
use of the finalize method.
*/
import java.util.Scanner; 

class Password{ 
    String pwd;
    boolean strength; 

    public Password(String pwd){
        this.pwd = pwd; 
        this.strength = determineStrength(pwd); 
        if(strength)
            System.out.println("Strong Password"); 
        else System.out.println("Weak Password"); 
    }

    private boolean determineStrength(String pwd){
        if(pwd.length() >= 8 && pwd.length() <= 16){
            if(pwd.contains(" ")){
                System.out.println("Password contains Spaces");
                return false; 
            }
            else{
                boolean hasUpper = false; 
                boolean hasLower = false; 
                boolean hasDigit = false; 
                int specialCount = 0;  
                int i = 0;
                for(i = 0; i< pwd.length(); i++){
                    char ch = pwd.charAt(i); 
                    if(Character.isUpperCase(ch))hasUpper = true; 
                    else if(Character.isLowerCase(ch)) hasLower = true; 
                    else if(Character.isDigit(ch)) hasDigit = true; 
                    else if(ch == '@' || ch == '#' || ch == '$' || ch == '!') specialCount++; 
                    else{System.out.println("Need a LowerCase, UpperCase and a Special Character"); return false; }
                }
                if(hasUpper&&hasLower&& hasDigit&& specialCount <=1) return true ; 
                else return false ;
            }
        }
        else {System.out.println("Password Length should be between 8 - 16 Characters"); return false; }
    }
}

public class PasswordCheck{
    public static void main(String args[]){ 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter a Password"); 
        String pwd = sc.next(); 
        Password password = new Password(pwd); 
        System.gc(); 
    }
}
