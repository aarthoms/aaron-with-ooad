class AmstrongNum {
    public static void main(String args[]) {

        String num = "153";
        int result = 0;

        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            result += (int) Math.pow(n, 3);
        }

        System.out.println("Sum of cubes: " + result);

        if (result == Integer.parseInt(num)) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }
    }
}