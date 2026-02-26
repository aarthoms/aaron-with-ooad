class MegaBikeConcept{

    public static void main(String[] args) {

        System.out.println("---- 1) Early Return Constructor ----");
        BikeRight b1 = new BikeRight(true);
        b1.printState();

        BikeRight b2 = new BikeRight(false);
        b2.printState();

        System.out.println("\n---- 2) Proper Constructor (No Unreachable Code) ----");
        BikeReturn br = new BikeReturn("Yamaha", 120);
        br.printDetails();

        System.out.println("\n---- 3) Copy Constructor ----");
        BikeCopy original = new BikeCopy("Mountain Bike", 25);
        BikeCopy copy = new BikeCopy(original);

        System.out.println("Before modification:");
        original.print();
        copy.print();

        original.speed = 40;

        System.out.println("After modifying original:");
        original.print();
        copy.print();
    }
}

class BikeRight {

    String modelName;
    int speed;

    BikeRight(boolean skip) {

        if (skip) {
            System.out.println("Constructor exited early.");
            return;
        }

        modelName = "Default Bike";
        speed = 60;

        System.out.println("Constructor completed initialization.");
    }

    void printState() {
        System.out.println("Model: " + modelName);
        System.out.println("Speed: " + speed);
    }
}

class BikeReturn {

    String modelName;
    int speed;

    BikeReturn(String model, int sp) {

        modelName = model;

        // return;   // If you uncomment this line,
                     // speed = sp; becomes UNREACHABLE → compile-time error

        speed = sp;
    }

    void printDetails() {
        System.out.println("Model: " + modelName);
        System.out.println("Speed: " + speed);
    }
}

class BikeCopy {

    String modelName;
    int speed;

    BikeCopy(String model, int sp) {
        modelName = model;
        speed = sp;
    }

    BikeCopy(BikeCopy other) {
        modelName = other.modelName;
        speed = other.speed;
    }

    void print() {
        System.out.println("Model: " + modelName + ", Speed: " + speed);
    }
}