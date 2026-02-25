import java.util.Scanner; 
class UseScanner{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter Username: "); 
        String userName = sc.nextLine(); 
        System.out.print("Hello "+userName); 
    }
}