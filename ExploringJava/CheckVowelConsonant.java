import java.util.Scanner; 
class CheckVowelConsonant{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter the Character"); 
        char ch = sc.next().charAt(0); 
        boolean isVowel=false; 
        switch(ch){
            case 'a': 
            case 'e': 
            case 'i': 
            case 'o': 
            case 'u':
                isVowel = true;
        }
        if(isVowel) System.out.println(ch + " is a Vowel"); 
        else if(ch>='a' && ch <='z') System.out.println(ch + " is a Consonant"); 
        else System.out.println("Invalid Character :("); 
    }
}