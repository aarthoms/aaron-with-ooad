class MasterPassbyValue{
    static class Box{
        int value; 
        Box(int value){
            this.value = value; 
        }
    }
    public static void modify(int primitive, Box object, int[] array, Integer wrapper){
        System.out.println("\n--InsideMethod---"); 
        // primitive modification 
        primitive = 100; 
        // object field modification 
        object.value = 200; 
        // array element modification 
        array[0] = 300; 
        // array re-assignment 
        array = new int[]{400, 500}; 
        // wrapper re-assignment -- Immutable 
        wrapper = 600; 

        System.out.println("Primitive: "+ primitive); 
        System.out.println("Object Value: "+ object.value); 
        System.out.println("Array[0]: " + array[0]); 
        System.out.println("Wrapper: "+ wrapper); 
    }
    public static void main(String args[]){
        int primitive = 10;
        Box object = new Box(20);
        int[] array = {30, 40};
        Integer wrapper = 50;

        System.out.println("--- Before Method ---");
        System.out.println("Primitive: " + primitive);
        System.out.println("Object value: " + object.value);
        System.out.println("Array[0]: " + array[0]);
        System.out.println("Wrapper: " + wrapper); 

        modify(primitive, object, array, wrapper);

        System.out.println("\n--- After Method ---");
        System.out.println("Primitive: " + primitive); // Does not change
        System.out.println("Object value: " + object.value); // Changes, to 200
        System.out.println("Array[0]: " + array[0]); // Changes, to 300 
        System.out.println("Wrapper: " + wrapper); // Remains same outside of method
    }
}
