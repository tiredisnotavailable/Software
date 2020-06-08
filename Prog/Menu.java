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
          System.out.println("3. Trigonometric function");
          Scanner in = new Scanner(System.in);
          int i = in.nextInt();
          switch (i) 
          {
               case 1:
                    raiseNumber(in);
                    break;
               case 2:
                    calculate(in);
                    break;
               case 3:
                    trigonometry(in);
               default:
                    in.close();
                    throw new Exceptions("Wrong number");
          } 
          in.close();
   }

   public static void trigonometry(Scanner in) throws Exceptions
   {
          System.out.println("cos/sin/tan/ctan");
          setFunction(in);
          num1 = setNumber(in);

          result = Calculator.trigonometry(num1, function);

          printResultTrigonometry();
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

          printResultRaiseNumber();
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

          printResultCalculate();
   }

   public static void setFunction(Scanner in)
   {
          System.out.print("Enter a function: ");
          function = in.next();
   }
   
   /** 
    * @param in
    * @return double
    */
   public static double setNumber(Scanner in)
   {
          System.out.print("Enter a number: ");
          double number = in.nextDouble();
          return number;
   }

   
   /** 
    * @param in
    */
   public static void setOperation(Scanner in)
   {    
          System.out.print("Enter an operation: ");
          operation = in.next().charAt(0);
   }

   public static void printResultCalculate()
   {     
          System.out.println(num1 + " " + operation + " " + num2 + " = " + result);
   }

   public static void printResultRaiseNumber()
   {
          System.out.println(num1 + "^(" + num2 + ") = " + result);
   }

   public static void printResultTrigonometry()
   {
          System.out.println(function + "(" + num1 + ") = " + result);
   }
   
   private static double num1 = 0, num2 = 0, result = 0;
   private static char operation = ' ';
   private static String function = " ";


}
