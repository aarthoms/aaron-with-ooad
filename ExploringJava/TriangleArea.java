import java.util.Scanner; 

class TriangleArea{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); 
        int side1 = sc.nextInt(); 
        int side2 = sc.nextInt(); 
        int side3 = sc.nextInt(); 
        int area = side1*side2*side3; 
        System.out.println("Area is "+ area );
    }
}