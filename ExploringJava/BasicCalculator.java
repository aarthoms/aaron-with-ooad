import java.util.Scanner;

class Calculator {
    int number1;
    int number2;
    String operator;

    Calculator(int n1, int n2, String op) {
        number1 = n1;
        number2 = n2;
        operator = op;
    }

    int performCalc() {
        int result;

        switch (operator) {
            case "+": result = number1 + number2; break;
            case "-": result = number1 - number2; break;
            case "/": result = number1 / number2; break;
            case "*": result = number1 * number2; break;
            case "^": result = (int) Math.pow(number1, number2); break;
            default:
                System.out.println("Invalid Operator");
                result = 0;
        }

        return result;
    }
}

public class BasicCalculator {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        String op = sc.next();

        Calculator calc = new Calculator(n1, n2, op);
        System.out.println(calc.performCalc());

        sc.close();
    }
}