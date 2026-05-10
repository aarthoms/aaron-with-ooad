import java.util.Scanner; 
// Calculate the Area of Triangle 
class AreaTriangle{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter the Base of Triangle: "); 
        double base = sc.nextDouble(); 
        System.out.println("Enter the Height of Triangle"); 
        double height = sc.nextDouble(); 
        double area = base*height; 
        System.out.println("Area of Triangle = "+area); 
    }
}