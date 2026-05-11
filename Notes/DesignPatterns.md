# Design Patterns 

1. Creational Patterns 
    a. Singleton 
    b. Factory 
    c. Abstract Factory 
    d. Prototype
    e. Builder 
2. Structural Patterns 
    a. Facade 
        i. A Class that exposes only one simple interface, so that the interface callers don't know wtf is happening in the background.
    b. Adapter 
        i. An Adapter class is created when we want to make two unrelated interfaces work together. 
        ii. Two types: Class Adapter (Inheritance) | Object Adapter (Composition)
    c. Proxy    
        i. Sits in front of the real object and intercepts calls for caching, access control, logging, lazy loading or rate limiting. 
    d. Flyweight 
        i. Share what's identical, store what only differs
        ii. Flyweight splits each objects into intrinsic state -- unique per instance and extrinsic --passed in at use-time.
3. Behavioural Patterns
    a. Chain of Responsibilities 
        a. Each handler decides: Do I handle this, or pass it to the next? The sender does not know who ultimately handles it. 
    b. Command 
        b. A Command object encapsulates an action + it's data. This lets you queue, undo, log, replay operation without the invoker knowing what it's doing.
    c. Iterator 
        a. Traverse without exposing structure
        b. Standard way to walk through a collection regardless of how it's stored internally.
    d. Interpreter 
