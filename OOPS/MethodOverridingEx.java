class Animal{
    void eat(){
        System.out.println("eat() method out of base class"); 
        System.out.println("Eating..."); 
    }
}
class Dog extends Animal{
    void eat(){
        System.out.println("eat() method out of derived class"); 
        System.out.println("Dog is Eating..."); 
    }
}
class MethodOverridingEx{
    public static void main(String args[]){
        Dog d1 = new Dog(); 
        Animal a1 = new Animal(); 
        d1.eat(); 
        a1.eat(); 

        Animal animal = new Dog(); 
        animal.eat(); 
    }
}