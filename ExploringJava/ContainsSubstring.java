import java.util.Scanner; 

class ContainsSubstring{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter the base string"); 
        String base = sc.nextLine(); 
        System.out.println("Enter the Target Substring"); 
        String target = sc.nextLine(); 
        String flag = "No"; 
        if(base.contains(target))
            flag = "Yes"; 
        System.out.println("Does it contain? "+ flag); 
        sc.close(); 
    }
}