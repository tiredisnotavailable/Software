package Software.Prog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Calculator {

    public static void Calculate() {

    }

    /**
     * @param num1
     * @param num2
     * @param operation
     * @return Integer
     * @throws Exception
     */
    public static DataType arithmetics(double num1, double num2, char operation) throws Exceptions {

        DataType result = new DataType();
        switch (operation) {
            case '+':
                result.setNumber(num1 + num2);
                break;
            case '*':
                result.setNumber(num1 * num2);
                break;
            case '-':
                result.setNumber(num1 - num2);
                break;
            case '/':
                if (num2 == 0) {
                    throw new Exceptions("Denominator is incorrect");
                }
                result.setNumber(num1 / num2);
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
    public static DataType pow(double num1, double num2) throws Exceptions {
        DataType result = new DataType();
        if ((num1 < 0) & ((num2 % 2 == 0) || (num2 == 0.5))) {
            throw new Exceptions("Root of negative number");
        } else {
            result.setNumber(Math.pow(num1, num2));
            return result;
        }
    }

    /**
     * @param num
     * @param function
     * @return double
     * @throws Exceptions
     */
    public static DataType trigonometry(double num, String function) throws Exceptions {
        DataType result = new DataType();
        switch (function) {
            case "cos":
                result.setNumber(Math.cos(num));
                break;
            case "sin":
                result.setNumber(Math.sin(num));
                break;
            case "tan":
                result.setNumber(Math.tan(num));
                break;
            case "ctan":
                result.setNumber(1 / Math.tan(num));
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
    public static DataType logarithm(double a, double b) {
        return new DataType(Math.log(b) / Math.log(a));
    }

    /**
     * @param a
     * @return double
     */
    public static DataType factorial(double a) {
        boolean flag = true;
        double result = 1;
        if (a < 0 || a == -0) {
            flag = false;
            a = a * (-1);
        }

        for (int i = 2; i <= a; i++) {
            result = result * i;
        }
        if (flag) {
            return new DataType(result);
        } else {
            return new DataType(result * (-1));
        }

    }

    /**
     * @throws Exceptions
     */
    @Test
    public void test() throws Exceptions {
        double x1 = -0.2;
        double x2 = -1.0;
        double y[] = quadraticEquation(5, 6, 1);
        assertEquals(x1, y[0]);
        assertEquals(x2, y[1]);
        assertEquals(25.0, arithmetics(5, 5, '*').getNumber());
        assertEquals(25.0, pow(5, 2).getNumber());
        assertEquals(Math.sin(Math.PI / 2), trigonometry((Math.PI / 2), "sin").getNumber());
        assertEquals(1.0, logarithm(2, 2).getNumber());
        assertEquals(6.0, factorial(3).getNumber());
    }

}