/*Written only for somethings, ignore these*/ 

## JVM (JAVA Virtual Machine)
    - JVM provides a runtime "sandbox" for viewing, interpreting, running, etc.. the Java code. 
    - Unlike Java, which is platform-independent, the JVM is platform-dependend. Design a JVM for a system, and import bytecode of Java from any other system -- It's going to run. 

## Packages
    - A Package in Java is used to group related classes (Just like folders for files in explorer). 
    - Two kinds -- Built in & User defined (Basic brainwork)
    - Use of package: `import package.name.Class` to import a single class & `import package.name.*` for everything.

## OOPS
    - Class is a blueprint for a custom type in OO-language. Class creates objects (active instances). 
    - Object is an encapsulation of Data and methods to manipulate the data. Are created/defined from Classes. 
    - Abstraction | Polymorphism | Encapsulation 
## Scanner - Methods
    - nextInt() | nextFloat() | nextBoolean()| nextLine(); | next() => word as an input | nextByte() nextShort() nextLong()...
    - In `public static void main(String args[])`, args[] contain the arguments. args.length gives how many arguments are present. 

## Language Notes => Mostly same as C
    - Primitive Datatypes: Boolean, byte, short, char, int, long, float, double, String

## Strings
    - String myString = new String("Hello World"); 
    - String myString = "Hello World"; 
    - .charAt() | .codePointAt() | .codePointBefore() | .codePointCount() | .compareTo() | .compareToIgnoreCase() | .concat() | .contains() | .contentEquals() | .copyValueOf() | endsWith() | .equals() | .equalsIgnoreCase() | format() | getBytes() | .getChars() | .hashCode() | .indexOf() | .intern() => canonical representation | .isEmpty() | .join() | .lastIndexOf() | .length() | .matches() | .toLowerCase() | .toUpperCase() | .toCharArray() | toString() | .trim() | .valueOf() | .substring()
    - Strings are immutable; Modification always creates a new object
    - Multiple threads can share the same string object without synchronization 
    - Immutable Strings have a consistent hashcode 

## Garbage Collectors
    - Identify and remove the unused objects from memory and free space 
    - Automatic, unlike C which is a manual process
    - Runs in the background, looks into all objects in memory and finds out objects that are not referenced by any part of the program. 

## Finalization
    - Actions to be performed before the objects are destroyed. 
    - Java provides a finalize() method.
    - ` protected void finalize() {// finalization logic} `
    - Java runs this method whenever it is to recycle an object. 
    - Java does not have explicit destructors. 

## Interface & Implementation
    - **Interface** 
        - Provides the Signature of the methods that are to be used to build a class. 
        - Methods do not have a body. Implementing classes can define the logic. 
        - It functions as a basic contract to build an interface. 

## Passing Parameters in Java
    - Pass by value: (Primitive value)
        - Primitive values -- Stack memory. Hence when we pass a variable of primitive data, a copy of that variable is created and passed as an argument. 
    - Pass by reference (Non-Primitive) => Memory location is passed 
        - Three ways to create
            1. Make the member variable public inside a class 
            2. Return a value from a method and update the same inside the class 
            3. Create a single-element array and pass it as a parameter to the method. 
    - Java supports pass by value only, does not support pass by reference. For non-primitive datatypes, Java sends a copy of reference to the objects created in heap memory. Any modification made to the referenced object inside a method will result in changes in the original object. If the referenced object is replaced by any other object, any modification made further will not impact the original object. 