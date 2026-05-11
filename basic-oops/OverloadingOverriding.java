/* Incomplete-- please complete this */
public class OverloadingOverriding {
    
}
class Overloading{
    public int add(int a, int b){
        return a+b; 
    }
    public int add(int a, int b, int c){
        return a+b+c; 
    }
}
/*
// Example of overriding

import java.io.*;

class Animal {

	void eat()
	{
		System.out.println("eat() method of base class");
		System.out.println("eating.");
	}
}

class Dog extends Animal {

	void eat()
	{
		System.out.println("eat() method of derived class");
		System.out.println("Dog is eating.");
	}
}

class MethodOverridingEx {

	public static void main(String args[])
	{
		Dog d1 = new Dog();
		Animal a1 = new Animal();

		d1.eat();
		a1.eat();

		Animal animal = new Dog();
		// eat() method of animal class is overridden by
		// by eat() method in the child class Dog
		animal.eat();
	}
}


*/