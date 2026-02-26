## What happens when you create an Object in Java? 
```Bicycle b1 = new Bicycle(60, 18, 3);``` 
This statement does three things: 
    - b1 is reference variable, stored in the **Stack frame** of main(). It does not store the object, but stores the reference (Somewhat like pointers in C). 
    - `new` allocates memory on the heap by JVM. Space reserved for instance variables, Object header <Metadata-like class info, gc info>. Heap allocation is automatic 
    - Constructor initializes instance variables + runs additional logic
## Inheritance: 
    - Is the process by which **One object acquires the properties of another Object** 
    - Applying Inheritance gives us Re-usability
    - Subclass -- Child Class/ Derived Class
    - Superclass -- Parent class/ Base Class 
    - Extends -- Subclass uses this keyword to inherit the superclass 
    - Types of Inheritance: Single | Multilevel | Hierarchial | Multiple | Hybrid 
    - *Multiple Inheritance is invalid in Java* -- Two different superclasses 
    - *Hybrid Inheritance* -- Also not possible in Java. 
    - Variables and Methods declared private in parent class cannot be inherited by child classes. and Public can be accessed directly by the child class 
    - Protected -- Would be inherited by the child class, but access level is limited to one subclass 
    - Default can be accessed by subclass 
    - **Method Overloading and Overriding**: 
        - When the Method signatures (name and parameters) are the same in superclass and the child class -- **Overriding**
        - When two or more Methods have the same name, but different parameters -- **Overloading**
        - When we delcare any method as final, it cannot be overriden 
        

# Not Done Questions: 
16. **PassByValue (#16)** - Primitive passing
17. **PbyRef1 (#12)** - Object field mutation
18. **PByRef2 (#11)** - Return values simulation
19. **PassByValueJObj (#15)** - Integer objects vs primitives
20. **PassByValueN (#14)** - Array element modification
21. **PassByValueN2 (#13)** - Array reassignment