package Software.Prog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Calculator {

    /**
     * @param num1
     * @param num2
     * @param operation
     * @return Integer
     * @throws Exception
     */
    public static double calculate(double num1, double num2, char operation) throws Exceptions {

        double result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new Exceptions("Denominator is incorrect");
                }
                result = num1 / num2;
                break;
            default:
                throw new Exceptions("Wrong operation");
        }
        return result;
    }

    /**
     * @param num1
     * @param num2
     * @return double
     * @throws Exceptions
     */
    public static double pow(double num1, double num2) throws Exceptions {
        if ((num1 < 0) & ((num2 % 2 == 0) || (num2 == 0.5))) {
            throw new Exceptions("Root of negative number");
        } else {
            double result = Math.pow(num1, num2);
            return result;
        }
    }

    /**
     * @param num
     * @param function
     * @return double
     * @throws Exceptions
     */
    public static double trigonometry(double num, String function) throws Exceptions {
        double result = 0;
        switch (function) {
            case "cos":
                result = Math.cos(num);
                break;
            case "sin":
                result = Math.sin(num);
                break;
            case "tan":
                result = Math.tan(num);
                break;
            case "ctan":
                result = 1 / Math.tan(num);
                break;
            default:
                throw new Exceptions("Wrong function");

        }
        return result;
    }

    /**
     * @param a
     * @param b
     * @param c
     * @return double[]
     * @throws Exceptions
     */
    public static double[] quadraticEquation(double a, double b, double c) throws Exceptions {
        double result[] = new double[2];
        double d = b * b - 4 * a * c;
        if (d < 0) {
            throw new Exceptions("Discriminant < 0");
        }
        result[0] = (-b + Math.sqrt(d)) / (2 * a);
        result[1] = (-b - Math.sqrt(d)) / (2 * a);
        return result;
    }

    /**
     * @param a
     * @param b
     * @return double
     */
    public static double logarithm(double a, double b) {
        double result = Math.log(b) / Math.log(a);
        return result;
    }

    /**
     * @throws Exceptions
     */
    @Test
    public void test() throws Exceptions {
        double x1 = -0.2;
        double x2 = -1.0;
        double y[] = quadraticEquation(5.0, 6.0, 1.0);
        assertEquals(x1, y[0]);
        assertEquals(x2, y[1]);
        assertEquals(25.0, calculate(5.0, 5.0, '*'));
        assertEquals(25.0, pow(5.0, 2.0));
        assertEquals(Math.sin(Math.PI / 2), trigonometry((Math.PI / 2), "sin"));
        assertEquals(1, logarithm(2, 2));

    }

}