package Software.Prog;

import java.util.Scanner;

public class Menu
{
   public Menu(){}

   
   /** 
    * @throws Exceptions
    */
   public static void onStart() throws Exceptions
   {
        
        System.out.println("1. Raise number to a power");
        System.out.println("2. +*-/  (2 numbers)");
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        switch (i) {
            case 1:
                raiseNumber(in);
                break;
            case 2:
                calculate(in);
                break;
            default:
                in.close();
                throw new Exceptions("Wrong number");
        } 
        in.close();


   }

   
   /** 
    * @param in
    * @throws Exceptions
    */
   public static void raiseNumber(Scanner in) throws Exceptions
   {
        
        num1 = setNumber(in);
        num2 = setNumber(in);


        result = Calculator.pow(num1, num2);

        printResult();

   }

   
   /** 
    * @param in
    * @throws Exceptions
    */
   public static void calculate(Scanner in) throws Exceptions
   {
        

        num1 = setNumber(in);
        num2 = setNumber(in);
        setOperation(in);

        result = Calculator.calculate(num1, num2, operation);

        printResult();


   }

   
   /** 
    * @param in
    * @return double
    */
   public static double setNumber(Scanner in)
   {
        System.out.println("Enter a number");
        double number = in.nextDouble();
        return number;
   }

   
   /** 
    * @param in
    */
   public static void setOperation(Scanner in)
   {    
        System.out.println("Enter an operation");
        operation = in.next().charAt(0);
   }

   public static void printResult()
   {
       if(operation == ' ')
       {
            System.out.println(num1 + "^(" + num2 + ") = " + result);
       }
       else
       {
            System.out.println(num1 + " " + operation + " " + num2 + " = " + result);
       }
       
   }
   
   private static double num1, num2, result;
   private static char operation = ' ';

}
