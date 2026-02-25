import java.util.Scanner; 
class SwitchString{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter the type of Animal: "); 
        String animal = sc.nextLine(); 
        String result; 

        switch(animal){
            case "DOG" : result = "domestic animal"; break; 
            case "BIRD" : result = "domestic animal"; break; 
            case "TIGER": result = "WILD animal"; break; 
            default: result = "Unknown animal"; break; 
        }
        System.out.println(animal + " is a type of "+ result); 
    }
}