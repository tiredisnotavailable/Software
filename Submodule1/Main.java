package Software.Submodule1;


import java.util.Scanner;

public class Main
{

    /** 
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = getInt(in);
        int num2 = getInt(in);
        char operation = getOperation();
        result(num1, num2, operation);
        in.close();
    }


    /** 
     * @param in
     * @return int
     */
    public static int getInt(Scanner in) {
        System.out.println("Enter a number");
        int num = in.nextInt();
        return num;
    }


    /** 
     * @return char
     */
    public static char getOperation() {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter an operation");
        char operation = in.next().charAt(0);
        in.close();
        return operation;
    }


    /** 
     * @param num1
     * @param num2
     * @param operation
     */
    public static void result(int num1, int num2, char operation) {
        int result;
        try {
            result = Calculate.calculate(num1, num2, operation);
            printResult(num1, num2, result, operation);
        } catch (denomException e) {
            System.err.println(e.getMessage());
        }
    }


    /** 
     * @param num1
     * @param num2
     * @param result
     * @param operation
     */
    public static void printResult(int num1, int num2, int result, char operation)
    {   
        System.out.println(num1 + " " + operation + " " + num2 + " =" + " " + result);
    }

}
