class InheritanceEx{
    public static void main(String args[]){
        SubClass obj = new SubClass(); 
        obj.methodSubClass(); 
        obj.methodSuper(); 
    }
}

class SuperClass{
    void methodSuper(){System.out.println("Super Method");}
}

class SubClass extends SuperClass{
    void methodSubClass(){System.out.println("Sub Method");}
}
