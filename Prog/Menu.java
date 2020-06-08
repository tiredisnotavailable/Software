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
          System.out.println("4. ax^2 + bx + c = 0");
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
              case 4: 
                   quadraticEquation(in);
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
   public static void quadraticEquation(Scanner in) throws Exceptions
   {
          System.out.println("a = ");
          double a = setNumber(in);
          System.out.println("b = ");
          double b = setNumber(in);
          System.out.println("c = ");
          double c = setNumber(in);
          double result[] = new double[2];
          result = Calculator.quadraticEquation(a, b, c);
          printResultQuadraticEquation(result);
   }

   
   /** 
    * @param in
    * @throws Exceptions
    */
   public static void trigonometry(Scanner in) throws Exceptions
   {
          System.out.println("cos/sin/tan/ctan");
          String function = setFunction(in);
          double num = setNumber(in);

          double result = Calculator.trigonometry(num, function);

          printResultTrigonometry(num, function, result);
   }

   
   /** 
    * @param in
    * @throws Exceptions
    */
   public static void raiseNumber(Scanner in) throws Exceptions
   {
          double num1 = setNumber(in);
          double num2 = setNumber(in);


          double result = Calculator.pow(num1, num2);

          printResultRaiseNumber(num1, num2, result);
   }

   
   /** 
    * @param in
    * @throws Exceptions
    */
   public static void calculate(Scanner in) throws Exceptions
   {
          double num1 = setNumber(in);
          double num2 = setNumber(in);
          char operation = setOperation(in);

          double result = Calculator.calculate(num1, num2, operation);

          printResultCalculate(num1, num2, operation, result);
   }

   
   /** 
    * @param in
    * @return String
    */
   public static String setFunction(Scanner in)
   {
          System.out.print("Enter a function: ");
          String function = in.next();
          return function;
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
   public static char setOperation(Scanner in)
   {    
          System.out.print("Enter an operation: ");
          char operation = in.next().charAt(0);
          return operation;
   }

   
   /** 
    * @param num1
    * @param num2
    * @param operation
    * @param result
    */
   public static void printResultCalculate(double num1, double num2, double operation, double result)
   {     
          System.out.println(num1 + " " + operation + " " + num2 + " = " + result);
   }

   
   /** 
    * @param num1
    * @param num2
    * @param result
    */
   public static void printResultRaiseNumber(double num1, double num2, double result)
   {
          System.out.println(num1 + "^(" + num2 + ") = " + result);
   }

   
   /** 
    * @param num
    * @param function
    * @param result
    */
   public static void printResultTrigonometry(double num, String function, double result)
   {
          System.out.println(function + "(" + num + ") = " + result);
   }
   
   
   /** 
    * @param result
    */
   public static void printResultQuadraticEquation(double[] result)
   {
        if(result[0] == result[1])
        {
               System.out.println("x = " + result[0]);
        }
        else
        {
               System.out.println("x1 = " + result[0]);
               System.out.println("x2 = " + result[1]); 
        }
   }
   


}
