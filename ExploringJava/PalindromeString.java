import java.util.Scanner; 
class PalindromeString{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); 
        String word = sc.nextLine(); 
        boolean flag = checkpalindrome(word); 
        System.out.println(flag); 
        sc.close(); 
    }
    public static boolean checkpalindrome(String word){
        boolean flag = true; 
        int len = word.length(); 
        int i ; 
        for(i = 0; i<len/2; i++){
            if(word.charAt(i) != word.charAt(len-i-1))
                flag = false; break; 
        }
        return flag; 
    }
}