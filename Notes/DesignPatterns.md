# Design Patterns 

1. Creational Patterns 
    a. Singleton 
        i. Only One intstance ever
        ii. Guarantees exactly one instance of a class ever exists across the entire application. Global access point, lazy-initialized, thread safe. 
    b. Factory 
        i. Let a method decide what to create
        ii. Defines an Interface for creating objects, but lets subclasses or a factory method decide which concrete class to instantiate. The caller never uses a new directly. 
    c. Abstract Factory
        i. A Factory of Factories
        ii. Where Factory creates a single product -- the Abstract factory creates a whole family of related products that must be used together. 
        iii. You swap te whole family by swapping the factory.  
    d. Prototype
        i. Clone instead of rebuild
        ii. When object creation is expensive, create one base instance + clone it for variations. Clone is cheap. Original constrcution was the expensive part. 
    e. Builder 
        i. Construct complex objects step-by-step
        ii. Used when object has many optional fields and telescoping constructors becomes unreadable
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
        a. Define a grammar, evaluate expressions from it. 
        b. Interpreter defines a language and builds an AST from the language. 
