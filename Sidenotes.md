## What happens when you create an Object in Java? 
```Bicycle b1 = new Bicycle(60, 18, 3);``` 
This statement does three things: 
    - b1 is reference variable, stored in the **Stack frame** of main(). It does not store the object, but stores the reference (Somewhat like pointers in C). 
    - `new` allocates memory on the heap by JVM. Space reserved for instance variables, Object header <Metadata-like class info, gc info>. Heap allocation is automatic 
    - Constructor initializes instance variables + runs additional logic
