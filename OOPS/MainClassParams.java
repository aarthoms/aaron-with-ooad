/*
Create a class MainClassParam with integer attribute x. Write a parameterized Constructor that initializes x. Create two objects with different values and print oth. Then rewrite using 'this.x = x' where the parameter is also named x. 
*/ 

class MainClassParams{
    public static void main(String args[]){
        SampleClass1 samp = new SampleClass1(10); 
        SampleClass1 samp1 = new SampleClass1(25); 
        System.out.println("Object 1 x = "+ samp.x); 
        System.out.println("Object 2 x = "+ samp1.x); 
    }
}

class SampleClass1{
    public int x; 
    public SampleClass1(int val){ 
        x = val; 
    }
}